/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.progra;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author Joe
 */
@Data
@Entity
@Table(name = "tb_usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_USUARIO;

    private int ID_DEPTO;
    private int ID_PROFESION;
    private String NOMBRE;
    private String APELLIDO;
    private String CORREO_ELECTRONICO;
    private String TELEFONO;
    private String FECHA_NACIMIENTO;
    private String LATITUD;
    private String LONGITUD;
    private String FECHA_REGISTRO; 
    
}
