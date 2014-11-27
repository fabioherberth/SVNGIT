package br.com.dbsti.agenda.view;

public class Principal extends javax.swing.JFrame {
  
    public Principal() {
        initComponents();
                
        Login login = new Login();        
        dpAreaInterna.add(login);            
        login.setVisible(true);               
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        bContato = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        bGrupo = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        bUsuario = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bSair = new javax.swing.JButton();
        dpAreaInterna = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mCadastrar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        mConsultar = new javax.swing.JMenu();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        mAjuda = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 25));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("00:00");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 744, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jToolBar1.setRollover(true);

        bContato.setText("Contato");
        bContato.setFocusable(false);
        bContato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bContato.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bContatoActionPerformed(evt);
            }
        });
        jToolBar1.add(bContato);
        jToolBar1.add(jSeparator3);

        bGrupo.setText("Grupo");
        bGrupo.setFocusable(false);
        bGrupo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bGrupo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGrupoActionPerformed(evt);
            }
        });
        jToolBar1.add(bGrupo);
        jToolBar1.add(jSeparator4);

        bUsuario.setText("Usuário");
        bUsuario.setFocusable(false);
        bUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUsuarioActionPerformed(evt);
            }
        });
        jToolBar1.add(bUsuario);
        jToolBar1.add(jSeparator2);

        bSair.setText("Sair");
        bSair.setFocusable(false);
        bSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bSair);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        dpAreaInterna.setBackground(new java.awt.Color(255, 255, 255));
        dpAreaInterna.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(dpAreaInterna, java.awt.BorderLayout.CENTER);

        mCadastrar.setMnemonic('C');
        mCadastrar.setText("Cadastrar");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Contato");
        mCadastrar.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Grupo");
        mCadastrar.add(jMenuItem2);
        mCadastrar.add(jSeparator5);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Usuário");
        mCadastrar.add(jMenuItem3);

        jMenuBar1.add(mCadastrar);

        mConsultar.setMnemonic('O');
        mConsultar.setText("Consultar");
        mConsultar.add(jSeparator6);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem4.setText("Contato");
        mConsultar.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem5.setText("Grupo");
        mConsultar.add(jMenuItem5);
        mConsultar.add(jSeparator7);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem6.setText("Usuário");
        mConsultar.add(jMenuItem6);

        jMenuBar1.add(mConsultar);

        mAjuda.setMnemonic('A');
        mAjuda.setText("Ajuda");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setText("Sobre");
        mAjuda.add(jMenuItem7);

        jMenuBar1.add(mAjuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Evento Criado para Mostrar a Janela interna de ConsultarContato
    private void bContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bContatoActionPerformed
       ConsultarContato consultarContato = new ConsultarContato();
       dpAreaInterna.add(consultarContato);
       consultarContato.setVisible(true);
    }//GEN-LAST:event_bContatoActionPerformed

    private void bGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGrupoActionPerformed
        ConsultarGrupo consultarGrupo = new ConsultarGrupo();
        dpAreaInterna.add(consultarGrupo);
        consultarGrupo.setVisible(true);
    }//GEN-LAST:event_bGrupoActionPerformed

    private void bUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUsuarioActionPerformed
        ConsultarUsuario consultarUsuario = new ConsultarUsuario();
        dpAreaInterna.add(consultarUsuario);
        consultarUsuario.setVisible(true);
    }//GEN-LAST:event_bUsuarioActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bContato;
    private javax.swing.JButton bGrupo;
    private javax.swing.JButton bSair;
    private javax.swing.JButton bUsuario;
    public static javax.swing.JDesktopPane dpAreaInterna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu mAjuda;
    private javax.swing.JMenu mCadastrar;
    private javax.swing.JMenu mConsultar;
    // End of variables declaration//GEN-END:variables

    
    //Pequena ganbi para conseguir salvar um contato no banco de Dados
    public static int codigoUsuarioLogado = 1;
}
