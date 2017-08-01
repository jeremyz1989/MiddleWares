package com.celnet.dc.common.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chenn on 2017/5/18.
 */
public class IntEnumTypeHandler<E extends Enum<E> & IntEnum<E>> extends
        BaseTypeHandler<IntEnum> {

    private Class<IntEnum> type;

    public IntEnumTypeHandler(Class<IntEnum> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    private IntEnum convert(int status) {
        IntEnum[] objs = type.getEnumConstants();
        for (IntEnum em : objs) {
            if (em.getIntValue() == status) {
                return em;
            }
        }
        return null;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, IntEnum intEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, intEnum.getIntValue());
    }

    @Override
    public IntEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return convert(resultSet.getInt(s));
    }

    @Override
    public IntEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return convert(resultSet.getInt(i));
    }

    @Override
    public IntEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return convert(callableStatement.getInt(i));
    }
}
