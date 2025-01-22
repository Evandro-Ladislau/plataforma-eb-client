package br.plataforma.eb.Services;

import br.plataforma.eb.Models.CustomerModel;
import br.plataforma.eb.Repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class CustomerService {

    private CustomerRepository customerRepository = new CustomerRepository();
    private Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    public CustomerModel insert(CustomerModel customer) throws SQLException {

        try {
            logger.info("Calling the repository layer");
            System.out.println("Model: " + customer.getId() + " " + customer.getName() + " " + customer.getBirthDate() + " " + customer.getEmail() + " " + customer.getCreatedAt());
            return customerRepository.insert(customer);
        }catch (SQLException e){
            logger.error("Failed to insert customer: {} {}",e.getClass().getSimpleName(), e.getMessage());
            throw e;
        }
    }
}
