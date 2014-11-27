package br.com.dbsti.agenda.view;

import br.com.dbsti.agenda.controller.ContatoController;
import br.com.dbsti.agenda.model.Contato;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ConsultarContato extends javax.swing.JInternalFrame {

    TableRowSorter<TableModel> sorter;

    public ConsultarContato() {
        initComponents();
        sorter = new TableRowSorter<>(tConsultar.getModel());
        tConsultar.setRowSorter(sorter);

        preencherTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bRemover = new javax.swing.JButton();
        bNovo = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tConsultar = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Contato");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(394, 25));

        bRemover.setText("Remover");
        bRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverActionPerformed(evt);
            }
        });

        bNovo.setText("Novo");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bAlterar.setText("Alterar");
        bAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 937, Short.MAX_VALUE)
                .addComponent(bNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRemover))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRemover)
                    .addComponent(bNovo)
                    .addComponent(bAlterar)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(394, 25));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Pesquisar :");

        tfPesquisar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(903, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        tConsultar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Sobrenome", "Apelido", "Telefone", "Celular", "E-mail", "Município", "Estado", "Data Cadastro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tConsultar);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        CadastarContato cadastraContato = new CadastarContato(this);
        Principal.dpAreaInterna.add(cadastraContato);
        cadastraContato.setVisible(true);
    }//GEN-LAST:event_bNovoActionPerformed

    private void bRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverActionPerformed
        int linha = tConsultar.getSelectedRow();
        int id = (int) tConsultar.getValueAt(linha, 0);
        String nome = (String) tConsultar.getValueAt(linha, 1);

        Contato contato = new Contato();
        contato.setIdContato(id);
        contato.setNome(nome);

        contatoCtrl.deletar(contato);

        preencherTabela();
    }//GEN-LAST:event_bRemoverActionPerformed

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
            
        try{
            int linha = tConsultar.getSelectedRow();      
            int id = (int) tConsultar.getValueAt(linha, 0);
            String nome = (String) tConsultar.getValueAt(linha, 1);

            CadastarContato cadastrarContato = new CadastarContato(this);
            cadastrarContato.setaAlteracao(id);
            Principal.dpAreaInterna.add(cadastrarContato);
            cadastrarContato.setVisible(true);
        } catch (Exception ex) {
              JOptionPane.showMessageDialog(null, "Selecione uma Linha na Tabela que Deseja Alterar!\n"+ex.getMessage(),"Informação",JOptionPane.INFORMATION_MESSAGE);
        }                                        
    }//GEN-LAST:event_bAlterarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tConsultar;
    private javax.swing.JTextField tfPesquisar;
    // End of variables declaration//GEN-END:variables
    ContatoController contatoCtrl = new ContatoController();

    public void preencherTabela() {

        List<Contato> contatos = contatoCtrl.listarTodos();
        tConsultar.getModel();

        DefaultTableModel modelo = (DefaultTableModel) tConsultar.getModel();

        modelo.setRowCount(0);

        for (Contato ctato : contatos) {
            modelo.addRow(new Object[]{ctato.getIdContato(), ctato.getNome(), ctato.getSobrenome(), ctato.getApelido(), ctato.getTelefone(),
                ctato.getCelular(), ctato.getEmail(), ctato.getMunicipio(), ctato.getEstado(), ctato.getDataCadastro()});
        }
    }
}
