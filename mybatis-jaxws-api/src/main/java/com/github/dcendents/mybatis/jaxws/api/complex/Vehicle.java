package com.github.dcendents.mybatis.jaxws.api.complex;

import java.util.List;

import lombok.Data;

@Data
public abstract class Vehicle {

	private int noWheels;
	private String color;
	private List<Passenger> passengers;
	
	public abstract int getCapacity();
}
