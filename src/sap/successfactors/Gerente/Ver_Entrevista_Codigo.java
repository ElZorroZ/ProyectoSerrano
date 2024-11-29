/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors.Gerente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sap.successfactors.ConexionBDD;

/**
 *
 * @author thiag
 */
public class Ver_Entrevista_Codigo {
    public void MostrarEntrevistas(JTable paramTablaTotalEntrevistas) {
        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = objetoConexion.Conectar();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTablaTotalEntrevistas.setRowSorter(OrdenarTabla);

        modelo.addColumn("IDEntrevista");
        modelo.addColumn("IDEmpleado");
        modelo.addColumn("IDCandidato");
        modelo.addColumn("TipoEntrevista");
        modelo.addColumn("Fecha");
        modelo.addColumn("Puntuacion");
        modelo.addColumn("Comentario");

        paramTablaTotalEntrevistas.setModel(modelo);
        
        String sql = "SELECT * FROM Entrevistas";
        String[] datos = new String[7];

        try {
            Statement st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("IdEntrevista");
                datos[1] = rs.getString("IdEmpleado");  
                datos[2] = rs.getString("IdUsuario");   
                datos[3] = rs.getString("TipoEntrevista");   
                datos[4] = rs.getString("Fecha");   
                datos[5] = rs.getString("Puntuacion");   
                datos[6] = rs.getString("Comentario");   
               
                modelo.addRow(datos);
            }
            paramTablaTotalEntrevistas.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error:" + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
}
