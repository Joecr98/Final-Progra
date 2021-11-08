/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.progra.servicio;

import home.progra.Usuario;
import home.progra.dao.IuserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Joe
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IuserDao IuserDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listaUsers() {
        return (List<Usuario>) IuserDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario us) {
        IuserDao.save(us);
    }

    @Override
    @Transactional
    public void eliminar(Usuario us) {
        IuserDao.delete(us);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario encontrarUser(Usuario us) {

        return IuserDao.findById(us.getID_USUARIO()).orElse(null);
    }
}
