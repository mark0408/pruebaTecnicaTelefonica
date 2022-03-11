package com.ejercicio.telefonica.demo.service;

import com.ejercicio.telefonica.demo.domain.Cliente;
import com.ejercicio.telefonica.demo.domain.LineaMovil;
import com.ejercicio.telefonica.demo.domain.Oferta;
import com.ejercicio.telefonica.demo.dto.LineaMovilDTOResponse;
import com.ejercicio.telefonica.demo.dto.LineaMovilYOfertaPorClienteDTOResponse;
import com.ejercicio.telefonica.demo.dto.OfertaDTO;
import com.ejercicio.telefonica.demo.repository.ClienteRepository;
import com.ejercicio.telefonica.demo.repository.LineaMovilRepository;
import com.ejercicio.telefonica.demo.repository.OfertaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
@Service
@Transactional
public class ClienteService {

  @Autowired
  ClienteRepository clienteRepository;
  @Autowired
  LineaMovilRepository lineaMovilRepository;
  @Autowired
  OfertaRepository ofertaRepository;

  public LineaMovilYOfertaPorClienteDTOResponse obtenerLineaMovilYOfertaPorCliente(String numeroDocumento, String tipoDocumento){
    log.info("Entro al metodo obtenerLineaMovilYOfertaPorCliente");
    LineaMovilYOfertaPorClienteDTOResponse response = new LineaMovilYOfertaPorClienteDTOResponse();
    Optional<Cliente> optionalCliente = clienteRepository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento,numeroDocumento);
    if(optionalCliente.isPresent()){
      Cliente cliente = optionalCliente.get();
      List<LineaMovil> lineasMoviles = lineaMovilRepository.findByCliente(cliente);
      response = crearLineaMovilYOfertaPorClienteDTOResponse(cliente, lineasMoviles);
    }else{
      //lanzar error
      log.error("Error no se encuentra cliente");
    }
    log.info("Salio del metodo obtenerLineaMovilYOfertaPorCliente");
    return response;
  }
  private LineaMovilYOfertaPorClienteDTOResponse crearLineaMovilYOfertaPorClienteDTOResponse(Cliente cliente, List<LineaMovil> lineaMovilList){
    LineaMovilYOfertaPorClienteDTOResponse response = new LineaMovilYOfertaPorClienteDTOResponse();

    response.setNombreCompleto(cliente.getNombreCompleto());
    response.setNumeroDocumento(cliente.getNumeroDocumento());
    response.setTipoDocumento(cliente.getTipoDocumento());
    List<LineaMovilDTOResponse> lineaMovilDTOResponseList = crearLineaMovilDTOResponseList(lineaMovilList);
    response.setLineasMoviles(lineaMovilDTOResponseList);
    return response;
  }
  private List<LineaMovilDTOResponse> crearLineaMovilDTOResponseList(List<LineaMovil> lineaMovilList){
    List<LineaMovilDTOResponse> responses = new ArrayList<>();
    //obtener listado de id de LineaMovil

    //buscar en bd las ofertas y retornar
    List<Oferta> ofertaList = ofertaRepository.findByLineaMovilIn(lineaMovilList);
    lineaMovilList.stream().forEach( lin ->{
      LineaMovilDTOResponse lineaMovilDTOResponse = new LineaMovilDTOResponse();
      lineaMovilDTOResponse.setNombrePlan(lin.getNombrePlan());
      lineaMovilDTOResponse.setTipo(lin.getTipo());
      lineaMovilDTOResponse.setEstado(lin.getEstado());
      lineaMovilDTOResponse.setNumeroTelefono(lin.getNumeroTelefono());
      List<OfertaDTO> ofertas = crearOfertaDTOList(
              ofertaList.stream().filter(of-> of.getLineaMovil().equals(lin)).collect(
                      Collectors.toList())
      );
      lineaMovilDTOResponse.setOfertas(ofertas);
    responses.add(lineaMovilDTOResponse);
    });

    return responses;
  }
  private List<OfertaDTO> crearOfertaDTOList(List<Oferta> ofertas){
    List<OfertaDTO> ofertaDTOList = new ArrayList<>();

    ofertas.forEach(oferta->{
      OfertaDTO temporal = new OfertaDTO();
      temporal.setCodigoOferta(oferta.getCodigoOferta());
      temporal.setDescripcionOferta(oferta.getDescripcionOferta());
      temporal.setFechaFinal(oferta.getFechaFinal());
      temporal.setFechaInicio(oferta.getFechaInicio());
      temporal.setId(oferta.getId());
      ofertaDTOList.add(temporal);
    });

    return ofertaDTOList;
  }

  public List<LineaMovilYOfertaPorClienteDTOResponse> obtenerClientesLineaMovilOfertasPorFechas(String fechaIni, String fechaFin){
    log.info("Entro al metodo obtenerClientesLineaMovilOfertasPorFechas");
    List<LineaMovilYOfertaPorClienteDTOResponse> response = new ArrayList<>();

    List<Oferta> ofertaList = obtenerOfertasPorFechas(fechaIni,fechaFin);

    response = obtenerClientesPorOfertas(ofertaList);

    response = filtrarLineasMoviles(response);
    log.info("Salio del metodo obtenerClientesLineaMovilOfertasPorFechas");
    return response;
  }
  private List<Oferta> obtenerOfertasPorFechas(String fechaIni,String fechaFin){
    List<Oferta> response = new ArrayList<>();
    try {
      if(fechaIni != null && fechaFin != null){
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        response = ofertaRepository.findByFechaInicioLessThanEqualAndFechaFinalGreaterThanEqual(format.parse(fechaFin),format.parse(fechaIni));
      }
      else{
        //lanzar error
      }
    }catch (Exception e){

    }

    return response;
  }
  private List<LineaMovilYOfertaPorClienteDTOResponse> obtenerClientesPorOfertas(List<Oferta> ofertaList){
    List<LineaMovilYOfertaPorClienteDTOResponse> response = new ArrayList<>();
    Set<LineaMovil> lineaMovilList = ofertaList.stream().map(Oferta::getLineaMovil).collect(Collectors.toSet());
    Set<Cliente> clienteList = lineaMovilList.stream().map(LineaMovil::getCliente).collect(Collectors.toSet());
    response =crearLineaMovilYOfertaPorClienteDTOResponseList(clienteList,lineaMovilList);

    return response;
  }
  private List<LineaMovilYOfertaPorClienteDTOResponse> crearLineaMovilYOfertaPorClienteDTOResponseList(Set<Cliente> clienteList,Set<LineaMovil> lineaMovilList){
    List<LineaMovilYOfertaPorClienteDTOResponse> responses = new ArrayList<>();
    clienteList.forEach(cliente -> {
      LineaMovilYOfertaPorClienteDTOResponse temporal = crearLineaMovilYOfertaPorClienteDTOResponse(cliente,lineaMovilList.stream().filter(linea->linea.getCliente().equals(cliente)).collect(
              Collectors.toList()));
      responses.add(temporal);
    });
    return responses;
  }
  private List<LineaMovilYOfertaPorClienteDTOResponse> filtrarLineasMoviles(List<LineaMovilYOfertaPorClienteDTOResponse> dtoResponse){
   return dtoResponse.stream()
                     .filter(dto -> lineasActivasYMayor3(dto.getLineasMoviles()))
                     .collect(Collectors.toList());
  }
  private boolean lineasActivasYMayor3(List<LineaMovilDTOResponse> lineasMoviles){
    return lineasMoviles.stream().filter(linea->linea.getEstado().equals("activo")).count()>=3;
  }
}
