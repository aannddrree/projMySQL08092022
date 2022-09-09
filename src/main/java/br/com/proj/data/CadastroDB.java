package br.com.proj.data;

import br.com.proj.model.Cadastro;
import br.com.proj.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDB {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public CadastroDB() {
        connection = Conexao.getConnection();
    }

    public boolean insert(Cadastro cadastro) throws SQLException {
        try {

            PreparedStatement stmt = this.connection
                    .prepareStatement("INSERT INTO tb_aula (name, telephone) values (?, ?)");

            stmt.setString(1, cadastro.getName());
            stmt.setString(2, cadastro.getTelephone());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {

            connection.close();

        }
        return false;
    }
}