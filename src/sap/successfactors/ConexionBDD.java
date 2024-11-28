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
    public void cerrarConexion() {
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
