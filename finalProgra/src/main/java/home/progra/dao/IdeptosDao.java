/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.progra.dao;

import home.progra.Departamento;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Joe
 */
public interface IdeptosDao extends CrudRepository<Departamento,Long> {
    
}
