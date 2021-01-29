package com.aplicacion.alianza.controladores;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacion.alianza.dtos.ClienteDTO;
import com.aplicacion.alianza.servicios.ServicioClienteI;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ControladorCliente {

	private Logger logger = LogManager.getLogger(ControladorCliente.class);
	
	@Autowired
	private ServicioClienteI servicioCliente;
	
	/**
     * Crear Cliente
     * @param ClienteDTO
     * @return List<ClienteDTO>
     */
    @PostMapping("/crear")
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
        	logger.info("Inicia ejecuciòn del servicio crear cliente");
            ClienteDTO cliente = servicioCliente.crearCliente(clienteDTO);
            logger.info("Final ejecuciòn del servicio crear cliente");
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    
    /**
     * Listar clientes por sharedKey
     * @param ClienteDTO
     * @return List<ClienteDTO>
     */
    @GetMapping("/buscar-por-sharedkey")
    public ResponseEntity<List<ClienteDTO>> listarClientePorSharedKey(@RequestParam(value = "sharedkey", required = true) String sharedKey) {
        try {
        	logger.info("Inicia ejecuciòn del servicio buscar-por-sharedkey");
        	List<ClienteDTO> listaClientes = servicioCliente.buscarClientePorSharedKey(sharedKey);
        	logger.info("Final ejecuciòn del servicio buscar-por-sharedkey");
            return ResponseEntity.ok(listaClientes);
        } catch (Exception e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    
    /**
     * Listar todos los  Clientes
     * @return
     */
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarTodosClientes() {
        try {
        	logger.info("Inicia ejecuciòn del servicio listar todos los clientes");
            List<ClienteDTO> listaClientes = servicioCliente.listarClientes();
            logger.info("Final ejecuciòn del servicio listar todos los clientes");
            return ResponseEntity.ok(listaClientes);
        } catch (Exception e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
