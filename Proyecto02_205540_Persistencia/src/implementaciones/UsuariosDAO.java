/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Compra;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.security.Principal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Hugo Rivera
 */
public class UsuariosDAO implements IUsuariosDAO{
    IConexionBD conexionBD;

    public UsuariosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public int agregar(Usuario usuario) throws PersistenciaException {
         EntityManager em;
        try {
            
            em=conexionBD.crearConexion();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            return -1;
            
        } catch (Exception ex) {
            throw new PersistenciaException("El usuario no fue agregado");
        }
    }

    @Override
    public Usuario consultar(Long id) throws PersistenciaException {
        EntityManager em;
        try {
            em=conexionBD.crearConexion();
            Usuario usuario=em.find(Usuario.class, id);
            return usuario;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(UsuariosDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            throw new PersistenciaException("El usuario no pudo ser consultado");
        }
            
    }

    @Override
    public void actualizar(Usuario usuario) throws PersistenciaException {
        try {
            EntityManager em;
            em=conexionBD.crearConexion();
            Usuario usuarioGuardado=em.find(Usuario.class, usuario.getId());
            if(usuarioGuardado==null){
                throw new PersistenciaException("No se encontro el usuario a actualizar");
            }
            usuarioGuardado.setNombre(usuario.getNombre());
            usuarioGuardado.setTelefono(usuario.getTelefono());
            if(usuario.getCompras()!=null){
                for (Compra compra: usuario.getCompras()) {
                    usuarioGuardado.addCompra(compra);
                }
            }
            
            em.getTransaction().begin();
            em.merge(usuarioGuardado);
            em.getTransaction().commit();
        }catch(PersistenciaException ex){
            throw ex;
        }catch (Exception ex) {
            java.util.logging.Logger.getLogger(UsuariosDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            throw new PersistenciaException("El usuario no pudo ser actualizado");
        }
        }
    
    
    @Override
    public void eliminar(Long id) throws PersistenciaException {
       EntityManager em;
        try { 
//            em=conexionBD.crearConexion();
//            em.getTransaction().begin();
//            CriteriaBuilder cb=em.getCriteriaBuilder();
//            //Crear delete
//            CriteriaDelete<Usuario> delete=cb.createCriteriaDelete(Usuario.class);
//            //root class
//            Root e=delete.from(Usuario.class);
//            //condiciones
//            delete.where(cb.equal(e.get("id"), id));
//            if(em.createQuery(delete).executeUpdate()<=0){
//                throw new Exception();
//            } 
//            em.getTransaction().commit();
            em=conexionBD.crearConexion();
            em.getTransaction().begin();
            Usuario desFind=em.find(Usuario.class, id);
            em.remove(desFind);
            em.getTransaction().commit();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(UsuariosDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            throw new PersistenciaException("El usaurio no fue eliminado");
        }
            
    }

    @Override
    public List<Usuario> consultarTodos() throws PersistenciaException {
       EntityManager em;
        try {
            em=conexionBD.crearConexion();
            CriteriaBuilder builder=em.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria=builder.createQuery(Usuario.class);
            TypedQuery<Usuario> query=em.createQuery(criteria);
            return query.getResultList();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(UsuariosDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            throw new PersistenciaException("No se lograron consultar los usuarios");
        }
    }
    
}
