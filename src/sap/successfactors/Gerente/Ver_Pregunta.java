/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors.Gerente;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author PC
 */
public class Ver_Pregunta extends javax.swing.JFrame {
    ArrayList array = new ArrayList<>();
    int ID_Formulario;
    
    
    /**
     * Creates new form Ver_Pregunta
     */
    public Ver_Pregunta(int id, String pregunta, int tienePregunta, int ID) {
        ID_Formulario=ID;
        initComponents();
        Ver_Formulario_Codigo codigo=new Ver_Formulario_Codigo();
        
        array=codigo.mostrarOpciones(id);
        
        Boolean ilo=Ocultar();
        
        
        lbl_Pregunta.setText(pregunta);
        if(tienePregunta==1){
            System.out.println("Tamaño del array: " + array.size());
            for (int i = 0; i < array.size(); i++) {
                System.out.println("Elemento " + i + ": " + array.get(i));  // Verificar los elementos
            }
            for (int i=0; i<array.size(); i++){
                ComboBox_Respuest.addItem(array.get(i).toString());
            }
            ComboBox_Respuest.setVisible(true);
                
            
        }
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
        jPanel2 = new javax.swing.JPanel();
        lbl_Pregunta = new javax.swing.JLabel();
        txtf_Respuesta = new javax.swing.JTextField();
        ComboBox_Respuest = new javax.swing.JComboBox<>();
        btn_Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_Pregunta.setText("jLabel1");

        txtf_Respuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf_RespuestaActionPerformed(evt);
            }
        });

        ComboBox_Respuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_RespuestActionPerformed(evt);
            }
        });

        btn_Volver.setText("Volver");
        btn_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_Pregunta, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(txtf_Respuesta)
                    .addComponent(ComboBox_Respuest, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(89, 89, 89))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Volver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Volver)
                .addGap(2, 2, 2)
                .addComponent(lbl_Pregunta)
                .addGap(48, 48, 48)
                .addComponent(txtf_Respuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBox_Respuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void ComboBox_RespuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_RespuestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_RespuestActionPerformed

    private void txtf_RespuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf_RespuestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtf_RespuestaActionPerformed

    private void btn_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VolverActionPerformed
        Ver_Formulario_Seleccionado  vFs = new Ver_Formulario_Seleccionado(ID_Formulario);
        this.setVisible(false);
        vFs.setVisible(true);
        vFs.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_VolverActionPerformed

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ver_Pregunta().setVisible(true);
            }
        });
    }
*/
    public Boolean Ocultar(){
        if (txtf_Respuesta == null) {
            System.out.println("txtf_Respuesta no está inicializado.");
        }
        if (ComboBox_Respuest == null) {
          System.out.println("ComboBox_Respuest no está inicializado.");
        }else{
        txtf_Respuesta.setVisible(false);
        ComboBox_Respuest.setVisible(false);
        }
        return true;
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_Respuest;
    private javax.swing.JButton btn_Volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_Pregunta;
    private javax.swing.JTextField txtf_Respuesta;
    // End of variables declaration//GEN-END:variables
    
}

