package com.github.dcendents.mybatis.jaxws.db.model;

import java.util.List;

public interface Vehicle {

	String getColor();

	void setColor(String color);

	Integer getNoWheels();

	void setNoWheels(Integer nowheels);

	List<Passenger> getPassengers();

	void setPassengers(List<Passenger> passengers);
	
	com.github.dcendents.mybatis.jaxws.api.complex.Vehicle getVehicle();
}
