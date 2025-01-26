package org.example;

import br.plataforma.eb.Models.CustomerModel;
import br.plataforma.eb.Routes.Api;
import br.plataforma.eb.Services.CustomerService;
import lombok.var;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Api api = new Api();
        api.appStart();
        api.insert();

        CustomerService customerService = new CustomerService();
        var listCustomer = customerService.getAll();
        for ( CustomerModel customer : listCustomer){
            System.out.println(customer);
        }
    }
}