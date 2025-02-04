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
        app.post("/insert", ctx -> {
            try {
                logger.info("Calling endpoint insert");
                var customerModel = ctx.bodyAsClass(CustomerModel.class);
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

    public void getAll(){
        app.get("/customer", ctx ->{
            try{
                logger.info("Calling endpoint get all");
                var customers = customerService.getAll();

                ctx.status(HttpStatus.OK);
                ctx.json(customers);
            }catch (Exception e){
                logger.error("Error when searching customer list. Details: {} {}", e.getClass().getSimpleName(), e.getMessage());
                ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
                ctx.result("An unexpected error occurred while getting the customer list.");
            }
        });
    }
}


