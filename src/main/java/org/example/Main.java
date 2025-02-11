package org.example;

import br.plataforma.eb.Repositories.CustomerRepository;
import br.plataforma.eb.Routes.Api;
import br.plataforma.eb.Services.CustomerService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CustomerRepository customerRepository = new CustomerRepository();
        CustomerService customerService = new CustomerService(customerRepository);
        Api api = new Api(customerService);
        api.appStart();
        api.insert();
        api.getAll();
    }
}