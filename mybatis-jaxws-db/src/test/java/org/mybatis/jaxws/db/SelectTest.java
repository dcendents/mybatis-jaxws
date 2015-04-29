package org.mybatis.jaxws.db;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.dcendents.mybatis.jaxws.db.client.FilmMapper;
import com.github.dcendents.mybatis.jaxws.db.model.Film;

public class SelectTest {

	@Test
	public void selectFilm() throws Exception {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			FilmMapper mapper = session.getMapper(FilmMapper.class);
			Film film = mapper.selectByPrimaryKeyWithAssociations(10);

			System.out.println(film);
			System.out.println(film.convert());
		} finally {
			session.close();
		}
	}
}
