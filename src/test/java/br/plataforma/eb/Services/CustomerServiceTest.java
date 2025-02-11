package br.plataforma.eb.Services;

import br.plataforma.eb.Models.CustomerModel;
import br.plataforma.eb.Repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;


public class CustomerServiceTest {

    CustomerRepository customerRepository;
    CustomerService customerService;

    @Before
    public void setUp(){

        customerRepository = Mockito.mock(CustomerRepository.class);
        customerService  = new CustomerService(customerRepository);

        assertNotNull(customerService);
        assertNotNull(customerRepository);
    }

    @Test
    public void mustEnterACustomerRecord() throws SQLException {
        CustomerModel customerModel = new CustomerModel("Evandro", "Ladislau", "ev@gmail.com", LocalDate.now());

        customerService.insert(customerModel);
        Mockito.verify(customerRepository).insert(customerModel);
    }

    @Test(expected = SQLException.class)
    public void mustThrowExceptionWhenRepositoryFails() throws SQLException {
        CustomerModel customerModel = Mockito.mock(CustomerModel.class);
        Mockito.when(customerRepository.insert(Mockito.any(CustomerModel.class)))
                .thenThrow(new SQLException("Error saving to database"));

        customerService.insert(customerModel);
    }
}