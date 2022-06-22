/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import javax.persistence.EntityManager;

/**
 *
 * @author Hugo Rivera
 */
public interface IConexionBD {
    public EntityManager crearConexion() throws Exception; 
}
