package com.github.dcendents.mybatis.jaxws.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.github.dcendents.mybatis.jaxws.db.model.Film;

@WebService
public interface JaxwsService {

	@WebMethod
	Film selectFilm(@WebParam(name = "id") int id);
	
	@WebMethod
	boolean insertFilm(@WebParam(name = "film") Film film);
}
