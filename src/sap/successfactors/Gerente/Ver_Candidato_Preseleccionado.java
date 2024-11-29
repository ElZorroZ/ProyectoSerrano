/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors.Gerente;
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
public class Ver_Candidato_Preseleccionado {
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void MostrarCandidatosPreseleccionados(JTable paramTablaTotalCandidatos) {
        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTablaTotalCandidatos.setRowSorter(OrdenarTabla);

        modelo.addColumn("IDCandidato");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Email");

        paramTablaTotalCandidatos.setModel(modelo);

        String sql = "SELECT Id, Nombre, Apellido, Email FROM Usuario WHERE IdEstado= 4;";
        String[] datos = new String[4];

        try {
            con = objetoConexion.Conectar();  // Establecer la conexión
            st = con.createStatement();
            rs = st.executeQuery(sql);
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
            // Cerrar los recursos (ResultSet, Statement, Connection)
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close(); // Cierra la conexión
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.toString());
            }
        }
    }


    // Método para seleccionar el reembolso y obtener su ID
    public void SeleccionarCandidatoPreseleccionado(JTable paramTablaCandidato, JTextField paramID) {
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

        // Establecer el modelo de la tabla
        paramTablaCandidato.setModel(modelo);

        // La consulta SQL ahora incluye la tabla Respuestas
        String sql = "SELECT IdEntrevista, TipoEntrevista, Fecha, Puntuacion, Comentario FROM Entrevistas WHERE IdUsuario = ?";

        // Array para almacenar los datos de la fila
        String[] datos = new String[5];

        try {
            con = objetoConexion.Conectar(); // Establecer la conexión
            ps = con.prepareStatement(sql);
            ps.setString(1, candidatoID); // Pasamos el ID como parámetro
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

                modelo.addRow(datos); // Añadir la fila al modelo
            }

            // Actualizar la tabla con el nuevo modelo
            paramTablaCandidato.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar candidato: " + e.toString());
        } finally {
            // Cerrar los recursos (ResultSet, PreparedStatement, Connection)
            try {
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


    public void SeleccionarCandidato(JTextField paramID) {
        setID(paramID.getText());

        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = null;
        PreparedStatement ps = null;

        String consulta = "UPDATE Usuario SET IdEstado = 5 WHERE Id = ?;";

        try {
            con = objetoConexion.Conectar(); // Establecer la conexión
            ps = con.prepareStatement(consulta);
            ps.setString(1, ID);  // Asignamos el ID del candidato a la consulta

            ps.executeUpdate();  // Ejecutamos la actualización

            JOptionPane.showMessageDialog(null, "Se preseleccionó correctamente el candidato");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se logró preseleccionar, error: " + e.toString());
        } finally {
            // Cerrar los recursos (PreparedStatement, Connection)
            try {
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

    public void EliminarCandidato(JTextField paramID) {
        setID(paramID.getText()); // Establecer el ID a eliminar
        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = null;
        PreparedStatement psRespuestas = null;
        PreparedStatement psUsuario = null;

        // Consultas SQL
        String eliminarRespuestas = "DELETE FROM Respuestas WHERE IdUsuario = ?;";
        String eliminarUsuario = "DELETE FROM Usuario WHERE Id = ?;";

        try {
            con = objetoConexion.Conectar(); // Establecer la conexión
            con.setAutoCommit(false); // Iniciar transacción

            // Eliminar primero las respuestas asociadas
            psRespuestas = con.prepareStatement(eliminarRespuestas);
            psRespuestas.setString(1, ID);
            psRespuestas.executeUpdate(); // Ejecutar eliminación de respuestas

            // Eliminar al usuario
            psUsuario = con.prepareStatement(eliminarUsuario);
            psUsuario.setString(1, ID);
            int filasAfectadas = psUsuario.executeUpdate(); // Ejecutar eliminación de usuario

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El candidato fue eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un candidato con el ID proporcionado.");
            }

            // Confirmar la transacción si todo salió bien
            con.commit();
        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback(); // Revertir cambios si hay un error
                }
            } catch (Exception rollbackEx) {
                JOptionPane.showMessageDialog(null, "Error al hacer rollback: " + rollbackEx.toString());
            }
            JOptionPane.showMessageDialog(null, "Error al eliminar candidato: " + e.toString());
        } finally {
            try {
                // Cerrar los recursos (PreparedStatement, Connection)
                if (psRespuestas != null) {
                    psRespuestas.close();
                }
                if (psUsuario != null) {
                    psUsuario.close();
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
