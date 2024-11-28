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
public class Borrar_Formulario_Codigo {
    String ID;

    public String getID() {
        return ID;
    }

    public void setID(String paramID) {
        this.ID = paramID;
    }
    
    public void EliminarFormulario(JTextField paramID) {
        setID(paramID.getText());
        ConexionBDD objetoConexion = ConexionBDD.getInstancia();
        Connection con = objetoConexion.Conectar();

        // Consultas SQL para eliminar registros en el orden correcto
        String eliminarRespuestas = "DELETE FROM Respuestas WHERE IdFormulario = ?";
        String eliminarOpciones = "DELETE FROM Opciones WHERE IdPregunta IN (SELECT Id FROM Preguntas WHERE IdFormulario = ?)";
        String eliminarPreguntas = "DELETE FROM Preguntas WHERE IdFormulario = ?";
        String eliminarFormulario = "DELETE FROM Formulario WHERE Id = ?";

        try (Connection conexion = objetoConexion.Conectar()) {
            
            // Comenzamos una transacción
            conexion.setAutoCommit(false);

            try (PreparedStatement psRespuestas = conexion.prepareStatement(eliminarRespuestas);
                 PreparedStatement psOpciones = conexion.prepareStatement(eliminarOpciones);
                 PreparedStatement psPreguntas = conexion.prepareStatement(eliminarPreguntas);
                 PreparedStatement psFormulario = conexion.prepareStatement(eliminarFormulario)) {

                // Eliminamos las respuestas asociadas al formulario
                psRespuestas.setString(1, ID);
                psRespuestas.executeUpdate();

                // Eliminamos las opciones asociadas a las preguntas del formulario
                psOpciones.setString(1, ID);
                psOpciones.executeUpdate();

                // Eliminamos las preguntas asociadas al formulario
                psPreguntas.setString(1, ID);
                psPreguntas.executeUpdate();

                // Finalmente, eliminamos el formulario
                psFormulario.setString(1, ID);
                psFormulario.executeUpdate();

                // Confirmamos la transacción
                conexion.commit();

                JOptionPane.showMessageDialog(null, "El formulario y sus dependencias fueron eliminados correctamente.");
            } catch (Exception e) {
                conexion.rollback(); // Si ocurre un error, revertimos la transacción
                JOptionPane.showMessageDialog(null, "Error al eliminar el formulario: " + e.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.toString());
        }
    }
    public void SeleccionarFormulario(JTable paramTablaFormulario, JTextField paramID) {
        try {
            int fila = paramTablaFormulario.getSelectedRow();
            if (fila >= 0) {
                paramID.setText(paramTablaFormulario.getValueAt(fila, 0).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error:" + e.toString());
        }
    }
    public void MostrarFormularios(JTable paramTablaTotalFormularios) {
        ConexionBDD objetoConexion = ConexionBDD.getInstancia();
        Connection con = objetoConexion.Conectar();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTablaTotalFormularios.setRowSorter(OrdenarTabla);

        modelo.addColumn("IDFormulario");
        modelo.addColumn("Nombre");
        paramTablaTotalFormularios.setModel(modelo);
        
        String sql = "SELECT * FROM Formulario";
        String[] datos = new String[2];

        try {
            Statement st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("Id");
                datos[1] = rs.getString("Nombre");   
               
                modelo.addRow(datos);
            }
            paramTablaTotalFormularios.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error:" + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
}
