package com.github.dcendents.mybatis.jaxws.db.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.github.dcendents.mybatis.jaxws.api.complex.Vehicle;
import com.github.dcendents.mybatis.jaxws.db.model.gen.CarGen;

@NoArgsConstructor
@ToString(callSuper = true)
// Do not use any added fields for equals and hashcode
@EqualsAndHashCode(callSuper = true, of = {})
public class Car extends CarGen {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private List<Passenger> passengers;

	public com.github.dcendents.mybatis.jaxws.api.complex.Car convert() {

		List<com.github.dcendents.mybatis.jaxws.api.complex.Passenger> apiPassengers = new ArrayList<>(passengers.size());
		for (Passenger passenger : passengers) {
			apiPassengers.add(passenger.convert());
		}
		car.setPassengers(apiPassengers);

		return car;
	}

	@Override
	public Vehicle getVehicle() {
		return convert();
	}
}
