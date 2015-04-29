package com.github.dcendents.mybatis.jaxws.db;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.github.dcendents.mybatis.jaxws.api.Rating;

public class RatingHandler extends BaseTypeHandler<Rating> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Rating parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.getValue());
	}

	@Override
	public Rating getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String s = rs.getString(columnName);
		return s == null ? null : Rating.fromValue(s);
	}

	@Override
	public Rating getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String s = rs.getString(columnIndex);
		return s == null ? null : Rating.fromValue(s);
	}

	@Override
	public Rating getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String s = cs.getString(columnIndex);
		return s == null ? null : Rating.fromValue(s);
	}

}
