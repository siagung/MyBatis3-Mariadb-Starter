/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkl.mybatisrep.test;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 *
 * @author Admin
 */
public class encrypt {
    
     private void encryptPassword(){
       
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("123456789");
        encryptor.setAlgorithm("PBEWITHMD5ANDDES");

        String password = encryptor.encrypt("12345");
        System.out.println(password);

    }
     
      public static void main(String[] args) {
        new encrypt().encryptPassword();
    }
}
