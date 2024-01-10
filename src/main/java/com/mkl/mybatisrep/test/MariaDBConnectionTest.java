/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkl.mybatisrep.test;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
//import org.junit.Test;
//import org.slf4j.Logger;

public class MariaDBConnectionTest {

    //private static final Logger log = Logger.getLogger(MariaDBConnectionTest.class);
    private static final Logger log = LoggerFactory.getLogger(MariaDBConnectionTest.class);
    String url = "jdbc:mariadb://localhost:3318/db_wgssl_06122023?user=ptmkl&password=pleaseD3h";

    //@Test
    public  void connectionTest() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            //org.mariadb.jdbc.MariaDbPoolDataSource
            Connection connection = DriverManager.getConnection(url);
            log.info("### connection : " +  connection + " - connection successful ####");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MariaDBConnectionTest main =  new MariaDBConnectionTest();
        main.connectionTest();
    }
}
