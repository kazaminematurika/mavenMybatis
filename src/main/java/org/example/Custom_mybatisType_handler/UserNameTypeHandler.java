package org.example.Custom_mybatisType_handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Kazamine_Setueka
 */

@MappedJdbcTypes(JdbcType.VARCHAR)//需要处理varchar类型的数据
@MappedTypes(Name.class)//需要对Name这个对象的数据进行处理
public class UserNameTypeHandler extends BaseTypeHandler <Name>{

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Name parameter, JdbcType jdbcType) throws SQLException {

        //        将类型传化为JDBC所识别到的String数据类型的MySQL语句
        ps.setString(i, parameter.getFirst() +"---"+ parameter.getLast());
    }


//    将从数据库查询到的数据转化为所指定的JAVA的类型实例


    @Override
    public Name getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String [] nameTokens = rs.getString(columnName).split("-");
        //获取从数据库得到的信息并且通过制表语句Splist将其用"-"分隔开
        return new Name(nameTokens[0], nameTokens[1]);
    }

    @Override
    public Name getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String [] nameTokens = rs.getString(columnIndex).split("-");
        return new Name(nameTokens[0], nameTokens[1]);
    }

    @Override
    public Name getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String [] nameTokens = cs.getString(columnIndex).split("-");
        return new Name(nameTokens[0], nameTokens[1]);
    }
}
