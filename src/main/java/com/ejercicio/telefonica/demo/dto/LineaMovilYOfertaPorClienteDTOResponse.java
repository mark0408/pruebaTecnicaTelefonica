package com.ejercicio.telefonica.demo.dto;

import com.ejercicio.telefonica.demo.domain.LineaMovil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaMovilYOfertaPorClienteDTOResponse implements Serializable {

    private String nombreCompleto;
    private String numeroDocumento;
    private String tipoDocumento;
    private List<LineaMovilDTOResponse> lineasMoviles;

}
