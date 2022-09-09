package br.com.proj;

import br.com.proj.data.CadastroDB;
import br.com.proj.model.Cadastro;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        Cadastro c = new Cadastro();
        c.setName("Jose");
        c.setTelephone("123123123");

        try {

            new CadastroDB().insert(c);
            System.out.println("Registro Inserido!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
