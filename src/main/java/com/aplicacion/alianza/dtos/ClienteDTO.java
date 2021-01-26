package com.aplicacion.alianza.dtos;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String sharedKey;
	private String name;
	private String phone;
	private String email;
	private Date startDate;
	private Date endDate;
	

}
