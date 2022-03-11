package com.ejercicio.telefonica.demo.dto;

import com.ejercicio.telefonica.demo.domain.LineaMovil;
import com.ejercicio.telefonica.demo.domain.Oferta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfertaDTO {

  private Long id;
  private String codigoOferta;
  private String descripcionOferta;
  private Date fechaInicio;
  private Date fechaFinal;

}
