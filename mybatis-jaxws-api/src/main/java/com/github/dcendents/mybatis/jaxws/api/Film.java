package com.github.dcendents.mybatis.jaxws.api;

import java.util.List;

import lombok.Data;

@Data
public class Film {

	private String title;
	private String description;
	private Language language;
	private int year;
	private Short length;
	private String[] categories;
	private List<Actor> actors;
	
}
