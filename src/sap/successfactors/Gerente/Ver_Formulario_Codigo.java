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
import java.util.Queue;
import javax.swing.DefaultListModel;

/**
 *
 * @author PC
 */
public class Ver_Formulario_Codigo {
    public DefaultListModel mostrar(DefaultListModel modelo){
        modelo.removeAllElements();
        ArrayList array=Select_Formularios();
        
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    
    public void mostrar_Pantalla_Formulario_Seleccionado(int id){
        int Id=id;
        Ver_Formulario_Seleccionado formu=new Ver_Formulario_Seleccionado(Id);
        formu.mostrar_id(Id);
        formu.setVisible(true);
        formu.setLocationRelativeTo(null);
        
    }
    
    public void mostrar_Pantalla_Pregunta(int id,String pregunta, int ID){
        int Id=id;
        int tienePregunta=Selec_cant_Pregunta(id);
        Ver_Pregunta formu=new Ver_Pregunta(Id, pregunta, tienePregunta, ID);
        //Corregir --- formu.mostrar_id(Id);
        formu.setVisible(true);
        formu.setLocationRelativeTo(null);
        
    }
    
    public DefaultListModel mostrar_Preguntas(DefaultListModel modelo, int id){
        modelo.removeAllElements();
        ArrayList array=Select_Preguntas(id);
        
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    
    public ArrayList mostrarOpciones(int id){//Mete todas las zonas de seguridad en una lista para mostrarla en otra pantalla
        ArrayList array=Select_Opciones(id);
        /*String[] vector=new String[array.size()];
        for (int i=0; i<array.size(); i++){
            vector[i]=(array.get(i));
        }*/
        return array;
        
    }
    
    
    
    
    
    public ArrayList Select_Formularios(){//Hace un Select de todos los guardias
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");                
            String query="SELECT id, Nombre FROM Formulario";
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getInt("id") + "-" + result.getString("Nombre");
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
    
    
    
    public ArrayList Select_Preguntas(int id){//Seleciona todas las zonas de seguridad
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");
            String str="SELECT * FROM Preguntas Where IdFormulario = ?;";
            PreparedStatement  query=miConexion.prepareStatement(str);
            query.setInt(1,id);
            ResultSet result = query.executeQuery();
            
            
            while(result.next()){
                String Item=result.getString("Id")+"-"+result.getString("Pregunta") ;
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
    
    public int Selec_cant_Pregunta(int id){//Seleciona todas las zonas de seguridad
        int Item;
        Item=2;
        try{
            
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");
            String str="SELECT Opcion FROM Preguntas Where Id = ?;";
            PreparedStatement  query=miConexion.prepareStatement(str);
            query.setInt(1,id);
            ResultSet result = query.executeQuery();
            
            
            while(result.next()){
                Item=result.getInt("Opcion") ;



            }
            
            miConexion.close();
            return Item;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return 2;    
        }
        
    }
    
    public ArrayList Select_Opciones(int id){//Seleciona todas las zonas de seguridad
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");
            System.out.println(id);
            String str="SELECT Opcion FROM Opciones Where IdPregunta = ?;";
            PreparedStatement  query=miConexion.prepareStatement(str);
            query.setInt(1,id);
            ResultSet result = query.executeQuery();
            
            
            while(result.next()){
                String Item=result.getString("Opcion") ;
                System.out.println(Item);
                array.add(Item);



            }
            
            miConexion.close();
            System.out.println(array);
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;    
        }
        
    }
}
