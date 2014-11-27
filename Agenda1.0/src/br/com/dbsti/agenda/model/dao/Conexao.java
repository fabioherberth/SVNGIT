package br.com.dbsti.agenda.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {

    private static Connection conectar;
    private PreparedStatement pstmt;
    private ResultSet resultado;
    private static final String ClasseDrive = "org.h2.Driver";
    private static final String jdbcURL = "jdbc:h2:tcp://localhost/C:/Users/FabioHerbert/Documents/h2/AgendaStudent";
    private static final String usuario = "Fabio";
    private static final String senha = "858690fhfg";

    static {
        try {
            Class.forName(ClasseDrive);
            conectar = DriverManager.getConnection(jdbcURL, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PreparedStatement getConexao(String SQL) throws SQLException {
        pstmt = conectar.prepareStatement(SQL);
        return pstmt;
    }

    public void fechaConexao() {
        try {
            if (!conectar.isClosed()) {
                conectar.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
