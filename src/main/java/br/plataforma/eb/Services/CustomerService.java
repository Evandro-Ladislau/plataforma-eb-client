package br.plataforma.eb.Services;

import br.plataforma.eb.Models.CustomerModel;
import br.plataforma.eb.Repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerService {

    private CustomerRepository customerRepository = new CustomerRepository();
    private Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    public CustomerModel insert(CustomerModel customer){

        try {
            logger.info("Calling the repository layer");
            return customerRepository.insert(customer);
        }catch (RuntimeException e){
            logger.error("Failed to insert customer: ", e);
            throw new RuntimeException("Error while inserting customer", e);
        }
    }
}
