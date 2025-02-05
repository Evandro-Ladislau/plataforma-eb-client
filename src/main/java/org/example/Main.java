package org.example;

import br.plataforma.eb.Routes.Api;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Api api = new Api();
        api.appStart();
        api.insert();
        api.getAll();
    }
}