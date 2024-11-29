/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors.Gerente;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.sql.*;
import sap.successfactors.ConexionBDD;

/**
 *
 * @author thiag
 */
public class Borrar_Entrevista_Codigo {
    String ID;

    public String getID() {
        return ID;
    }

    public void setID(String paramID) {
        this.ID = paramID;
    }
    
    public void EliminarEntrevista(JTextField paramCodigo) {
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "DELETE FROM Entrevistas WHERE IdEntrevista = ?;"; // Consulta SQL
        CallableStatement cs = null; // Declarar el CallableStatement fuera del try
        try {
            // Convertir el valor del JTextField a un entero
            int codigo = Integer.parseInt(paramCodigo.getText()); // Obtener el texto y convertirlo a int

            // Preparar la consulta
            cs = objetoConexion.Conectar().prepareCall(consulta);
            cs.setInt(1, codigo); // Establecer el valor del parámetro en la consulta

            // Ejecutar la consulta
            cs.execute();

            // Mensaje de éxito
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el registro");

        } catch (SQLException e) {
            // En caso de error
            JOptionPane.showMessageDialog(null, "No se eliminó correctamente el registro, error: " + e.toString());
        } finally {
            // Cerrar la conexión
            objetoConexion.cerrarConexionCs(cs);
        }
    }

    
    public void SeleccionarEntrevista(JTable paramTablaEntrevistas, JTextField paramID) {
        try {
            int fila = paramTablaEntrevistas.getSelectedRow();
            if (fila >= 0) {
                paramID.setText(paramTablaEntrevistas.getValueAt(fila, 0).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error:" + e.toString());
        }
    }
    public void MostrarEntrevistas(JTable paramTablaTotalEntrevistas) {
        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
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
            con = objetoConexion.Conectar();  // Establecer la conexión
            st = con.createStatement();
            rs = st.executeQuery(sql);
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
            // Cerrar los recursos (ResultSet, Statement y Connection)
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close(); // Cerrar Statement
                }
                if (con != null && !con.isClosed()) {
                    con.close(); // Cierra la conexión
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.toString());
            }
        }
    }

}
