/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author PC
 */
public class Crear_Formulario_Codigo {
    ConexionBDD conexion = new ConexionBDD();
    public void Agregar_Formulario(String instancia,String nombre, int cant, Map<String, Boolean> OpcionesMapa, Map<String, Map<String, Boolean> > PreguntaOpcionesMapa, Queue<String> Preguntas){
        conexion.Insert_Formulario( instancia, nombre, cant);
        int id = conexion.Select_ID_Formulario(nombre);
        
        while (!Preguntas.isEmpty()){
            boolean opc=false;
            String pregunta=Preguntas.poll();
            System.out.println(pregunta);
            if (PreguntaOpcionesMapa.containsKey(pregunta)){
                System.out.println(PreguntaOpcionesMapa.get(pregunta));
                opc=true;
            } 

            conexion.Insert_Preguntas( id, pregunta,  opc);
            /*
            ArrayList array=conexion.Select_Zona_de_Seguridad();
        
            for (int i=0; i<array.size(); i++){
                modelo.addElement(array.get(i));
            }
*/
        }
        
    }
}
