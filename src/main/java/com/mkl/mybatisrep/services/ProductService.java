/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mkl.mybatisrep.services;

/**
 *
 * @author agung
 */
import ca.odell.glazedlists.EventList;
import com.mkl.mybatisrep.domain.Product;
import com.mkl.mybatisrep.mappers.ProductMapper;
import com.mkl.mybatisrep.utils.MyBatisSqlSessionFactory;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class ProductService {


    public List<Product> findAll() {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
            ProductMapper mapper
                    = sqlSession.getMapper(ProductMapper.class);
            return mapper.findAll();
        }
    }
    
    public EventList<Product> getAllProduct(){
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
            ProductMapper mapper
                    = sqlSession.getMapper(ProductMapper.class);
            return mapper.getAll();
        }
    }

    public Product findById(int id) {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
            ProductMapper mapper
                    = sqlSession.getMapper(ProductMapper.class);
            return mapper.findOne(id);
        }
    }

    public int createProduct(Product product) {
        int out = 0;
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
            ProductMapper mapper
                    = sqlSession.getMapper(ProductMapper.class);
            mapper.save(product);
            sqlSession.commit();
            out=1;
        }
        return out;
    }
    
     public int createNew(Product product) {
        int out = 0;
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
            ProductMapper mapper
                    = sqlSession.getMapper(ProductMapper.class);
            mapper.addNew(product);
            sqlSession.commit();
            out=1;
        }
        return out;
    }
    
     public int updateProduct(Product product){
         int noOfRowsUpdated = 0;
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {            
            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            mapper.edit(product);
            noOfRowsUpdated = 1;
           // studentMapper.deleteUsers(studId);
            sqlSession.commit();
        }
        return noOfRowsUpdated;
    }
    
    /**
     * Delete an instance of Contact from the database.
     * @param id primary key value of the instance to be deleted.
     */
    public void delete(int id){
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            mapper.delete(id);
            sqlSession.commit();
        }
    }
}