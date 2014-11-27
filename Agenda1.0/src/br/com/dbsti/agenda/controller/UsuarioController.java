package br.com.dbsti.agenda.controller;

import br.com.dbsti.agenda.model.Interfaces.crudInterface;
import br.com.dbsti.agenda.model.Usuario;
import br.com.dbsti.agenda.model.dao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioController implements crudInterface {

    private Conexao conectar = new Conexao();
    private List<Usuario> usuarios = new ArrayList<>();
    private ResultSet rs;
    private Usuario usuario;

    @Override
    public boolean salvar(Object bean) {
        usuario = (Usuario) bean;
        if (usuario.getIdUsuario() == 0) {
            try {
                PreparedStatement pstmt = conectar.getConexao("insert into usuario (login, senha, email, cep, logradouro, numero, bairro, cidade, estado) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

                setarCampos(pstmt, usuario);

                pstmt.execute();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "O Usuário :" + usuario.getLogin() + " não foi Salvo!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            try {
                PreparedStatement pstmt = conectar.getConexao("Update usuario login = ?, senha = ?, email = ?, cep = ?, logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ? Where IdUsuario = ?");

                setarCampos(pstmt, usuario);

                pstmt.setInt(4, usuario.getIdUsuario());
                pstmt.execute();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "O Usuário :" + usuario.getLogin() + " não pode ser Alterado!\n" + ex.getMessage(), "Ero", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    @Override
    public boolean deletar(Object bean) {
        usuario = (Usuario) bean;

        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar todo registro de :" + usuario.getLogin() + "?", "Comfirmação", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement pstmt = conectar.getConexao("Delete from Usuario Where IdUsuario =?");

                pstmt.setInt(1, usuario.getIdUsuario());
                pstmt.execute();

                return true;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "O registro do Usuário :" + usuario.getLogin() + " não foi Deletado!", "Informção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    @Override
    public List listarTodos() {
        try {
            PreparedStatement pstmt = conectar.getConexao("Select * From Usuario");

            rs = pstmt.executeQuery();

            usuario = null;
            while (rs.next()) {
                usuario = new Usuario();

                pegarCampos(usuario, rs);

                usuarios.add(usuario);
            }
            return usuarios;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro :" + ex.getMessage());
            return null;
        }
    }

    @Override
    public Object recuperarPorID(Object bean) {
        try {
            PreparedStatement pstmt = conectar.getConexao("Select * From Usuario Where IdUsuario = ?");
            int id = Integer.parseInt(bean.toString());
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            usuario = null;
            if (rs.next()) {
                
                pegarCampos(usuario, rs);                
                
            }

            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro :" + ex.getMessage());
            return null;
        }
    }

    private void setarCampos(PreparedStatement pstmt, Usuario usuario) throws SQLException {
                
        pstmt.setString(1, usuario.getLogin());
        pstmt.setString(2, usuario.getSenha());
        pstmt.setString(3, usuario.getEmail());
        pstmt.setString(4, usuario.getCep());
        pstmt.setString(5, usuario.getLogradouro());                              
        pstmt.setString(6, usuario.getNumero());
        pstmt.setString(7, usuario.getBairro()); 
        pstmt.setString(8, usuario.getCidade());
        pstmt.setString(9, usuario.getEstado());
        
    }

    private void pegarCampos(Usuario usuario, ResultSet rs) throws SQLException {
        usuario.setIdUsuario(rs.getInt("IdUsuario"));
        usuario.setLogin(rs.getString("Login"));
        usuario.setSenha(rs.getString("Senha"));
        usuario.setEmail(rs.getString("Email"));
        usuario.setNumero(rs.getString("numero"));
        usuario.setCep(rs.getString("Cep"));
        usuario.setLogradouro(rs.getString("Logradouro"));
        usuario.setBairro(rs.getString("Bairro"));
        usuario.setCidade(rs.getString("Cidade"));
        usuario.setEstado(rs.getString("Estado"));
    }
}
