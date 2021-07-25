package tramdb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yiyangqianxi
 */
public class MyConnection {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=StudentManagers; " + " user=sa; password=123";

    public static Connection openConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Connection c = DriverManager.getConnection(url);
        return c;
    }
}
