package com.github.dcendents.mybatis.jaxws.db.model;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.github.dcendents.mybatis.jaxws.db.model.gen.ActorGen;

@NoArgsConstructor
@ToString(callSuper = true)
// Do not use any added fields for equals and hashcode
@EqualsAndHashCode(callSuper = true, of = { })
public class Actor extends ActorGen {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private List<Film> film;

	public com.github.dcendents.mybatis.jaxws.api.Actor convert() {
		return actor;
	}
}
