package com.github.dcendents.mybatis.jaxws.api;

public enum Rating {

	G("G"),
	PG("PG"),
	PG13("PG-13"),
	R("R"),
	NC17("NC-17");

	private String value;
	
	private Rating(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static Rating fromValue(String value) {
		Rating rating = null;
		
		for(Rating theRating : values()) {
			if( theRating.getValue().equals(value) ) {
				rating = theRating;
				break;
			}
		}
		
		return rating; 
	}
}
