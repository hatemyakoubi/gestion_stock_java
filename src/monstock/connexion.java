/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monstock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author YASSOU
 */

public class connexion {
     String urlpilote="com.mysql.jdbc.Driver";   //chemin de pilote Driver
    String urlBD="jdbc:mysql://localhost:3306/gestion_stock"; // chemin de cnx BD
    Connection con;
    
    public connexion(){
    //chargement de pilote
    try{
    Class.forName(urlpilote);
    System.out.println("chargement pilote avec succee");
            }catch(ClassNotFoundException ex){
            System.out.println(ex);
                }
   //connexion BD
   try{
   con = DriverManager.getConnection(urlBD,"root","");
   
   }
   catch(SQLException ex){
       System.out.println(ex);
   }
   }
     Connection obtenircnx(){
    return con;
    } 
    
}
