package com.github.dcendents.mybatis.jaxws.web;

import java.io.InputStream;

import javax.jws.WebService;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.dcendents.mybatis.jaxws.db.client.FilmMapper;
import com.github.dcendents.mybatis.jaxws.db.model.Film;

@WebService
public class JaxwsServiceImpl implements JaxwsService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public JaxwsServiceImpl() throws Exception {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "production");
	}

	@Override
	public boolean insertFilm(Film film) {
		return false;
	}

	@Override
	public Film selectFilm(int id) {
		Film film = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			FilmMapper mapper = session.getMapper(FilmMapper.class);
			film = mapper.selectByPrimaryKeyWithAssociations(10);
		} finally {
			session.close();
		}
		
		return film;
	}
}
