package br.plataforma.eb.Repositories;

import br.plataforma.eb.Models.CustomerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepository {
    private Connection conn = Database.getConnection();
    private Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    public CustomerModel insert(CustomerModel customerModel){
        String sql = "INSERT INTO clients (id, name, surname, email, birthdate, created_at, updated_at, is_active) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, customerModel.getId());
            statement.setString(2, customerModel.getName());
            statement.setString(3, customerModel.getSurname());
            statement.setString(4, customerModel.getEmail());
            statement.setDate(5, java.sql.Date.valueOf(String.valueOf(customerModel.getBirthDate())));
            statement.setDate(6, java.sql.Date.valueOf(String.valueOf(customerModel.getCreatedAt())));
            statement.setTimestamp(7, null);

            logger.info("Inserting customer into the database");
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error when inserting customer into database", e);
            throw new RuntimeException(e);
        }
        return customerModel;
    }
}
