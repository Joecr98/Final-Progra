/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.progra.servicio;

import home.progra.Usuario;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface UserService {

    public List<Usuario> listaUsers();

    public void guardar(Usuario us);

    public void eliminar(Usuario us);

    public Usuario encontrarUser(Usuario us);

}
