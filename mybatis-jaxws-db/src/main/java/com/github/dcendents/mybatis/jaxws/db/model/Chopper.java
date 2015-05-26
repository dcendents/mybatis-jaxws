package com.github.dcendents.mybatis.jaxws.db.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.github.dcendents.mybatis.jaxws.api.complex.Vehicle;
import com.github.dcendents.mybatis.jaxws.db.model.gen.ChopperGen;

@NoArgsConstructor
@ToString(callSuper = true)
// Do not use any added fields for equals and hashcode
@EqualsAndHashCode(callSuper = true, of = { })
public class Chopper extends ChopperGen {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private List<Passenger> passengers;

	public com.github.dcendents.mybatis.jaxws.api.complex.Chopper convert() {

		List<com.github.dcendents.mybatis.jaxws.api.complex.Passenger> apiPassengers = new ArrayList<>(passengers.size());
		for (Passenger passenger : passengers) {
			apiPassengers.add(passenger.convert());
		}
		chopper.setPassengers(apiPassengers);

		return chopper;
	}

	@Override
	public Vehicle getVehicle() {
		return convert();
	}

}
