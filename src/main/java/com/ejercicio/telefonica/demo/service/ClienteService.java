package com.ejercicio.telefonica.demo.service;

import com.ejercicio.telefonica.demo.domain.Cliente;
import com.ejercicio.telefonica.demo.domain.LineaMovil;
import com.ejercicio.telefonica.demo.domain.Oferta;
import com.ejercicio.telefonica.demo.dto.LineaMovilDTOResponse;
import com.ejercicio.telefonica.demo.dto.LineaMovilYOfertaPorClienteDTOResponse;
import com.ejercicio.telefonica.demo.repository.ClienteRepository;
import com.ejercicio.telefonica.demo.repository.LineaMovilRepository;
import com.ejercicio.telefonica.demo.repository.OfertaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    LineaMovilYOfertaPorClienteDTOResponse response = new LineaMovilYOfertaPorClienteDTOResponse();
    // verificar que exista el cliente
    Optional<Cliente> optionalCliente = clienteRepository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento,numeroDocumento);
    if(optionalCliente.isPresent()){
      Cliente cliente = optionalCliente.get();
      //Obtener todas las lineas moviles de ese cliente
      List<LineaMovil> lineasMoviles = lineaMovilRepository.findByCliente(cliente);
      //crear LineaMovilYOfertaPorClienteDTOResponse
      response = crearLineaMovilYOfertaPorClienteDTOResponse(cliente, lineasMoviles);
    }else{
      //lanzar error
    }

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
      lineaMovilDTOResponse.setOfertas(ofertaList.stream().filter(of-> of.getLineaMovil().equals(lin)).collect(
              Collectors.toList()));
    responses.add(lineaMovilDTOResponse);
    });
    //ofertaList.stream().map()

    return responses;
  }

  public List<LineaMovilYOfertaPorClienteDTOResponse> obtenerClientesLineaMovilOfertasPorFechas(String fechaIni, String fechaFin){
    List<LineaMovilYOfertaPorClienteDTOResponse> response = new ArrayList<>();
    //obtener las ofertas por un rango de fechas
    List<Oferta> ofertaList = obtenerOfertasPorFechas(fechaIni,fechaFin);

    //buscar al cliente que tenga 3 lineas moviles
    return response;
  }

  private List<Oferta> obtenerOfertasPorFechas(String fechaIni,String fechaFin){
    List<Oferta> response = new ArrayList<>();
    if(fechaIni != null && fechaFin != null){

      }else{
        //buscar por una de las fechas
      }
    return response;
  }
}
