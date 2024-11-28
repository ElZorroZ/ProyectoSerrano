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
public class Crear_Entrevista_Codigo {
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void MostrarCandidatos(JTable paramTablaTotalCandidatos) {
        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = objetoConexion.Conectar();
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
    public void MostrarEmpleados(JTable paramTablaTotalEmpleados) {
        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = objetoConexion.Conectar();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTablaTotalEmpleados.setRowSorter(OrdenarTabla);

        modelo.addColumn("IDEmpleado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Email");

        paramTablaTotalEmpleados.setModel(modelo);
        
        String sql = "SELECT Id, Nombre, Apellido, Email FROM Usuario WHERE IdEstado= 2;";
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
            paramTablaTotalEmpleados.setModel(modelo);
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
    public void SeleccionarEmpleado(JTable paramTablaEmpleado, JTextField paramID) {
        try {
            int fila = paramTablaEmpleado.getSelectedRow();
            if (fila >= 0) {
                paramID.setText(paramTablaEmpleado.getValueAt(fila, 0).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error:" + e.toString());
        }
    }

    public void InsertarEntrevista(String IDCandidato, String IDEmpleado, String TipoEntrevista, java.sql.Date FechaEntrevista) {
        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = objetoConexion.Conectar();

        // Consulta para insertar en la base de datos
        String consulta = "INSERT INTO Entrevistas (IdUsuario, IdEmpleado, TipoEntrevista, Fecha) VALUES (?, ?, ?, ?);";

        try {
            // Preparar la consulta
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, IDCandidato);
            ps.setString(2, IDEmpleado);
            ps.setString(3, TipoEntrevista);

            // Convertir la fecha a un formato compatible con la base de datos
            java.sql.Date sqlFecha = new java.sql.Date(FechaEntrevista.getTime());
            ps.setDate(4, sqlFecha);

            // Ejecutar la consulta
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "La entrevista se insertó correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la entrevista: " + e.getMessage());
            e.printStackTrace();
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
}

