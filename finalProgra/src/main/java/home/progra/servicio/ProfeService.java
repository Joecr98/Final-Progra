/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.progra.servicio;

import home.progra.Profesion;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface ProfeService {

    public List<Profesion> listaProfes();

    public void guardar(Profesion prof);

    public void eliminar(Profesion prof);

    public Profesion encontrarProf(Profesion prof);

}
