/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors.Candidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Ver_Notificaciones_Codigo {
    public void MostrarEntrevistas(JTable paramTablaCandidato, int idusuario) {
        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTablaCandidato.setRowSorter(OrdenarTabla);

        // Definir las columnas de la tabla
        modelo.addColumn("TipoEntrevista");
        modelo.addColumn("Fecha");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Email");

        // Establecer el modelo de la tabla
        paramTablaCandidato.setModel(modelo);

        // Consulta SQL que une las tablas Entrevistas y Usuario, filtrando por IdUsuario
        String sql = "SELECT E.TipoEntrevista, E.Fecha, U.Nombre, U.Apellido, U.Email " +
                     "FROM Entrevistas E " +
                     "JOIN Usuario U ON E.IdEmpleado = U.Id " +
                     "WHERE E.IdUsuario = ?";  // Filtrar por IdUsuario

        // Array para almacenar los datos de la fila
        String[] datos = new String[5];  // Solo 5 columnas ahora

        try {
            con = objetoConexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idusuario);  // Establecer el parámetro IdUsuario

            rs = ps.executeQuery();

            // Recorrer los resultados y llenar la tabla
            while (rs.next()) {
                datos[0] = rs.getString("TipoEntrevista");

                // Convertir la fecha en un formato adecuado
                java.sql.Date fechaSQL = rs.getDate("Fecha");
                if (fechaSQL != null) {
                    datos[1] = fechaSQL.toString(); // Convertir la fecha a String
                } else {
                    datos[1] = "";
                }

                datos[2] = rs.getString("Nombre");
                datos[3] = rs.getString("Apellido");
                datos[4] = rs.getString("Email");

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

}
