/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Compra;
import entidades.DetallesCompras;
import entidades.Videojuego;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IDetallesComprasDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Hugo Rivera
 */
public class DetallesComprasDAO implements IDetallesComprasDAO{
    private final IConexionBD conexionBD;

    public DetallesComprasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public void agregar(DetallesCompras detalles) throws PersistenciaException {
        try{
            EntityManager em =this.conexionBD.crearConexion();
            em.getTransaction().begin();
            em.persist(detalles);
            em.getTransaction().commit();
           
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new PersistenciaException("La relacion detallesCompras no fue agregada");
            
        }
    }

    

    @Override
    public List<DetallesCompras> consultar(Compra compra) throws PersistenciaException {
        try {
            EntityManager em;
            em=conexionBD.crearConexion();
            CriteriaBuilder cb=em.getCriteriaBuilder();
            CriteriaQuery<DetallesCompras> c=cb.createQuery(DetallesCompras.class);
            Root<DetallesCompras> q=c.from(DetallesCompras.class);
            //Condicion equal
            Predicate igualA=cb.equal(q.get("compra"),compra);
            c.where(igualA);
            //Convertir a TypedQuery para conseguir un resultlist
            TypedQuery<DetallesCompras> query=em.createQuery(c);
            
            return query.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(DetallesComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudieron recuperar los detalles");
        }
        
    }

    @Override
    public List<DetallesCompras> consultar(Videojuego videojuego) throws PersistenciaException {
        try {
            EntityManager em=conexionBD.crearConexion();
            CriteriaBuilder cb=em.getCriteriaBuilder();
            CriteriaQuery<DetallesCompras> c=cb.createQuery(DetallesCompras.class);
            Root<DetallesCompras> q=c.from(DetallesCompras.class);
            //Condicion equal
            Predicate igualA=cb.equal(q.get("videojuego"),videojuego);
            c.where(igualA);
            //Convertir a TypedQuery para conseguir un resultlist
            TypedQuery<DetallesCompras> query=em.createQuery(c);
            
            return query.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(DetallesComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudieron recuperar los detalles");
        }
    }

    @Override
    public List<DetallesCompras> consultarTodos() throws PersistenciaException {
        try{
            EntityManager em =this.conexionBD.crearConexion();  

            String jpql = "SELECT r FROM detallescompras r";
            TypedQuery<DetallesCompras> query = em.createQuery(jpql,DetallesCompras.class);
            return query.getResultList();
        }
        catch(Exception ex){
             Logger.getLogger(DetallesComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudieron recuperar los detalles");
        }
    }

    @Override
    public DetallesCompras consultar(Long id) throws PersistenciaException {
        try{
            EntityManager em =this.conexionBD.crearConexion();  
            return em.find(DetallesCompras.class, id);
        }
        catch(Exception ex){
             Logger.getLogger(DetallesComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudo encontrar el detallesCompras.");
        }
    }
    
}
