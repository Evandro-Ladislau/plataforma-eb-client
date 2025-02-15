package br.plataforma.eb.Interfaces;

import br.plataforma.eb.Models.CustomerModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerServiceInterface {

    public CustomerModel insert(CustomerModel customer) throws SQLException;

    public ArrayList<CustomerModel> getAll() throws SQLException;
}
