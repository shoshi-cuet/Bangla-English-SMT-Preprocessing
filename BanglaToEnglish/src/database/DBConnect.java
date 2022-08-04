/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
 
public class DBConnect {
    public static Connection getConnnection() throws SQLException {
        Connection con= null;
        String pass="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String unicode="?useUnicode=yes&characterEncoding=UTF-8";
       //     String connectionUrl = "jdbc:mysql://localhost/banglaphrase?"
               //     + "user=root&password="+pass;
            con =(com.mysql.jdbc.Connection) DriverManager
	                    .getConnection("jdbc:mysql://localhost/e_b_dictionary" + unicode, "root", "");
            //System.out.println("Successfully Connected");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("ERROR : " + " NO Coonnection" + e.toString());
        }
        return con;
    }
}
