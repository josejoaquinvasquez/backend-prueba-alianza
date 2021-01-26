package com.aplicacion.alianza.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.aplicacion.alianza.entidades.Cliente;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

}
