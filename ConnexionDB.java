
/*
author thierry
*/
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;


public class ConnexionDB
{
    
    private static Connection maconnexion;
    private  static Statement stmt;
    
    private static String login="thierry";
    private static String passwd="thierry";
    private static String URL="jdbc:mysql://localhost/thierry";
    private static String pilote="com.mysql.jdbc.Driver";
    
    
    public static Connection connecty()// throws ClassNotFoundException, SQLException
    {
        try {
            Class.forName(pilote);
            System.out.println("driver chargé");
            maconnexion = DriverManager.getConnection(URL, login, passwd);
            System.out.println("connexion paramétrée");
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

     return maconnexion;

    }
    
    public static ResultSet rezselect(String req) throws SQLException
    {
        stmt=maconnexion.createStatement();
        ResultSet rs=stmt.executeQuery(req);
       return rs;
    }
   
    

}
