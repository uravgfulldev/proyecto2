/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hugo Rivera
 */
public class ConexionBD implements IConexionBD{
    @Override
    public EntityManager crearConexion() throws Exception {
        EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("Proyecto02_205540_DominioPU");
        EntityManager em= emFactory.createEntityManager();
        return em;
    }
}
