/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Compra;
import entidades.DetallesCompras;
import entidades.Videojuego;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Hugo Rivera
 */
public interface IDetallesComprasDAO {
    public void agregar(DetallesCompras detalles)throws PersistenciaException;
    public DetallesCompras consultar(Long id)throws PersistenciaException;
    public List<DetallesCompras>consultar(Compra compra) throws PersistenciaException;
    public List<DetallesCompras>consultar(Videojuego videojuego)throws PersistenciaException;
    public List<DetallesCompras>consultarTodos()throws PersistenciaException;
}
