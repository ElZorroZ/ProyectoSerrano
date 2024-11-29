/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap.successfactors;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author thiag
 */
public class InicioSesion {
    private String usuario;
    private String contra;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int IngresarSesion(JTextField paramUsuario, JTextField paramContra) {
        setUsuario(paramUsuario.getText());
        setContra(paramContra.getText());
        ConexionBDD objetoConexion = new ConexionBDD();
        Connection con = objetoConexion.Conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int idEstado = -1; // Valor por defecto si no se encuentra el usuario
        try {
            String sql = "SELECT * FROM Usuario WHERE Email = ? AND Contrasenia = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, contra);

            rs = pst.executeQuery();

            if (rs.next()) {
                idEstado = rs.getInt("IdEstado");
                System.out.println("Inicio de sesión exitoso");
            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            objetoConexion.cerrarConexionRsPst(pst,rs);
        }
        return idEstado;
        
    }
}


