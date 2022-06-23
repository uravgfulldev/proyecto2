/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import PersistenciaException.PersistenciaException;
import entidades.Compra;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import interfaces.IComprasDAO;
import interfaces.IConexionBD;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author focod
 */
public class ComprasDAO implements IComprasDAO{

    private final IConexionBD conexionBD;

    public ComprasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public void agregar(Compra compra) throws PersistenciaException {
        try {
            EntityManager entityManager = this.conexionBD.crearConexion();
            entityManager.getTransaction().begin();
            entityManager.persist(compra);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No fue posible agregar la compra");
        }
    }

    @Override
    public Compra consultarPorId(Long id) throws PersistenciaException {
        try {
            EntityManager entityManager = this.conexionBD.crearConexion();
            Compra compra = entityManager.find(Compra.class, id);
            return compra;
        } catch (Exception ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudo consultar la compra");
        }
    }

    @Override
    public List<Compra> consultarTodos(Compra compra) throws PersistenciaException {
        try {
            EntityManager entityManager = this.conexionBD.crearConexion();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Compra> compraQuery = criteriaBuilder.createQuery(Compra.class);
            Root<Compra> compraRoot = compraQuery.from(Compra.class);
            Predicate igualA = criteriaBuilder.equal(compraRoot.get("compra"), compra);
            compraQuery.where(igualA);
            TypedQuery<Compra> compraTyped = entityManager.createQuery(compraQuery);
            return compraTyped.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudo consultar la lista de compras");
        }
    }

    
}
