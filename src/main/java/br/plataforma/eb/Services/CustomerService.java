package br.plataforma.eb.Services;

import br.plataforma.eb.Interfaces.CustomerServiceInterface;
import br.plataforma.eb.Models.CustomerModel;
import br.plataforma.eb.Repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerService implements CustomerServiceInterface {

    private CustomerRepository customerRepository;
    private Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomerModel insert(CustomerModel customer) throws SQLException {

        try {
            logger.info("Calling the repository layer with customer data: {}", customer);
            return customerRepository.insert(customer);
        } catch (SQLException e){
            logger.error("Failed to insert customer: {} {}",e.getClass().getSimpleName(), e.getMessage());
            throw e;
        }
    }

    public ArrayList<CustomerModel> getAll() throws SQLException {
        try{
            logger.info("Calling the repository layer for get all customer");
            return customerRepository.getAll();
        } catch (SQLException e){
            logger.error("Failed to get all customer: {} {}", e.getClass().getSimpleName(), e.getMessage());
            throw e;
        }
    }
}
