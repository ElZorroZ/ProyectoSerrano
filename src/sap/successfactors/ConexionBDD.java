/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.JOptionPane;
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
            // Asegúrate de que la URL esté correctamente formateada
            String url = "mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq";
            String user = "uyhamlklqd4j3ukm"; // Nombre de usuario
            String password = "DfseeRtbCM0I8nRBGbLS"; // Contraseña

            // Intenta establecer la conexión
            miConexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
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
    public Boolean Insert_Formulario(String instancia,String nombre, int cant){//hace un insert en la tabla zona de seguridad
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");            
            PreparedStatement sele= miConexion.prepareStatement("INSERT INTO Formulario (Instancia, Nombre, Respuesta) VALUES (?,?,?)");

            
            sele.setString(1,instancia);
            sele.setString(2,nombre);
            sele.setInt(3,cant);
            

            sele.executeUpdate();

            miConexion.close();
            return(true);

        }catch(Exception e){
            System.out.println("No funca");

            e.printStackTrace();
            return(false);

        }
    }
    public int Select_ID_Formulario(String nombre){//Seleciona todas las zonas de seguridad
        try{
            int Item = 0;
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");
            String str="SELECT ID FROM Formulario Where Nombre = ?;";
            
            PreparedStatement  query=miConexion.prepareStatement(str);
            query.setString(1,nombre);
            ResultSet result = query.executeQuery();
            
            
            while(result.next()){
                Item=result.getInt("Id");
                


            }
            
            miConexion.close();
            return Item;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return 0;    
        }
        
    }
        public Boolean Insert_Preguntas(int idForm,String pregunta, Boolean opc){//hace un insert en la tabla zona de seguridad
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");            
            PreparedStatement sele= miConexion.prepareStatement("INSERT INTO Preguntas (IdFormulario, Pregunta, Opcion) VALUES (?,?,?)");

            
            sele.setInt(1,idForm);
            sele.setString(2,pregunta);
            sele.setBoolean(3,opc);
            

            sele.executeUpdate();

            miConexion.close();
            return(true);

        }catch(Exception e){
            System.out.println("No funca");

            e.printStackTrace();
            return(false);

        }
    }
}
