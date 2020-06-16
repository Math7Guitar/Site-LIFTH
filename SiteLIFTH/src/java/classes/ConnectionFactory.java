package classes;

/**
 *
 * @author root
 */

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

   public static Connection getConnection() throws SQLException, ClassNotFoundException{
        String dir      =   "jdbc:sqlite:/root/DATABASES/boo";
        String user     =   "root";  
        String pass     =   ""; 
        Class.forName("org.sqlite.JDBC");
	return DriverManager.getConnection(dir, user, pass);		
   }
}
