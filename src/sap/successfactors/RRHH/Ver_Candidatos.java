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

        modelo.addColumn("IDCandidato");
        modelo.addColumn("IDFormulario");
        modelo.addColumn("Respuesta");

        paramTablaCandidato.setModel(modelo);

        // La consulta SQL ahora incluye el FROM Respuestas
        String sql = "SELECT IdUsuario, IdFormulario, RespuestasUsuario FROM Respuestas WHERE IdUsuario = ?";
        String[] datos = new String[3];

        try (PreparedStatement ps = objetoConexion.Conectar().prepareStatement(sql)) {
            ps.setString(1, candidatoID); // Pasamos el ID como parámetro
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                datos[0] = rs.getString("IdUsuario");
                datos[1] = rs.getString("IdFormulario");
                datos[2] = rs.getString("RespuestasUsuario");

                modelo.addRow(datos);
            }
            paramTablaCandidato.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar candidato: " + e.toString());
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
        }
    }

}
