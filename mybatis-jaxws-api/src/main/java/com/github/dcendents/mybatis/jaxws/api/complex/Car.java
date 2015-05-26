package com.github.dcendents.mybatis.jaxws.api.complex;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Car extends Vehicle {
	
	private int noDoors;
	
	@Override
	public int getCapacity() {
		return 5;
	}
	
}
