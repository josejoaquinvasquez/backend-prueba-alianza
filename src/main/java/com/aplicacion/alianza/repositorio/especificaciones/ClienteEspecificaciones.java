package com.aplicacion.alianza.repositorio.especificaciones;

import org.springframework.data.jpa.domain.Specification;

import com.aplicacion.alianza.entidades.Cliente;



public class ClienteEspecificaciones {

	public static Specification<Cliente> conSharedKey(String sharedKey) {
		return (root, query, cb) -> cb.equal(root.get("sharedKey"), sharedKey);
	}
}
