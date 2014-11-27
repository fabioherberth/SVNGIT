package br.com.dbsti.agenda.controller;

import br.com.dbsti.agenda.model.Contato;
import br.com.dbsti.agenda.model.Interfaces.crudInterface;
import br.com.dbsti.agenda.model.dao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ContatoController implements crudInterface {

    private Conexao conecta = new Conexao();
    private List<Contato> contatos = new ArrayList<>();
    private ResultSet rs;
    private Contato contato;

    @Override
    public boolean salvar(Object bean) {
        contato = (Contato) bean;
        if (contato.getIdContato() == 0) {
            try {
                PreparedStatement pstmt = conecta.getConexao("Insert Into Contato (Nome, Sobrenome, Apelido, Telefone, Celular, Email, Municipio, Estado, Data_Cadastro, Usuario_Cadastro) Values (?,?,?,?,?,?,?,?,?,?)");

                salvaOuAlteraCampos(pstmt, contato);

                pstmt.execute();

                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "O Contato :" + contato.getNome() + " não pode ser Salvo!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

                return false;
            }
        } else {
            try {
                PreparedStatement pstmt = conecta.getConexao("Update Contato set Nome =?, Sobrenome =?, Apelido =?, Telefone =?, Celular =?, Email =?, Municipio =?, Estado =?, Data_Cadastro =?, Usuario_Cadastro =? Where IdContato = ? ");

                salvaOuAlteraCampos(pstmt, contato);
                pstmt.setInt(11, contato.getIdContato());

                pstmt.execute();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "O Contato :" + contato.getNome() + " não pode ser Alterado!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    @Override
    public boolean deletar(Object bean) {
        contato = (Contato) bean;
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente remover :" + contato.getNome() + "?", "Comfirmação", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement pstmt = conecta.getConexao("Delete From Contato Where Idcontato = ?");
                pstmt.setInt(1, contato.getIdContato());
                pstmt.execute();

                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Não foi possivel deletar :" + contato.getNome() + "!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "O contato ainda se encontra nos nos registros!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    @Override
    public List listarTodos() {
        try {
            PreparedStatement pstmt = conecta.getConexao("Select * From Contato");

            rs = pstmt.executeQuery();

            contato = null;
            
            contatos.removeAll(contatos);
            
            while (rs.next()) {
                contato = new Contato();

                pegarCampos(rs, contato);

                contatos.add(contato);
            }

            return contatos;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi Possível Listar Contatos!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public Object recuperarPorID(Object bean) {
        try {
            PreparedStatement pstmt = conecta.getConexao("Select * From Contato Where IdContato = ?");
            int id = Integer.parseInt(bean.toString());

            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                contato = new Contato();

                pegarCampos(rs, contato);

            }
            return contato;

        } catch (SQLException ex) {
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi Possível encontrar o Contato!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void salvaOuAlteraCampos(PreparedStatement pstmt, Contato contato) throws SQLException {
        pstmt.setString(1, contato.getNome());
        pstmt.setString(2, contato.getSobrenome());
        pstmt.setString(3, contato.getApelido());
        pstmt.setString(4, contato.getTelefone());
        pstmt.setString(5, contato.getCelular());
        pstmt.setString(6, contato.getEmail());
        pstmt.setString(7, contato.getMunicipio());
        pstmt.setString(8, contato.getEstado());
        pstmt.setDate(9, new java.sql.Date(new java.util.Date().getTime()));
        pstmt.setInt(10, contato.getUsuarioCadastro());
    }

    private void pegarCampos(ResultSet rs, Contato contato) throws SQLException {
        contato.setIdContato(rs.getInt("IdContato"));
        contato.setNome(rs.getString("Nome"));
        contato.setSobrenome(rs.getString("Sobrenome"));
        contato.setApelido(rs.getString("Apelido"));
        contato.setTelefone(rs.getString("Telefone"));
        contato.setCelular(rs.getString("Celular"));
        contato.setEmail(rs.getString("Email"));
        contato.setMunicipio(rs.getString("Municipio"));
        contato.setEstado(rs.getString("Estado"));
        contato.setDataCadastro(rs.getDate("Data_Cadastro"));
        contato.setUsuarioCadastro(rs.getInt("Usuario_Cadastro"));
    }
}
