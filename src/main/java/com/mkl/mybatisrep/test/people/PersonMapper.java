/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkl.mybatisrep.test.people;

/**
 *
 * @author Admin
 */
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;

@Mapper
public interface PersonMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<PersonRecord>, CommonUpdateMapper {

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "PersonResult", value = {
            @Result(column = "A_ID", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "first_name", property = "firstName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "last_name", property = "lastName", jdbcType = JdbcType.VARCHAR, typeHandler = LastNameTypeHandler.class),
            @Result(column = "birth_date", property = "birthDate", jdbcType = JdbcType.DATE),
            @Result(column = "employed", property = "employed", jdbcType = JdbcType.VARCHAR, typeHandler = YesNoTypeHandler.class),
            @Result(column = "occupation", property = "occupation", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address_id", property = "addressId", jdbcType = JdbcType.INTEGER)
    })
    List<PersonRecord> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("PersonResult")
    Optional<PersonRecord> selectOne(SelectStatementProvider selectStatement);
}
