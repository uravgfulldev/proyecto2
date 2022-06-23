/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import PersistenciaException.PersistenciaException;
import entidades.Compra;
import java.util.List;

/**
 *
 * @author focod
 */
public interface IComprasDAO {

    public void agregar(Compra compra) throws PersistenciaException;

    public Compra consultarPorId(Long id) throws PersistenciaException;

    public List<Compra> consultarTodos(Compra compra) throws PersistenciaException;
}
