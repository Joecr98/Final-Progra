/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.progra.servicio;

import home.progra.Departamento;
import home.progra.Profesion;
import home.progra.dao.IdeptosDao;
import home.progra.dao.IprofDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Joe
 */
@Service
public class ProfeServiceImpl implements ProfeService {

    @Autowired
    private IprofDao IprofDao;

    @Override
    @Transactional(readOnly = true)
    public List<Profesion> listaProfes() {
        return (List<Profesion>) IprofDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Profesion prof) {
        IprofDao.save(prof);
    }

    @Override
    @Transactional
    public void eliminar(Profesion prof) {
        IprofDao.delete(prof);
    }

    @Override
    @Transactional(readOnly = true)
    public Profesion encontrarProf(Profesion prof) {

        return IprofDao.findById(prof.getID_PROFESION()).orElse(null);
    }

}
