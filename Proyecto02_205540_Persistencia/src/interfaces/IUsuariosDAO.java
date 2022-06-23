/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Usuario;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Hugo Rivera
 */
public interface IUsuariosDAO {
    public int agregar(Usuario usuario)throws PersistenciaException;
    public Usuario consultar(Long id)throws PersistenciaException;
    public List<Usuario> consultarTodos()throws PersistenciaException;
    public void actualizar(Usuario usuario)throws PersistenciaException;
    public void eliminar(Long id)throws PersistenciaException;
}
