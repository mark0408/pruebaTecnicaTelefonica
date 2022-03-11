package com.ejercicio.telefonica.demo.repository;

import com.ejercicio.telefonica.demo.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
  Optional<Cliente> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String NumeroDocumento);
}
