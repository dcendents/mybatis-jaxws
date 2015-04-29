package org.mybatis.jaxws.db;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.dcendents.mybatis.jaxws.api.Rating;
import com.github.dcendents.mybatis.jaxws.db.client.ActorMapper;
import com.github.dcendents.mybatis.jaxws.db.client.CategoryMapper;
import com.github.dcendents.mybatis.jaxws.db.client.FilmMapper;
import com.github.dcendents.mybatis.jaxws.db.client.LanguageMapper;
import com.github.dcendents.mybatis.jaxws.db.model.Actor;
import com.github.dcendents.mybatis.jaxws.db.model.Category;
import com.github.dcendents.mybatis.jaxws.db.model.Film;
import com.github.dcendents.mybatis.jaxws.db.model.Language;

public class InsertTest {

	@Test
	public void insertFilm() throws Exception {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			FilmMapper mapper = session.getMapper(FilmMapper.class);
			ActorMapper actorMapper = session.getMapper(ActorMapper.class);
			CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
			
			Film insertFilm = createFilm(session);
			mapper.insert(insertFilm);
			
			for( Actor actor : insertFilm.getActors() ) {
				if( actor.getId() == null ) {
					actorMapper.insert(actor);
				}
				actorMapper.insertFilmActor(actor, insertFilm);
			}
			
			for( Category category : insertFilm.getCategories() ) {
				if( category.getId() == null ) {
					categoryMapper.insert(category);
				}
				categoryMapper.insertFilmCategory(category, insertFilm);
			}
			
			Film film = mapper.selectByPrimaryKeyWithAssociations(insertFilm.getId());

			System.out.println(film);
		} finally {
			session.close();
		}
		
	}
	
	private Film createFilm(SqlSession session) {
		LanguageMapper languageMapper = session.getMapper(LanguageMapper.class);
		Language language = languageMapper.selectByPrimaryKey(1);
		
		Date now = Calendar.getInstance().getTime();
		
		Film film = new Film();
		film.setTitle("Insert Test");
		film.setDescription("Description");
		film.setLanguage(language);
		film.setRating(Rating.G);
		film.setRentalDuration((short) 5);
		film.setRentalRate(new BigDecimal(4.49));
		film.setReplacementCost(new BigDecimal(19.99));
		film.setYear(2015);
		film.setModifiedOn(now);
		
		ActorMapper actorMapper = session.getMapper(ActorMapper.class);
		Actor actor = actorMapper.selectByPrimaryKey(4);
		
		Actor newActor = new Actor();
		newActor.setFirstName("Buzz");
		newActor.setLastName("Lightyear");
		newActor.setModifiedOn(now);
		
		List<Actor> actors = new ArrayList<>();
		actors.add(actor);
		actors.add(newActor);
		
		film.setActors(actors);
		
		CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
		Category category = categoryMapper.selectByPrimaryKey(4);
		
		Category newCategory = new Category();
		newCategory.setName("New Category");
		newCategory.setModifiedOn(now);
		
		List<Category> categories = new ArrayList<>();
		categories.add(category);
		categories.add(newCategory);
		
		film.setCategories(categories);
		
		return film;
	}
}
