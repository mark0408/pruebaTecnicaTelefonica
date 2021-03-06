package com.ejercicio.telefonica.demo.controller;

import com.ejercicio.telefonica.demo.dto.LineaMovilYOfertaPorClienteDTOResponse;
import com.ejercicio.telefonica.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  ClienteService clienteService;

  @GetMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Respuesta Correcta",
                  content = @Content(schema = @Schema(implementation = LineaMovilYOfertaPorClienteDTOResponse.class)))
  })
  @Operation(summary = "Obtener todas las  lineas moviles y ofertas por cliente", tags = {"cliente"})
  public ResponseEntity<LineaMovilYOfertaPorClienteDTOResponse> obtenerLineaMovilYOfertaPorCliente(
                                                    @Parameter(description="numero del tipo de documento")
                                                    @RequestParam(required = true, value="numeroDocumento") String  numeroDocumento,
                                                    @Parameter(description="nombre del tipo de documento")
                                                    @RequestParam(required = true, value="tipoDocumento") String tipoDocumento){
    return ResponseEntity.ok(clienteService.obtenerLineaMovilYOfertaPorCliente(numeroDocumento, tipoDocumento));
  }
  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Respuesta Correcta",
                  content = @Content(schema = @Schema(implementation = LineaMovilYOfertaPorClienteDTOResponse.class)))
  })
  @Operation(summary = "Obtener todos los clientes cons sus lineas moviles y ofertas", tags = {"cliente"})
  public ResponseEntity<List<LineaMovilYOfertaPorClienteDTOResponse>> obtenerClientesLineaMovilOfertasPorFechas(
          @Parameter(description="fecha de inicio, formato dd/MM/yyyy")
          @RequestParam(required = true, value="fechaInicio") String  fechaInicio,
          @Parameter(description="fecha de fin, formato dd/MM/yyyy")
          @RequestParam(required = true, value="fechaFin") String fechaFin){
    return ResponseEntity.ok(clienteService.obtenerClientesLineaMovilOfertasPorFechas(fechaInicio, fechaFin));
  }

}
