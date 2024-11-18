/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors;
import java.util.ArrayList;
import sap.successfactors.Pantalla_Inicio;

/**
 *
 * @author PC
 */
public class SAPSuccessFactors {
    ConexionBDD conexion=new ConexionBDD();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Pantalla_Inicio pantalla=new Pantalla_Inicio();
        pantalla.setVisible(true);
        pantalla.setSize(500,450);
        pantalla.setLocationRelativeTo(null);
        
        
    }
    
}
