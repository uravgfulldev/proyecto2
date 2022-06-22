/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import entidades.Compra;
import entidades.DetallesCompras;
import entidades.Usuario;
import entidades.Videojuego;
import implementaciones.ConexionBD;
import interfaces.IConexionBD;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Hugo Rivera
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
         IConexionBD conexionBD=new ConexionBD();
         EntityManager em;
        try {
            
            Videojuego videojuego=new Videojuego("Fortnite","GAMES", 2, 100f);
           
            em=conexionBD.crearConexion();
            Usuario usuario =em.find(Usuario.class, 1L);
            Date fecha =new Date();
            Compra compra =new Compra(fecha,100f,usuario);
            DetallesCompras detallescompras=new DetallesCompras(1,100f,100f,compra,videojuego);
            em.getTransaction().begin();
            em.persist(detallescompras);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}
