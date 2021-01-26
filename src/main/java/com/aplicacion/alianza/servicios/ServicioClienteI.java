package com.aplicacion.alianza.servicios;

import java.util.List;

import com.aplicacion.alianza.dtos.ClienteDTO;

public interface ServicioClienteI {

	public ClienteDTO crearCliente(ClienteDTO clienteDTO);
	
	public List<ClienteDTO> buscarClientePorSharedKey(String sharedKey);
	
	public List<ClienteDTO> listarClientes();
}
