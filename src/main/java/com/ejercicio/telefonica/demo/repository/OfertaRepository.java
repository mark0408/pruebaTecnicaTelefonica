package com.ejercicio.telefonica.demo.repository;

import com.ejercicio.telefonica.demo.domain.LineaMovil;
import com.ejercicio.telefonica.demo.domain.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {
  List<Oferta> findByLineaMovilIn(List<LineaMovil> lineaMovilList);
  List<Oferta> findByFechaInicioLessThanEqualAndFechaFinalGreaterThanEqual( Date fechaFin, Date fechaInicio);
}
