package com.ejercicio.telefonica.demo.repository;

import com.ejercicio.telefonica.demo.domain.Cliente;
import com.ejercicio.telefonica.demo.domain.LineaMovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineaMovilRepository extends JpaRepository<LineaMovil, Long> {
  List<LineaMovil> findByCliente(Cliente cliente);
}
