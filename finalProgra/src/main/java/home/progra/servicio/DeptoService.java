/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.progra.servicio;

import home.progra.Departamento;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface DeptoService {
    public List<Departamento> listaDeptos();
    public void guardar(Departamento depto);
    public void eliminar(Departamento depto);
    public Departamento encontrarDepto(Departamento depto);
}
