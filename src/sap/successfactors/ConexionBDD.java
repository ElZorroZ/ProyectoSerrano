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
    
    public Connection Conectar() {
        Connection miConexion = null; // Inicializa la conexión como nula
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
    public ArrayList Select_Estado(){//Seleciona todas las zonas de seguridad
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");
            String query="SELECT * FROM Estado;";
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getInt("Id") + "-" + result.getString("Estado_Usuario");
                array.add(Item);


            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;    
        }
        
    }
    /*
    public void subirArchivo(File archivo) {
    if (archivo == null || !archivo.exists()) {
        JOptionPane.showMessageDialog(null, "Archivo no válido o inexistente.");
        return;
    }
    String Nombre ="Julian";
    String Apellido ="Hernandez";
    String Mail ="JotaHernandez@gmail.com";
    String Contrasenia ="Julian";
    int IdEstado =3;
    
    String url = "mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq";
    String user = "uyhamlklqd4j3ukm"; // Nombre de usuario
    String password = "DfseeRtbCM0I8nRBGbLS"; // Contraseña
    try (Connection conexion = DriverManager.getConnection(url, user, password)) {
        String sql = "INSERT INTO Usuario (Nombre, Apellido, Mail, Contrasenia, IdEstado, CV) VALUES (?, ?,?, ?,?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, Nombre);
            stmt.setString(2, Apellido);
            stmt.setString(3, Mail);
            stmt.setString(4, Contrasenia);
            stmt.setInt(5, IdEstado);

            // Leer el archivo como flujo de bytes
            FileInputStream fis = new FileInputStream(archivo);
            stmt.setBinaryStream(6, fis, (int) archivo.length());

            // Ejecutar la consulta
            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Archivo subido correctamente.");
            }

            fis.close();
        }
    } catch (SQLException | IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al subir el archivo: " + ex.getMessage());
    }
}*/
    
}