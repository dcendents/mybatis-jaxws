package com.github.dcendents.mybatis.jaxws.web;


import javax.inject.Inject;
import javax.jws.WebService;

import org.mybatis.cdi.Mapper;
import org.mybatis.cdi.Transactional;

import com.github.dcendents.mybatis.jaxws.db.client.ActorMapper;
import com.github.dcendents.mybatis.jaxws.db.client.CategoryMapper;
import com.github.dcendents.mybatis.jaxws.db.client.FilmMapper;
import com.github.dcendents.mybatis.jaxws.db.model.Actor;
import com.github.dcendents.mybatis.jaxws.db.model.Category;
import com.github.dcendents.mybatis.jaxws.db.model.Film;

@WebService
public class JaxwsServiceImpl implements JaxwsService {

	@Inject
	@Mapper
	private FilmMapper filmMapper;
	@Inject
	@Mapper
	private ActorMapper actorMapper;
	@Inject
	@Mapper
	private CategoryMapper categoryMapper;

	@Override
	@Transactional
	public int insertFilm(Film film) {
		filmMapper.insert(film);

		for (Actor actor : film.getActors()) {
			if (actor.getId() == null) {
				actorMapper.insert(actor);
			}
			actorMapper.insertFilmActor(actor, film);
		}

		for (Category category : film.getCategories()) {
			if (category.getId() == null) {
				categoryMapper.insert(category);
			}
			categoryMapper.insertFilmCategory(category, film);
		}

		return film.getId();
	}

	@Override
	public Film selectFilm(int id) {
		Film film = null;

		film = filmMapper.selectByPrimaryKeyWithAssociations(id);

		return film;
	}
}
