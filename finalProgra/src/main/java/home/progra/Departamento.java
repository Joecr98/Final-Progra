/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.progra;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Joe
 */

@Data
@Entity
@Table(name="tb_departamento")
public class Departamento implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_DEPTO;   
    
    private String DESCRIPCION_DEPTO;    
}
