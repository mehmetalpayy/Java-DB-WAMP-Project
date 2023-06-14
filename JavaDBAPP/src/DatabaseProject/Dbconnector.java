/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mehmet Alpay
 */
public class Dbconnector {
    String URL="jdbc:mysql://localhost:3306/dbnew?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public List<GamesNew> listgames(){
        List<GamesNew> gameslist = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL,"root","");
            
            String query = "Select * from games";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                GamesNew game;
                game = new GamesNew(resultSet.getString("name"), resultSet.getInt("year"), resultSet.getString("genre"), resultSet.getString("company"));
                gameslist.add(game);
            }
        }
        
        catch(Exception ex){
            System.out.println("Error: " + ex);
        }
        return gameslist;
    
    }
}
