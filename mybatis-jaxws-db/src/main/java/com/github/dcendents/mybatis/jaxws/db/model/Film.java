package com.github.dcendents.mybatis.jaxws.db.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.github.dcendents.mybatis.jaxws.api.Language;
import com.github.dcendents.mybatis.jaxws.db.model.gen.FilmGen;

@NoArgsConstructor
@ToString(callSuper = true)
// Do not use any added fields for equals and hashcode
@EqualsAndHashCode(callSuper = true, of = { })
public class Film extends FilmGen {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private List<Actor> actors;

	@Getter
	@Setter
	private List<Category> categories;
	
	public com.github.dcendents.mybatis.jaxws.api.Film convert() {
		
		film.setLanguage(Language.valueOf(getLanguage().getName().trim()));
		
		List<com.github.dcendents.mybatis.jaxws.api.Actor> apiActors = new ArrayList<>(actors.size());
		for(Actor actor : actors ) {
			apiActors.add(actor.convert());
		}
		film.setActors(apiActors);
		
		String[] categoriesArray = new String[categories.size()];
		for(int i = 0; i < categoriesArray.length; i++ ) {
			categoriesArray[i] = categories.get(i).getName();
		}
		film.setCategories(categoriesArray);
		
		return film;
	}
}
