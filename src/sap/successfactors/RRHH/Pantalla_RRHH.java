/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors.RRHH;
import sap.successfactors.RRHH.Preseleccionar_Candidato;
import sap.successfactors.Pantalla_Inicio;
import sap.successfactors.Gerente.Ver_Formulario;

/**
 *
 * @author thiag
 */
public class Pantalla_RRHH extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla_RRHH
     */
    public Pantalla_RRHH() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Formularios = new javax.swing.JButton();
        Btn_Preseleccionar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_Formularios.setText("Revisar formulario");
        btn_Formularios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FormulariosActionPerformed(evt);
            }
        });

        Btn_Preseleccionar.setText("Preseleccionar candidatos");
        Btn_Preseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PreseleccionarActionPerformed(evt);
            }
        });

        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_Preseleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Formularios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_volver)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_volver)
                .addGap(27, 27, 27)
                .addComponent(btn_Formularios)
                .addGap(33, 33, 33)
                .addComponent(Btn_Preseleccionar)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_PreseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PreseleccionarActionPerformed
        Preseleccionar_Candidato vP = new Preseleccionar_Candidato();
        this.setVisible(false);
        vP.setLocationRelativeTo(null);
        vP.setVisible(true);
    }//GEN-LAST:event_Btn_PreseleccionarActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        Pantalla_Inicio vM = new Pantalla_Inicio();
        this.setVisible(false);
        vM.setSize(600,500);
        vM.setLocationRelativeTo(null);
        vM.setVisible(true);
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_FormulariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FormulariosActionPerformed
        Ver_Formulario ver=new Ver_Formulario();
        ver.setLocationRelativeTo(null);
        ver.setVisible(true);
    }//GEN-LAST:event_btn_FormulariosActionPerformed

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
            java.util.logging.Logger.getLogger(Pantalla_RRHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla_RRHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla_RRHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla_RRHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla_RRHH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Preseleccionar;
    private javax.swing.JButton btn_Formularios;
    private javax.swing.JButton btn_volver;
    // End of variables declaration//GEN-END:variables
}
