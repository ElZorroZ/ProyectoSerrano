/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.JOptionPane;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
/**
 *
 * @author PC
 *///

    
/**
 *
 * @author PC
 */
public class ConexionBDD {
    private Connection miConexion = null;
    public Connection Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Asegúrate de que la URL esté correctamente formateada
            String url = "jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq";
            String user = "uyhamlklqd4j3ukm"; // Nombre de usuario
            String password = "DfseeRtbCM0I8nRBGbLS"; // Contraseña

            // Intenta establecer la conexión
            miConexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) { 
                System.out.println("Driver JDBC no encontrado."); e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        
        return miConexion; // Retorna la conexión (puede ser nula si hubo un error)
    }
    public void cerrarConexionRsPst(PreparedStatement pst, ResultSet rs) {
        try {
            // Cerrar ResultSet
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet cerrado");
            }

            // Cerrar PreparedStatement
            if (pst != null) {
                pst.close();
                System.out.println("PreparedStatement cerrado");
            }

            // Cerrar la conexión
            if (miConexion != null && !miConexion.isClosed()) {
                miConexion.close(); // Cierra la conexión
                System.out.println("Conexion Cerrada");
            }

        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión o recursos: " + e.toString());
        }
    }
    public void cerrarConexionCs(CallableStatement cs) {
        try {

             // Cerrar CallableStatement
            if (cs != null) {
                cs.close();
                System.out.println("CallableStatement cerrado");
            }

            // Cerrar la conexión
            if (miConexion != null && !miConexion.isClosed()) {
                miConexion.close(); // Cierra la conexión
                System.out.println("Conexion Cerrada");
            }

        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión o recursos: " + e.toString());
        }
    }
    public void cerrarConexionRs(ResultSet rs) {
        try {

            // Cerrar ResultSet
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet cerrado");
            }

            // Cerrar la conexión
            if (miConexion != null && !miConexion.isClosed()) {
                miConexion.close(); // Cierra la conexión
                System.out.println("Conexion Cerrada");
            }

        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión o recursos: " + e.toString());
        }
    }
    public void cerrarConexionRsSt(ResultSet rs, Statement st) {
        try {

            // Cerrar ResultSet
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet cerrado");
            }
            if (st != null) {
                st.close(); // Cerrar Statement
            }

            // Cerrar la conexión
            if (miConexion != null && !miConexion.isClosed()) {
                miConexion.close(); // Cierra la conexión
                System.out.println("Conexion Cerrada");
            }

        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión o recursos: " + e.toString());
        }
    }
    public void cerrarConexion2() {
        try {
            if (miConexion != null && !miConexion.isClosed()) {
                miConexion.close(); // Cierra la conexión
                //JOptionPane.showMessageDialog(null, "Conexión cerrada");
                System.out.println("Conexion Cerrada");
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexión: " + e.toString());
            System.out.println("No se pudo cerrar la conexión: " + e.toString());
        }
    }


}
