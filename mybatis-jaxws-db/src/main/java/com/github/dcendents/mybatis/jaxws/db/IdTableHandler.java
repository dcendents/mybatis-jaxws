package com.github.dcendents.mybatis.jaxws.db;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.NoArgsConstructor;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * This handler can be used to correctly set the foreign key value of an association. It cannot be used to retrieve associations from the database and
 * will always return null. <br />
 * This is OK: Model -> Handler -> PreparedStatement -> Database <br />
 * This will not work: Database -> ResultSet -> Handler -> Model <br />
 * Loading an associated object needs to be done in the standard MyBatis way.
 */
@NoArgsConstructor
public class IdTableHandler extends BaseTypeHandler<IdTable> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, IdTable parameter, JdbcType jdbcType) throws SQLException {
        if (parameter.getId() == null) {
            ps.setNull(i, jdbcType.TYPE_CODE);
        }
        else {
            ps.setInt(i, parameter.getId());
        }
    }

    @Override
    public IdTable getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public IdTable getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public IdTable getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
