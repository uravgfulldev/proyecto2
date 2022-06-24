/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import entidades.Compra;
import entidades.DetallesCompras;
import entidades.Usuario;
import entidades.Videojuego;
import implementaciones.ComprasDAO;
import implementaciones.ConexionBD;
import implementaciones.DetallesComprasDAO;
import implementaciones.UsuariosDAO;
import interfaces.IComprasDAO;
import interfaces.IConexionBD;
import interfaces.IDetallesComprasDAO;
import interfaces.IUsuariosDAO;
import java.time.LocalDate;
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
    
    public static void main(String[] args)  {
        // TODO code application logic here
         IConexionBD conexionBD=new ConexionBD();
         IUsuariosDAO usuarioDAO =new UsuariosDAO(conexionBD);
         IDetallesComprasDAO detallesComprasDAO=new DetallesComprasDAO(conexionBD);
         IComprasDAO compras=new ComprasDAO(conexionBD);
         EntityManager em;
        try {
//           Usuario usuario =new Usuario("Reta","63121231");
//           usuario.addCompra(new Compra(new Date(),100));
//           usuarioDAO.agregar(usuario);
//            for (Usuario usu: usuarioDAO.consultarTodos()) {
//                System.out.println(usu); 
//            }
//             Videojuego videojuego =new Videojuego("Fortnite","Ubisoft", 12, 100f);
//             em=conexionBD.crearConexion();
//             em.getTransaction().begin();
//             em.persist(videojuego);
//             em.getTransaction().commit();
               //em=conexionBD.crearConexion();
//               Videojuego videojuego=em.find(Videojuego.class, 4L);
//               Compra compra =em.find(Compra.class, 2L);
//               DetallesCompras detalles= new DetallesCompras(2,100f,133f,compra,videojuego);
//               //detallesComprasDAO.agregar(detalles);
//               System.out.println(detallesComprasDAO.consultar(videojuego));
               //usuarioDAO.eliminar(1L);
//               Usuario usuario=new Usuario("Julian","3413142");
//               usuarioDAO.agregar(usuario);
//               Date fechaD=new Date();
//               Usuario usu =em.find(Usuario.class, 1L);
//               Compra compra=new Compra(LocalDate.of(2022, 6, 22),100f,usu);
//               compras.agregar(compra);
               //System.out.println(compras.consultarTodos());
               UsuariosForm usuariosForm=new UsuariosForm();
               usuariosForm.setVisible(true);
               
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
    }
    
}
