package com.github.dcendents.mybatis.jaxws.db.client;

import org.apache.ibatis.annotations.Param;

import com.github.dcendents.mybatis.jaxws.db.client.gen.ActorMapperGen;
import com.github.dcendents.mybatis.jaxws.db.model.Actor;
import com.github.dcendents.mybatis.jaxws.db.model.Film;

public interface ActorMapper extends ActorMapperGen {

	int insertFilmActor(@Param("actor") Actor actor, @Param("film") Film film);
}
