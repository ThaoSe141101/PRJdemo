/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaontt.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thao
 */
public class DBHelper implements Serializable{
    public static  Connection makeConnection() throws ClassNotFoundException, SQLException{
        //1. load Driver
        System.out.println("co khong");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. tạo chuỗi kết nối url string
            String url ="jdbc:sqlserver://localhost:1433;databaseName=UserManagement";
        //3. Mở kết nối
        System.out.println("bo tay");
        Connection con = DriverManager.getConnection(url, "sa", "123456");
       return con;
    }
}
