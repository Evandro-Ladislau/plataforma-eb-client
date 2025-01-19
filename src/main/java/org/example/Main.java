package org.example;

import br.plataforma.eb.Models.CustomerModel;
import br.plataforma.eb.Services.CustomerService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        String birthDateString = "1989-08-01 00:00:00";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime birthDate = LocalDateTime.parse(birthDateString, formatter);

        CustomerModel customer1 = new CustomerModel("Evandro", "Ladislau", "evandroladislau23@gmail.com", birthDate);

        System.out.println(customer1.getId());
        CustomerService customerService = new CustomerService();
        customerService.insert(customer1);
    }
}