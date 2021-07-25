/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DBUtils implements Serializable {
    public static Connection getMyConnection() throws Exception, ClassNotFoundException{
       
        //1. Nap driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. Mo ket noi
        Connection conn = DriverManager.getConnection(
                "jdbc:sqlserver://127.0.0.1\\MSSQLSERVER:1433;databaseName=ItemDB",
                "sa", "123");
        return conn;
    }
}
