package br.plataforma.eb.Services;

import br.plataforma.eb.Models.CustomerModel;
import br.plataforma.eb.Repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

@ExtendWith(MockitoExtension.class)
 class CustomerServiceTest {

    @InjectMocks
    private CustomerModel customerModel;

    @Test
    public void mustEnterACustomerRecord(){
        customerService.insert(customerModel);
    }
}