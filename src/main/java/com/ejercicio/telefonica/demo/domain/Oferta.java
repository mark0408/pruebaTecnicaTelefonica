package com.ejercicio.telefonica.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Oferta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @JoinColumn(name = "lineaMovil", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private LineaMovil lineaMovil;
  @Column(nullable = false)
  private String codigoOferta;
  @Column
  private String descripcionOferta;
  @Column(nullable = false)
  private Date fechaInicio;
  @Column(nullable = false)
  private Date fechaFinal;
}
