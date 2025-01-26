package br.plataforma.eb.Repositories;

import br.plataforma.eb.Models.CustomerModel;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {
    private Connection conn = Database.getConnection();
    private Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    public CustomerModel insert(CustomerModel customerModel) throws SQLException {
        String sql = "INSERT INTO clients (id, name, surname, email, birthdate, created_at, updated_at, is_active) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, customerModel.getId());
            statement.setString(2, customerModel.getName());
            statement.setString(3, customerModel.getSurname());
            statement.setString(4, customerModel.getEmail());
            statement.setDate(5, Date.valueOf(customerModel.getBirthDate()));
            statement.setTimestamp(6, Timestamp.valueOf(customerModel.getCreatedAt()));
            statement.setTimestamp(7, Timestamp.valueOf(customerModel.getUpdateAt()));
            statement.setBoolean(8, customerModel.getIsActive());

            logger.info("Inserting customer into the database");
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error when inserting customer into database: {} {}", e.getClass().getSimpleName(), e.getMessage());
            throw e;
        }
        return customerModel;
    }

    public ArrayList<CustomerModel> getAll() throws SQLException {
        ArrayList<CustomerModel> customers = new ArrayList<>();

        String sql = "SELECT * FROM clients";
        try(Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){

            while (resultSet.next()){
                CustomerModel customer = new CustomerModel(resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getDate("birthDate").toLocalDate(),
                        resultSet.getBoolean("is_active")
                );
                customers.add(customer);
            }
        } catch (SQLException e){
            logger.error("Error when get all customer in database {} {}", e.getClass().getSimpleName(), e.getMessage());
            throw e;
        }
        return customers;
    }
}
