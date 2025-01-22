package br.plataforma.eb.Routes;

import br.plataforma.eb.Models.CustomerModel;
import br.plataforma.eb.Services.CustomerService;
import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Api {

    private Javalin app;
    private Logger logger = LoggerFactory.getLogger(Api.class);
    private CustomerService customerService;

    public Api(){
        this.customerService = new CustomerService();
    }

    public Javalin appStart(){
         this.app =  Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World"))
                .start(7070);
         return this.app;
    }

    public void insert(){
        logger.info("Calling endpoint insert");

        app.post("/insert", ctx -> {
            try {
                var customer = ctx.bodyAsClass(CustomerModel.class);
                CustomerModel customerModel = new CustomerModel(customer.getName(), customer.getSurname(), customer.getEmail(), customer.getBirthDate());
                customerService.insert(customerModel);

                ctx.status(HttpStatus.CREATED);
                ctx.json(customerModel);
            }catch (Exception e) {
                logger.error("Error inserting customer. Details: {} {}", e.getClass().getSimpleName(), e.getMessage());
                ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
                ctx.result("An unexpected error occurred while inserting the customer.");
            }
        });
    }
}


