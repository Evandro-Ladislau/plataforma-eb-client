package br.plataforma.eb.Interfaces;

import br.plataforma.eb.Models.CustomerModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerRepositoryInterface {

    public CustomerModel insert(CustomerModel customerModel) throws SQLException;

    public ArrayList<CustomerModel> getAll() throws SQLException;
}
