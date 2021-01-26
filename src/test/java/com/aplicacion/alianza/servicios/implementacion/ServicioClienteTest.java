package com.aplicacion.alianza.servicios.implementacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.aplicacion.alianza.repositorio.RepositorioCliente;

import com.aplicacion.alianza.entidades.Cliente;

public class ServicioClienteTest {
	
	private RepositorioCliente repositorioCliente;
	
	@Before
	public void setup() {
		repositorioCliente = mock(RepositorioCliente.class);
	}
	
	@Test
	public void listarClientesTest() {
		List<Cliente> clientesTest = new ArrayList<Cliente>();
		Cliente clienteTest = new Cliente();
		
		clienteTest.setSharedKey("prueba");
		clienteTest.setName("maria");
		clienteTest.setPhone("47899623");
		clienteTest.setEmail("maria@gmail.com");
		clienteTest.setStartDate(new Date());
		clienteTest.setEndDate(new Date());
		
		clientesTest.add(clienteTest);
		
		when(repositorioCliente.findAll()).thenReturn(clientesTest); 
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = repositorioCliente.findAll();
		
		assertEquals(clientes, clientesTest);
	}
	
	@Test
	public void buscarClientePorSharedKeyTest() {
		List<Cliente> clientesTest = new ArrayList<Cliente>();
		Cliente clienteTest = new Cliente();
		
		clienteTest.setSharedKey("prueba");
		clienteTest.setName("maria");
		clienteTest.setPhone("47899623");
		clienteTest.setEmail("maria@gmail.com");
		clienteTest.setStartDate(new Date());
		clienteTest.setEndDate(new Date());
		
		clientesTest.add(clienteTest);
		
		when(repositorioCliente.findAll()).thenReturn(clientesTest); 
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = repositorioCliente.findAll();
	
		 Assert.assertEquals("prueba", clientes.get(0).getSharedKey());
	}
	
	@Test
	public void crearClienteTest() {
		Cliente clienteTest = new Cliente();
		
		clienteTest.setSharedKey("prueba");
		clienteTest.setName("maria");
		clienteTest.setPhone("47899623");
		clienteTest.setEmail("maria@gmail.com");
		clienteTest.setStartDate(new Date());
		clienteTest.setEndDate(new Date());
		
		when(repositorioCliente.save(clienteTest)).thenReturn(clienteTest); 
		
		Cliente cliente = new Cliente();
		cliente = repositorioCliente.save(clienteTest);
		
		assertEquals(cliente, clienteTest);
		
	}
	
	
}
