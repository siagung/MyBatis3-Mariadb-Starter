/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkl.mybatisrep.test;

/**
 *
 * @author Admin
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mkl.mybatisrep.Mybatisrep;
import com.mkl.mybatisrep.utils.MyBatisSqlSessionFactory;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author agung
 */
public class Check {
    public Check() {
    }

    private void start() {
          Mybatisrep.getLogger().info("---------- CEK START ----------");
        try {
            SqlSessionFactory sqlSessionFactory = MyBatisSqlSessionFactory.getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.getConnection();
            Mybatisrep.getLogger().info("---------- KONEKSI BERHASIL ----------");
        } catch (Exception e) {
            Mybatisrep.getLogger().error("GAGAL KONEK!!!!");
        }

    }

    private void testpass() {
        final StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        String encryptepPass = passwordEncryptor.encryptPassword("please");
        System.out.println(encryptepPass);
    }

    public static void main(String[] args) {
        new Check().start();
    }
}
