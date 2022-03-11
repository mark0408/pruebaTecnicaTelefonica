package com.ejercicio.telefonica.demo.dto;

import com.ejercicio.telefonica.demo.domain.Oferta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaMovilDTOResponse implements Serializable {

  private String numeroTelefono;
  private String estado;
  private String tipo;
  private String nombrePlan;
  private List<Oferta> ofertas;
}
