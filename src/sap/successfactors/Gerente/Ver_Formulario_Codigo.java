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
        System.out.println(Id);
        Ver_Formulario_Seleccionado formu=new Ver_Formulario_Seleccionado(Id);
        formu.mostrar_id(Id);
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
    
    
    
    public ArrayList Select_Formularios(){//Hace un Select de todos los guardias
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uyhamlklqd4j3ukm:DfseeRtbCM0I8nRBGbLS@bfg6lbkde7ykp82fwejq-mysql.services.clever-cloud.com:3306/bfg6lbkde7ykp82fwejq","uyhamlklqd4j3ukm","DfseeRtbCM0I8nRBGbLS");                
            String query="SELECT id, Nombre FROM Formulario";
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getInt("id") + "-" + result.getString("Nombre");
                System.out.println(result.getInt("id") );
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
            System.out.println(id);
            PreparedStatement  query=miConexion.prepareStatement(str);
            query.setInt(1,id);
            ResultSet result = query.executeQuery();
            
            
            while(result.next()){
                String Item=result.getString("Id")+"-"+result.getString("Pregunta") ;
                array.add(Item);
                System.out.println("FUNCO");
                System.out.println("Item");


            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;    
        }
        
    }
}
