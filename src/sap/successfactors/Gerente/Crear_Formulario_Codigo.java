/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors.Gerente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import sap.successfactors.ConexionBDD;

/**
 *
 * @author PC
 */
public class Crear_Formulario_Codigo {
    public void Agregar_Formulario(String nombre, int cant, Queue<String>  OpcionesMapa, Map<String, Queue<String>> PreguntaOpcionesMapa, Queue<String> Preguntas){
        Insert_Formulario(nombre, cant);
        int id = Select_ID_Formulario(nombre);
        
        while (!Preguntas.isEmpty()){
            boolean opc=false;
            String pregunta=Preguntas.poll();
            System.out.println(pregunta);
            if (PreguntaOpcionesMapa.containsKey(pregunta)){
                System.out.println(PreguntaOpcionesMapa.get(pregunta));
                opc=true;
            } 

            Insert_Preguntas( id, pregunta,  opc);
        
            
            //int id_formu=Select_IdFormulario_Preguntas(id);
            
            Map<Integer, String>  mapa=Select_Preguntas(id);
            int idpregunta=0;
            for (Map.Entry<String, Queue<String>> peguntOpc: PreguntaOpcionesMapa.entrySet()){
                String preg=peguntOpc.getKey();
            
                for (Map.Entry<Integer,String> i: mapa.entrySet()){
                    
                    String ivalue=i.getValue();
                    if (preg.equals(ivalue) ){
                        
                        idpregunta=i.getKey();
                        Queue<String> Options=peguntOpc.getValue();
                        while (!Options.isEmpty()){
                            String opci =Options.poll();
                            Insert_Opciones(idpregunta, opci);
                        }
                    }
                    
                }
            }
        
            /*
            ArrayList array=conexion.Select_Zona_de_Seguridad();
        
            for (int i=0; i<array.size(); i++){
                modelo.addElement(array.get(i));
            }
*/
        }
        System.out.println("proceso terminado");
    }
    
    
    
    public Boolean Insert_Formulario(String nombre, int cant){//hace un insert en la tabla zona de seguridad
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");            
            PreparedStatement sele= miConexion.prepareStatement("INSERT INTO Formulario ( Nombre, Respuesta) VALUES (?,?)");

            
            sele.setString(1,nombre);
            sele.setInt(2,cant);
            

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
                Item=result.getInt("ID");
                


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
        
        
        
    public Map<Integer, String> Select_Preguntas(int id){//Seleciona todas las zonas de seguridad
        try{
            Map<Integer, String> mapa = new HashMap<>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");
            String str="SELECT * FROM Preguntas WHERE IdFormulario=?;";
            
            PreparedStatement  query=miConexion.prepareStatement(str);
            query.setInt(1,id);
            ResultSet result = query.executeQuery();
            
            
            while(result.next()){
                mapa.put(result.getInt("Id"),result.getString("Pregunta"));
                


            }
            
            miConexion.close();
            return mapa;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;    
        }
        
    }
    public Boolean Insert_Opciones(int IdPregunta,String opci){//hace un insert en la tabla zona de seguridad
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");            
            PreparedStatement sele= miConexion.prepareStatement("INSERT INTO Opciones (IdPregunta, Opcion) VALUES (?,?)");

            
            sele.setInt(1,IdPregunta);
            sele.setString(2,opci);
            

            sele.executeUpdate();

            miConexion.close();
            return(true);

        }catch(Exception e){
            System.out.println("No funca");

            e.printStackTrace();
            return(false);

        }
    }
    
    public int Select_IdFormulario_Preguntas(int id){//Seleciona todas las zonas de seguridad
        try{
            int Item = 0;
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");
            String str="SELECT IdFormulario FROM Preguntas Where Id = ?;";
            
            PreparedStatement  query=miConexion.prepareStatement(str);
            query.setInt(1,id);
            ResultSet result = query.executeQuery();
            
            
            while(result.next()){
                Item=result.getInt("IdFormulario");
                


            }
            
            miConexion.close();
            return Item;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return 0;    
        }
        
    }
}
