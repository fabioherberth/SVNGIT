package br.com.dbsti.agenda.controller;

import br.com.dbsti.agenda.model.Grupo;
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

public class GrupoController implements crudInterface {

    private Conexao conecta = new Conexao();
    private List<Grupo> grupos = new ArrayList<>();
    private ResultSet rs;
    private Grupo grupo;

    @Override
    public boolean salvar(Object bean) {
        grupo = (Grupo) bean;

        if (grupo.getIdGrupo() == 0) {
            try {
                PreparedStatement pstmt = conecta.getConexao("Insert into Grupo (Nome, Observacao) Values (?, ?)");
                pstmt.setString(1, grupo.getNome());
                pstmt.setString(2, grupo.getObservacao());
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(GrupoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "O Grupo :" + grupo.getNome() + "não pode ser Salvo!\n", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            try {
                PreparedStatement pstmt = conecta.getConexao("Update Grupo Set Nome = ?, Observacao = ? Where IdGrupo = ?");
                    pstmt.setString(1, grupo.getNome());
                    pstmt.setString(2, grupo.getObservacao());
                    pstmt.setInt(3, grupo.getIdGrupo());
               
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(GrupoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "O Grupo :" + grupo.getNome() + "não pode ser Alterado\n", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    @Override
    public boolean deletar(Object bean) {
        grupo = (Grupo) bean;

        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realemente deletar esse registro de Grupo :" + grupo.getNome(), "Imformação", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement pstmt = conecta.getConexao("Delete From Grupo Where IdGrupo = ?");
                pstmt.setInt(1, grupo.getIdGrupo());
                pstmt.execute();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(GrupoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Não Foi Possivel deletar :" + grupo.getNome() + "\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "O Grupo :" + grupo.getNome() + " não foi Deletado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    @Override
    public List listarTodos() {
        try {
            PreparedStatement pstmt = conecta.getConexao("Select * From Grupo");

            rs = pstmt.executeQuery();

            grupo = null;
            while (rs.next()) {
                grupo = new Grupo();
                pegarCampos(rs, grupo);
                grupos.add(grupo);
            }
            return grupos;
        } catch (SQLException ex) {
            Logger.getLogger(GrupoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possivel Listar!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public Object recuperarPorID(Object bean) {
        try {
            PreparedStatement pstmt = conecta.getConexao("Select * From Grupo Where IdGRupo =?");
            int id = Integer.parseInt(bean.toString());

            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            grupo = null;
            if (rs.next()) {
                grupo = new Grupo();
                pegarCampos(rs, grupo);
            }
            return grupo;
        } catch (SQLException ex) {
            Logger.getLogger(GrupoController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi Possivel realizar essa opração!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void pegarCampos(ResultSet rs, Grupo grupo) throws SQLException {
        grupo.setIdGrupo(rs.getInt("IdGrupo"));
        grupo.setNome(rs.getString("Nome"));   
        grupo.setObservacao(rs.getString("Observacao"));
    }
}
