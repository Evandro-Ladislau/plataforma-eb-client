package br.plataforma.eb.Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String url = "jdbc:postgresql://localhost:5440/client-service";
    private static  final String user = "client";
    private static final String password = "client";

    public static Connection conn;

    public static Connection getConnection(){

        try{
            if (conn == null){
                conn = DriverManager.getConnection(url, user, password);
            }
            return conn;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
