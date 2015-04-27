package com.github.dcendents.mybatis.jaxws.db.client;

import org.apache.ibatis.annotations.Param;

import com.github.dcendents.mybatis.jaxws.db.client.gen.FilmMapperGen;
import com.github.dcendents.mybatis.jaxws.db.model.Film;

public interface FilmMapper extends FilmMapperGen {

	Film selectByPrimaryKeyWithAssociations(@Param("id") Integer id);
}
