package com.github.dcendents.mybatis.jaxws.db.client;

import org.apache.ibatis.annotations.Param;

import com.github.dcendents.mybatis.jaxws.db.client.gen.CategoryMapperGen;
import com.github.dcendents.mybatis.jaxws.db.model.Category;
import com.github.dcendents.mybatis.jaxws.db.model.Film;

public interface CategoryMapper extends CategoryMapperGen {

	int insertFilmCategory(@Param("category") Category category, @Param("film") Film film);

}
