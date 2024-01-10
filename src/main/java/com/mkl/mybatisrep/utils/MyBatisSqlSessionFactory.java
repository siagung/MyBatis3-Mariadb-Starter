/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkl.mybatisrep.utils;

/**
 *
 * @author agung
 */

import com.mkl.mybatisrep.Mybatisrep;
import com.mkl.mybatisrep.datasource.DataSourceFactory;
import com.mkl.mybatisrep.mappers.ProductMapper;
import com.mkl.mybatisrep.test.people.PersonMapper;
import java.io.FileNotFoundException;
import javax.sql.DataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class MyBatisSqlSessionFactory {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {

            try {
                DataSource dataSource = DataSourceFactory.getDataSource();
                TransactionFactory transactionFactory = new JdbcTransactionFactory();
                Environment environment = new Environment("production",transactionFactory, dataSource);
                Configuration configuration = new Configuration(environment);
                
                
  
                /**
                 * MASTER
                 */
                
                
                configuration.getTypeAliasRegistry().registerAlias("Product",
                         com.mkl.mybatisrep.domain.Product.class);
                configuration.addMapper(ProductMapper.class);
                 configuration.addMapper(PersonMapper.class);
                
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

            } catch (FileNotFoundException ex) {
                 Mybatisrep.getLogger().error(ex.getMessage());
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSession() {
        return getSqlSessionFactory().openSession();
    }
}
