package com.github.dcendents.mybatis.jaxws.db.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.github.dcendents.mybatis.jaxws.db.model.gen.PassengerGen;

@NoArgsConstructor
@ToString(callSuper = true)
// Do not use any added fields for equals and hashcode
@EqualsAndHashCode(callSuper = true, of = { })
public class Passenger extends PassengerGen {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Vehicle vehicle;

	public com.github.dcendents.mybatis.jaxws.api.complex.Passenger convert() {
		passenger.setVehicle(vehicle.getVehicle());
		
		return passenger;
	}
}
