/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.progra.servicio;

import home.progra.dao.IdeptosDao;
import home.progra.Departamento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Joe
 */
@Service
public class DeptoServiceImpl implements DeptoService {

    @Autowired
    private IdeptosDao IdeptosDao;
    
    
    @Override
    @Transactional(readOnly=true)
    public List<Departamento> listaDeptos() {
        return (List<Departamento>) IdeptosDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Departamento depto) {
        IdeptosDao.save(depto);
    }

    @Override
    @Transactional
    public void eliminar(Departamento depto) {
        IdeptosDao.delete(depto);
    }

    @Override
    @Transactional(readOnly=true)
    public Departamento encontrarDepto(Departamento depto) {
        
        return IdeptosDao.findById(depto.getID_DEPTO()).orElse(null);
    }
}
