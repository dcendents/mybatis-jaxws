package com.github.dcendents.mybatis.jaxws.db.client.gen;

import com.github.dcendents.mybatis.jaxws.db.model.Film;
import com.github.dcendents.mybatis.jaxws.db.model.filter.FilmFilter;
import com.github.dcendents.mybatis.jaxws.db.model.gen.FilmGen;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface FilmMapperGen {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    int countByFilter(FilmFilter filter);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    int deleteByFilter(FilmFilter filter);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    @Delete({
        "delete from public.film",
        "where film_id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    @Insert({
        "insert into public.film (film_id, title, ",
        "description, release_year, ",
        "language_id, ",
        "rental_duration, rental_rate, ",
        "length, replacement_cost, ",
        "last_update, special_features, ",
        "fulltext)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{year,jdbcType=INTEGER}, ",
        "#{language,jdbcType=SMALLINT,typeHandler=com.github.dcendents.mybatis.jaxws.db.IdTableHandler}, ",
        "#{rentalDuration,jdbcType=SMALLINT}, #{rentalRate,jdbcType=NUMERIC}, ",
        "#{length,jdbcType=SMALLINT}, #{replacementCost,jdbcType=NUMERIC}, ",
        "#{modifiedOn,jdbcType=TIMESTAMP}, #{specialFeatures,jdbcType=ARRAY}, ",
        "#{fulltext,jdbcType=OTHER})"
    })
    @SelectKey(statement="select nextval('public.film_film_id_seq')", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Film record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    int insertSelective(Film record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    List<Film> selectByFilterWithRowbounds(FilmFilter filter, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    List<Film> selectByFilter(FilmFilter filter);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "f.film_id as f_film_id, f.title as f_title, f.description as f_description, ",
        "f.release_year as f_release_year, f.language_id as f_language_id, f.rental_duration as f_rental_duration, ",
        "f.rental_rate as f_rental_rate, f.length as f_length, f.replacement_cost as f_replacement_cost, ",
        "f.last_update as f_last_update, f.special_features as f_special_features, f.fulltext as f_fulltext",
        "from public.film f",
        "where f.film_id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Film selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    int updateByFilterSelective(@Param("record") Film record, @Param("example") FilmFilter filter);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    int updateByFilter(@Param("record") Film record, @Param("example") FilmFilter filter);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Film record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.film
     *
     * @mbggenerated
     */
    @Update({
        "update public.film",
        "set title = #{title,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "release_year = #{year,jdbcType=INTEGER},",
          "language_id = #{language,jdbcType=SMALLINT,typeHandler=com.github.dcendents.mybatis.jaxws.db.IdTableHandler},",
          "rental_duration = #{rentalDuration,jdbcType=SMALLINT},",
          "rental_rate = #{rentalRate,jdbcType=NUMERIC},",
          "length = #{length,jdbcType=SMALLINT},",
          "replacement_cost = #{replacementCost,jdbcType=NUMERIC},",
          "last_update = #{modifiedOn,jdbcType=TIMESTAMP},",
          "special_features = #{specialFeatures,jdbcType=ARRAY},",
          "fulltext = #{fulltext,jdbcType=OTHER}",
        "where film_id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Film record);
}