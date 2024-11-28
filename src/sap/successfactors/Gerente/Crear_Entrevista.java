/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors.Gerente;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sap.successfactors.Gerente.Crear_Entrevista_Codigo;

/**
 *
 * @author thiag
 */
public class Crear_Entrevista extends javax.swing.JFrame {

    /**
     * Creates new form Crear_Entrevista
     */
    public Crear_Entrevista() {
        initComponents();
        Crear_Entrevista_Codigo objetoEntrevista = new Crear_Entrevista_Codigo();
        objetoEntrevista.MostrarCandidatos(TablaCandidatos);
        objetoEntrevista.MostrarEmpleados(TablaEmpleados);
        jComboBox_TipoEntrevista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apto Medico", "Habilidades", "Idioma" }));
        datechooser_FechaInicio.getDateEditor().setEnabled(false);
        datechooser_FechaInicio.setMinSelectableDate(new Date());
        JTextField_IDCandidato.setVisible(false); 
        JTextField_IDEmpleado.setVisible(false); 

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
        btn_volver = new javax.swing.JButton();
        jComboBox_TipoEntrevista = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        datechooser_FechaInicio = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCandidatos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        Btn_CrearEntrevista = new javax.swing.JToggleButton();
        JTextField_IDCandidato = new javax.swing.JTextField();
        JTextField_IDEmpleado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        jComboBox_TipoEntrevista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Tipo de entrevista");

        jLabel2.setText("Fecha de la entrevista");

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

        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaEmpleados);

        Btn_CrearEntrevista.setText("Crear Entrevistar");
        Btn_CrearEntrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CrearEntrevistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_volver)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jComboBox_TipoEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datechooser_FechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(JTextField_IDCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Btn_CrearEntrevista)
                                        .addGap(66, 66, 66)
                                        .addComponent(JTextField_IDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(181, 181, 181)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JTextField_IDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_volver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_TipoEntrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datechooser_FechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Btn_CrearEntrevista))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(JTextField_IDCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        Pantalla_JefeRRHH vG = new Pantalla_JefeRRHH();
        this.setVisible(false);
        vG.setSize(600,500);
        vG.setLocationRelativeTo(null);
        vG.setVisible(true);
    }//GEN-LAST:event_btn_volverActionPerformed

    private void TablaCandidatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCandidatosMouseClicked
        Crear_Entrevista_Codigo objetoEntrevista = new Crear_Entrevista_Codigo();
        objetoEntrevista.SeleccionarCandidato(TablaCandidatos, JTextField_IDCandidato);
    }//GEN-LAST:event_TablaCandidatosMouseClicked

    private void TablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEmpleadosMouseClicked
        Crear_Entrevista_Codigo objetoEntrevista = new Crear_Entrevista_Codigo();
        objetoEntrevista.SeleccionarEmpleado(TablaEmpleados, JTextField_IDEmpleado);
    }//GEN-LAST:event_TablaEmpleadosMouseClicked

    private void Btn_CrearEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CrearEntrevistaActionPerformed
        Crear_Entrevista_Codigo objetoEntrevista = new Crear_Entrevista_Codigo();
        try {
            // Validar campos antes de intentar insertar
            if (JTextField_IDCandidato.getText().isEmpty() || JTextField_IDEmpleado.getText().isEmpty() || 
                jComboBox_TipoEntrevista.getSelectedItem() == null || datechooser_FechaInicio.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            java.sql.Date sqlFecha = new java.sql.Date(datechooser_FechaInicio.getDate().getTime());

            // Llamar al método para insertar entrevista
            objetoEntrevista.InsertarEntrevista(
                JTextField_IDCandidato.getText(),
                JTextField_IDEmpleado.getText(),
                jComboBox_TipoEntrevista.getSelectedItem().toString(),
                sqlFecha
            );

            // Refrescar tablas
            objetoEntrevista.MostrarCandidatos(TablaCandidatos);
            objetoEntrevista.MostrarEmpleados(TablaEmpleados);

            // Limpiar selección
            TablaCandidatos.clearSelection();
            TablaEmpleados.clearSelection();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al crear la entrevista: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
        }
    }//GEN-LAST:event_Btn_CrearEntrevistaActionPerformed

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
            java.util.logging.Logger.getLogger(Crear_Entrevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_Entrevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_Entrevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_Entrevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_Entrevista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Btn_CrearEntrevista;
    private javax.swing.JTextField JTextField_IDCandidato;
    private javax.swing.JTextField JTextField_IDEmpleado;
    private javax.swing.JTable TablaCandidatos;
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JButton btn_volver;
    private com.toedter.calendar.JDateChooser datechooser_FechaInicio;
    private javax.swing.JComboBox<String> jComboBox_TipoEntrevista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
