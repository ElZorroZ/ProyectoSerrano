/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors.RRHH;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sap.successfactors.ConexionBDD;

/**
 *
 * @author thiag
 */
public class Ver_Candidatos {
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void MostrarCandidatos(JTable paramTablaTotalCandidatos) {
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTablaTotalCandidatos.setRowSorter(OrdenarTabla);

        modelo.addColumn("IDCandidato");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Email");

        paramTablaTotalCandidatos.setModel(modelo);
        
        String sql = "SELECT Id, Nombre, Apellido, Email FROM Usuario WHERE IdEstado= 3;";
        String[] datos = new String[4];

        try {
            Statement st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("Id");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Apellido");
                datos[3] = rs.getString("Email");    
                
                modelo.addRow(datos);
            }
            paramTablaTotalCandidatos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error:" + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    // Método para seleccionar el reembolso y obtener su ID
    public void SeleccionarCandidato(JTable paramTablaCandidato, JTextField paramID) {
        try {
            int fila = paramTablaCandidato.getSelectedRow();
            if (fila >= 0) {
                paramID.setText(paramTablaCandidato.getValueAt(fila, 0).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error:" + e.toString());
        }
    }
    public void MostrarCandidatoPorID(JTable paramTablaCandidato, String candidatoID) {
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTablaCandidato.setRowSorter(OrdenarTabla);

        // Agregar columnas correspondientes al modelo de la tabla
        modelo.addColumn("IDFormulario");
        modelo.addColumn("Pregunta");
        modelo.addColumn("Respuesta");

        paramTablaCandidato.setModel(modelo);

        // Consulta SQL corregida
        String sql = "SELECT r.IdFormulario, p.Pregunta, r.RespuestasUsuario " +
                     "FROM Respuestas r " +
                     "INNER JOIN Preguntas p ON r.IdPregunta = p.Id " +
                     "WHERE r.IdUsuario = ?";

        try (PreparedStatement ps = objetoConexion.Conectar().prepareStatement(sql)) {
            ps.setString(1, candidatoID); // Establecer el parámetro del ID del usuario
            ResultSet rs = ps.executeQuery();

            // Crear un arreglo de 3 posiciones para cada fila
            String[] datos = new String[3];

            while (rs.next()) {
                datos[0] = rs.getString("IdFormulario");  // ID del formulario
                datos[1] = rs.getString("Pregunta");      // Texto de la pregunta
                datos[2] = rs.getString("RespuestasUsuario"); // Respuesta del usuario

                modelo.addRow(datos); // Agregar la fila al modelo
            }

            // Establecer el modelo actualizado en la tabla
            paramTablaCandidato.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar candidato: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    public void PreseleccionarCandidato(JTextField paramID) {
        setID(paramID.getText());
    
        ConexionBDD objetoConexion = new ConexionBDD();

        String consulta = "UPDATE Usuario SET IdEstado = 4 WHERE Id = ?;";

        try {
            // Usamos un PreparedStatement, no CallableStatement para consultas SQL estándar
            PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta);
            ps.setString(1, ID);  // Asignamos el ID del candidato a la consulta

            ps.executeUpdate();  // Ejecutamos la actualización

            JOptionPane.showMessageDialog(null, "Se preseleccionó correctamente el candidato");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se logró preseleccionar, error: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
    public void EliminarCandidato(JTextField paramID) {
        setID(paramID.getText());
        ConexionBDD objetoConexion = new ConexionBDD();

        String consulta = "DELETE FROM Usuario WHERE Id = ?;";

        try {
            PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta);
            ps.setString(1, ID); // Pasamos el ID del candidato como parámetro

            int filasAfectadas = ps.executeUpdate(); // Ejecutamos la consulta

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El candidato fue eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un candidato con el ID proporcionado.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar candidato: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

}
