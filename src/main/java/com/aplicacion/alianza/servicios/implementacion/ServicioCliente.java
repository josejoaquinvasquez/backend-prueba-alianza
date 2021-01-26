package com.aplicacion.alianza.servicios.implementacion;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.aplicacion.alianza.dtos.ClienteDTO;
import com.aplicacion.alianza.entidades.Cliente;
import com.aplicacion.alianza.repositorio.RepositorioCliente;
import com.aplicacion.alianza.repositorio.especificaciones.ClienteEspecificaciones;
import com.aplicacion.alianza.servicios.ServicioClienteI;

@Service
public class ServicioCliente implements ServicioClienteI{
	private Logger logger = LogManager.getLogger(ServicioCliente.class);
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	 @Autowired
	 private ModelMapper modelMapper;
	
	@Override
	public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
		logger.info("Ejecucion del método crearCliente...");
	    Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
	    logger.info("Finalizacion de crearCliente...");
        return modelMapper.map(repositorioCliente.save(cliente), ClienteDTO.class);
	}

	@Override
	public List<ClienteDTO> buscarClientePorSharedKey(String sharedKey) {
		logger.info("Ejecucion de buscar cliente por sharedkey..." + sharedKey);
		List<Cliente> listCliente = repositorioCliente.findAll(Specification.where(ClienteEspecificaciones.conSharedKey(sharedKey)));
		logger.info("Finalizacion de buscar cliente por sharedkey...");
		return modelMapper.map(listCliente,  new TypeToken<List<ClienteDTO>>() {}.getType());
	
	}

	@Override
	public List<ClienteDTO> listarClientes() {
		logger.info("Ejecucion de buscar todos los cliente ..." );
		List<Cliente> listCliente = repositorioCliente.findAll();
		logger.info("Finalizaciòn de buscar todos los cliente ..." );
		return modelMapper.map(listCliente,  new TypeToken<List<ClienteDTO>>() {}.getType());
		
	}
	
	

}
