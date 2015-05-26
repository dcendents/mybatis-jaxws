package com.github.dcendents.mybatis.jaxws.api.complex;

import lombok.Data;

@Data
public class Passenger {

	private Vehicle vehicle;
	private String firstName;
	private String lastName;
	
}
