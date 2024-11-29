/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors.RRHH;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class Ver_Entrevista_Codigo {
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
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
    public void MostrarEntrevistas(JTable paramTablaCandidato) {
        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTablaCandidato.setRowSorter(OrdenarTabla);

        // Definir las columnas de la tabla
        modelo.addColumn("IDEntrevista");
        modelo.addColumn("TipoEntrevista");
        modelo.addColumn("Fecha");
        modelo.addColumn("Puntuacion");
        modelo.addColumn("Comentario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Email");

        // Establecer el modelo de la tabla
        paramTablaCandidato.setModel(modelo);

        // Consulta SQL que une las tablas Entrevistas y Usuario, sin filtrar por un solo candidato
        String sql = "SELECT E.IdEntrevista, E.TipoEntrevista, E.Fecha, E.Puntuacion, E.Comentario, " +
                     "U.Nombre, U.Apellido, U.Email FROM Entrevistas E " +
                     "JOIN Usuario U ON E.IdUsuario = U.Id";

        // Array para almacenar los datos de la fila
        String[] datos = new String[8];

        try {
            con = objetoConexion.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Recorrer los resultados y llenar la tabla
            while (rs.next()) {
                datos[0] = rs.getString("IdEntrevista");
                datos[1] = rs.getString("TipoEntrevista");

                // Convertir la fecha en un formato adecuado
                java.sql.Date fechaSQL = rs.getDate("Fecha");
                if (fechaSQL != null) {
                    datos[2] = fechaSQL.toString(); // Convertir la fecha a String
                } else {
                    datos[2] = "";
                }

                datos[3] = rs.getString("Puntuacion");
                datos[4] = rs.getString("Comentario");
                datos[5] = rs.getString("Nombre");
                datos[6] = rs.getString("Apellido");
                datos[7] = rs.getString("Email");

                modelo.addRow(datos); // Añadir la fila al modelo
            }

            // Actualizar la tabla con el nuevo modelo
            paramTablaCandidato.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar entrevistas: " + e.toString());
        } finally {
            try {
                // Cerrar los recursos (PreparedStatement, ResultSet, Connection)
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close(); // Cerrar la conexión
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.toString());
            }
        }
    }
    public void InsertarResumen(String puntuacion, String comentario, String candidatoID) {
        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = null;
        PreparedStatement ps = null;

        // Corregir la consulta SQL
        String consulta = "UPDATE Entrevistas SET Puntuacion = ?, Comentario = ? WHERE IdEntrevista = ?;";

        try {
            con = objetoConexion.Conectar();  // Establecer la conexión
            ps = con.prepareStatement(consulta);

            // Asignar los parámetros de la consulta
            ps.setString(1, puntuacion);  // Puntuación seleccionada
            ps.setString(2, comentario);  // Comentario ingresado
            ps.setString(3, candidatoID); // ID del candidato (o entrevista)

            // Ejecutar la actualización
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Resumen de la entrevista actualizado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el resumen: " + e.toString());
        } finally {
            try {
                // Cerrar los recursos (PreparedStatement, Connection)
                if (ps != null) {
                    ps.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close(); // Cerrar la conexión
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.toString());
            }
        }
    }
}

