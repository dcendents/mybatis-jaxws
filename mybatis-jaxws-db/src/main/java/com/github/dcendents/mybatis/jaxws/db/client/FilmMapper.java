package com.github.dcendents.mybatis.jaxws.db.client;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

import com.github.dcendents.mybatis.jaxws.db.client.gen.FilmMapperGen;
import com.github.dcendents.mybatis.jaxws.db.model.Film;

public interface FilmMapper extends FilmMapperGen {

	Film selectByPrimaryKeyWithAssociations(@Param("id") Integer id);

    /**
     * Override to correctly cast rating as mpaa_rating enum
     */
    @Insert({
        "insert into public.film (film_id, title, ",
        "description, release_year, ",
        "language_id, ",
        "rental_duration, rental_rate, ",
        "length, replacement_cost, ",
        "rating, ",
        "last_update, special_features)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{year,jdbcType=INTEGER}, ",
        "#{language,jdbcType=SMALLINT,typeHandler=com.github.dcendents.mybatis.jaxws.db.IdTableHandler}, ",
        "#{rentalDuration,jdbcType=SMALLINT}, #{rentalRate,jdbcType=NUMERIC}, ",
        "#{length,jdbcType=SMALLINT}, #{replacementCost,jdbcType=NUMERIC}, ",
        "#{rating,jdbcType=VARCHAR,typeHandler=com.github.dcendents.mybatis.jaxws.db.RatingHandler}::mpaa_rating, ",
        "#{modifiedOn,jdbcType=TIMESTAMP}, #{specialFeatures,jdbcType=ARRAY})"
    })
    @SelectKey(statement="select nextval('public.film_film_id_seq')", keyProperty="id", before=true, resultType=Integer.class)
    @Override
    int insert(Film record);
}
