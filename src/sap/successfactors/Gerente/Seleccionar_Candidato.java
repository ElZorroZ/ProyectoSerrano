/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors.Gerente;

/**
 *
 * @author thiag
 */
public class Seleccionar_Candidato extends javax.swing.JFrame {
    private String ID;

    /**
     * Creates new form Seleccionar_Candidato
     */
    public Seleccionar_Candidato() {
        initComponents();
        JTextField_ID.setVisible(false); 
        Ver_Candidato_Preseleccionado objetoCandidato = new Ver_Candidato_Preseleccionado();
        objetoCandidato.MostrarCandidatosPreseleccionados(TablaCandidatos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCandidatos = new javax.swing.JTable();
        Btn_Seleccionar = new javax.swing.JButton();
        Btn_Revisar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        JTextField_ID = new javax.swing.JTextField();
        btn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaCandidatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaCandidatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCandidatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCandidatos);

        Btn_Seleccionar.setText("Seleccionar Candidato");
        Btn_Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SeleccionarActionPerformed(evt);
            }
        });

        Btn_Revisar.setText("Revisar Entrevistas del Candidato");
        Btn_Revisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RevisarActionPerformed(evt);
            }
        });

        Btn_Eliminar.setText("Eliminar Candidato");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_Revisar)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Seleccionar)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_Eliminar)
                        .addGap(113, 113, 113)
                        .addComponent(JTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_volver)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_volver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Revisar)
                    .addComponent(Btn_Seleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTextField_ID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_Eliminar)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaCandidatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCandidatosMouseClicked
        Ver_Candidato_Preseleccionado objetoCandidato = new Ver_Candidato_Preseleccionado();
        objetoCandidato.SeleccionarCandidatoPreseleccionado(TablaCandidatos, JTextField_ID);
        ID = JTextField_ID.getText();
// TODO add your handling code here:
    }//GEN-LAST:event_TablaCandidatosMouseClicked

    private void Btn_SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SeleccionarActionPerformed
        Ver_Candidato_Preseleccionado objetoCandidato = new Ver_Candidato_Preseleccionado();
        try {
            objetoCandidato.SeleccionarCandidato(JTextField_ID);
            objetoCandidato.MostrarCandidatosPreseleccionados(TablaCandidatos);
        } catch (Exception e) {
            System.err.println("Error al seleccionar candidato: " + e.getMessage());
        }
        TablaCandidatos.clearSelection();
    }//GEN-LAST:event_Btn_SeleccionarActionPerformed

    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        Ver_Candidato_Preseleccionado objetoCandidato = new Ver_Candidato_Preseleccionado();
        try {
            objetoCandidato.EliminarCandidato(JTextField_ID);
            objetoCandidato.MostrarCandidatosPreseleccionados(TablaCandidatos);
        } catch (Exception e) {
            System.err.println("Error al eliminar candidato: " + e.getMessage());
        }
        TablaCandidatos.clearSelection();                                      
    }//GEN-LAST:event_Btn_EliminarActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        Pantalla_JefeRRHH vG = new Pantalla_JefeRRHH();
        this.setVisible(false);
        vG.setSize(600,500);
        vG.setLocationRelativeTo(null);
        vG.setVisible(true);
    }//GEN-LAST:event_btn_volverActionPerformed

    private void Btn_RevisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_RevisarActionPerformed
        String candidatoID = JTextField_ID.getText();

        // Abre la nueva ventana con los detalles del candidato
        Revisar_Datos_Candidato_Preseleccionado vR = new Revisar_Datos_Candidato_Preseleccionado(candidatoID);
        this.setVisible(false);
        vR.setLocationRelativeTo(null);
        vR.setVisible(true);
    }//GEN-LAST:event_Btn_RevisarActionPerformed

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
            java.util.logging.Logger.getLogger(Seleccionar_Candidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Candidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Candidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Candidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seleccionar_Candidato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_Revisar;
    private javax.swing.JButton Btn_Seleccionar;
    private javax.swing.JTextField JTextField_ID;
    private javax.swing.JTable TablaCandidatos;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
