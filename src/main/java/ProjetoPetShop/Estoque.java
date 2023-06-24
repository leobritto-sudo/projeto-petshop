/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPetShop;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.ProdDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Prod;
/**
 *
 * @author 125111360337
 */
public class Estoque extends javax.swing.JFrame {
    String CPF = "";
    ProdDAO dao;
    /**
     * Creates new form Estoque
     */
    public Estoque(String CPF) throws SQLException {
        this.CPF = CPF;
        initComponents();
        carregaTabela();
    }
    
    
    private Estoque() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void carregaTabela() throws SQLException{
        dao = new ProdDAO();
        
        DefaultTableModel modelo = (DefaultTableModel) tEstoque.getModel();
        
        modelo.setNumRows(0);
        
        for(Prod p: dao.consultarPROD()){
            
            modelo.addRow(new Object[]{
                
                p.getId_produto(),
                p.getNome(),
                p.getQtd(),               
                p.getValor()               
                
            });                   
      
         }
    }
    public void carregaPesquisaTabela() throws SQLException{
        dao = new ProdDAO();
        
        Prod produtosPesquisa = new Prod(tfPesquisa.getText(), "", "", 0.00);
        
        DefaultTableModel modelo = (DefaultTableModel) tEstoque.getModel();
        
        modelo.setNumRows(0);
        
        for(Prod p: dao.pesquisarPROD(produtosPesquisa)){
            
            modelo.addRow(new Object[]{
                
                p.getId_produto(),
                p.getValor(),
                p.getQtd(),
                p.getNome()
                
            });                   
      
         }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tEstoque = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        tfPesquisa = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        txNome = new javax.swing.JTextField();
        txQTD = new javax.swing.JTextField();
        txPreço = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Quantidade", "Nome", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tEstoque);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 162, 788, 278));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESTOQUE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 788, 46));

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 551, -1, -1));

        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, -1, -1));

        btDeletar.setText("Deletar");
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 81, -1));

        tfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(tfPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 190, -1));

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));
        getContentPane().add(txNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 118, -1));
        getContentPane().add(txQTD, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 119, -1));
        getContentPane().add(txPreço, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 115, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Quantidade:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Preço:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, -1, -1));
        getContentPane().add(txID, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 515, -1, -1));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Dica: Selecione o item que deseja excluir e aperte o botão \"Deletar\"");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        jButton2.setText("Atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\ProjetoPetShop\\imagens\\cao-bonito-vista-frontal-com-espaco-de-copia.jpg")); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-410, -60, 1220, 650));

        setSize(new java.awt.Dimension(814, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
                
        try {
            dao.inserirPROD(new Prod(txID.getText(),txQTD.getText(), txNome.getText(), Double.parseDouble(txPreço.getText())));
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            carregaTabela();
        } catch (SQLException ex) {
            Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txNome.setText("");
        txQTD.setText("");
        txPreço.setText("");
        
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
         if (tEstoque.getSelectedRow() != -1) {

            Prod p = new Prod(tfPesquisa.getText(),"","",0.00);

            p.setId_produto((String) tEstoque.getValueAt(tEstoque.getSelectedRow(), 0));

             try {
                 dao.deletarPROD(p);
             } catch (SQLException ex) {
                 Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
             }

        txNome.setText("");
        txQTD.setText("");
        txPreço.setText("");
        
             try {     
                 carregaTabela();
             } catch (SQLException ex) {
                 Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
             }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
        
      
    }//GEN-LAST:event_btDeletarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        this.dispose();
        Menu menu_func;
        try {
            menu_func = new Menu(CPF);
            menu_func.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        try {
            carregaPesquisaTabela();
        } catch (SQLException ex) {
            Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            carregaTabela();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Estoque().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tEstoque;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JLabel txID;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txPreço;
    private javax.swing.JTextField txQTD;
    // End of variables declaration//GEN-END:variables
}
