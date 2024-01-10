/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkl.mybatisrep.mappers;

import ca.odell.glazedlists.EventList;
import com.mkl.mybatisrep.domain.Product;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author agung
 */
public interface ProductMapper {

    @Insert("INSERT INTO TB_BARANG(id, cbarang, vnama_barang, banalisa, breduct, breg, baktif)  VALUES (#{id}, #{cbarang}, #{vnama_barang}, #{banalisa}, #{breduct}, #{breg}, #{baktif})")
    @Options(keyProperty = "id")
    public void save(Product product);

    @Insert("INSERT INTO TB_BARANG(vnama_barang)  VALUES (#{vnama_barang})")
    @Options(keyProperty = "id")
    public void addNew(Product product);

    @Update("UPDATE TB_BARANG SET cbarang=#{cbarang}, vnama_barang=#{vnama_barang}, banalisa=#{banalisa}, breduct=#{breduct}, breg=#{breg}, baktif=#{baktif}  WHERE ID=#{id}")
    public void edit(Product product);

    @Delete("DELETE FROM TB_BARANG WHERE ID=#{id}")
    public void delete(int id);

    @Select("SELECT  id, cbarang, vnama_barang, banalisa, breduct, breg, baktif FROM TB_BARANG WHERE ID=#{id}")
    public Product findOne(int id);

    @Select("SELECT vnama_barang FROM TB_BARANG WHERE CBARANG = #{Code}")
    public Product checkID(String Code);

    @Select("SELECT vnama_barang FROM TB_BARANG WHERE vnama_barang = #{nama}")
    public Product checkNama(String nama);
    @Select("SELECT * FROM TB_BARANG")
    @Results({
        @Result(id = true, property = "id", column = "id"),
        @Result(property = "cbarang", column = "cbarang"),
        @Result(property = "vnama_barang", column = "vnama_barang"),
        @Result(property = "banalisa", column = "banalisa"),
        @Result(property = "breduct", column = "breduct"),
        @Result(property = "breg", column = "breg"),
        @Result(property = "baktif", column = "baktif")
    })
    public List<Product> findAll();

    @Select("SELECT * FROM TB_BARANG")
    @Results({
        @Result(id = true, property = "id", column = "id"),
        @Result(property = "cbarang", column = "cbarang"),
        @Result(property = "vnama_barang", column = "vnama_barang"),
        @Result(property = "banalisa", column = "banalisa"),
        @Result(property = "breduct", column = "breduct"),
        @Result(property = "breg", column = "breg"),
        @Result(property = "baktif", column = "baktif")
    })
    public EventList<Product> getAll();
}
