package br.plataforma.eb.Repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String url = "jdbc:postgresql://localhost:5440/client-service";
    private static  final String user = "client";
    private static final String password = "client";
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    public static Connection conn;

    public static Connection getConnection(){

        try{
            if (conn == null){
                conn = DriverManager.getConnection(url, user, password);
                logger.info("Conexão estabelecida com o banco de dados.");
            }
            return conn;
        } catch (SQLException e){
            logger.error("Erro ao conectar com o banco de dados: ", e);
            return null;
        }
    }
}
