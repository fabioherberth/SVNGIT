package br.com.dbsti.agenda.controller;

import br.com.dbsti.agenda.model.BaseCep;
import br.com.dbsti.agenda.model.dao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BaseCepController {
    private Conexao conecta = new Conexao();         
    private ResultSet rs;
    private BaseCep baseCep;
    
    public Object recuperarPorCep(Object bean){
        try {
            PreparedStatement pstmt = conecta.getConexao("Select * From Base_Cep Where Cep = ?");
            int id = Integer.parseInt(bean.toString());
            
            pstmt.setInt(1, id);
        
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                baseCep = new BaseCep();
                
                baseCep.setId(rs.getInt("Id"));
                baseCep.setCep(rs.getInt("Cep"));
                baseCep.setLogradouro(rs.getString("Logradouro"));
                baseCep.setBairro(rs.getString("Bairro"));
                baseCep.setCidade(rs.getString("Cidade"));
                baseCep.setEstado(rs.getString("Estado"));
                
            }
            
            return baseCep;
            
        } catch (SQLException ex) {
            Logger.getLogger(BaseCepController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro"+ ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            
            return null;
        }
    }            
}
