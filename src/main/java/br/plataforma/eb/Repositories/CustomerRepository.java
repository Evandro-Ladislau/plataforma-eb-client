package br.plataforma.eb.Repositories;

import br.plataforma.eb.Models.CustomerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepository {
    private Connection conn = Database.getConnection();
    private Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    public CustomerModel insert(CustomerModel customerModel){
        String sql = "INSERT INTO clients (id, name, surname, email, birthdate, created_at, is_active) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, customerModel.getId());
            statement.setString(2, customerModel.getName());
            statement.setString(3, customerModel.getSurname());
            statement.setString(4, customerModel.getEmail());
            statement.setDate(5, Date.valueOf(customerModel.getBirthDate().toLocalDate()));
            statement.setDate(6, Date.valueOf(customerModel.getCreatedAt().toLocalDate()));
            statement.setBoolean(7, Boolean.TRUE);

            logger.info("Inserting customer into the database");
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error when inserting customer into database", e);
            throw new RuntimeException(e);
        }
        return customerModel;
    }
}
