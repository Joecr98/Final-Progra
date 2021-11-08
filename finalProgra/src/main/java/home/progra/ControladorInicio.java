/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.progra;

import home.progra.servicio.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Joe
 */
@Controller
public class ControladorInicio {

    @Autowired
    private DeptoService deptoService;

    @Autowired
    private ProfeService profeService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String inicio(Model model) {
//        var departamentos = deptoService.listaDeptos();
//        var profesions = profeService.listaProfes();
////        var users = userService.listaUsers();
////
////        model.addAttribute("users", users);
//
//        System.out.println(departamentos);
//        model.addAttribute("selectdepa", "Seleccione un departamento");
//        model.addAttribute("departamentos", departamentos);
//
//        System.out.println(profesions);
//        model.addAttribute("selectprof", "Seleccione una profesion");
//        model.addAttribute("profesions", profesions);
        return "index";
    }

    @GetMapping("/crudDepa")
    public String crudDepa(Model model) {
        var departa = deptoService.listaDeptos();
        model.addAttribute("departamentos", departa);
        return "crudDepa";
    }

    @GetMapping("/crudProf")
    public String crudProf(Model model) {
        var prof = profeService.listaProfes();
        model.addAttribute("profesions", prof);
        return "crudProf";
    }

    @GetMapping("/misUsers")
    public String misUsers(Model model) {
        var users = userService.listaUsers();
        model.addAttribute("users", users);
        return "misUsers";
    }

// ---------------------------------- para DEPARTAMENTOS
    @GetMapping("/agregar")
    public String agregarD(Departamento departamento) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardarD(Departamento departamento) {
        deptoService.guardar(departamento);
        return "redirect:/crudDepa";
    }

    @GetMapping("/editar/{ID_DEPTO}")
    public String editarD(Departamento departamento, Model model) {
        departamento = deptoService.encontrarDepto(departamento);
        model.addAttribute("tb_departamento", departamento);
        return "modificar";
    }

    @GetMapping("/eliminar/{ID_DEPTO}")
    public String eliminarD(Departamento depto) {
        deptoService.eliminar(depto);
        return "redirect:/crudDepa";
    }

    // ---------------------------------- para PROFESIONES
    @GetMapping("/agregarP")
    public String agregarP(Profesion profesion) {
        return "modificarP";
    }

    @PostMapping("/guardarP")
    public String guardarP(Profesion profesion) {
        profeService.guardar(profesion);
        return "redirect:/crudProf";
    }

    @GetMapping("/editarP/{ID_PROFESION}")
    public String editarP(Profesion profesion, Model model) {
        profesion = profeService.encontrarProf(profesion);
        model.addAttribute("tb_departamento", profesion);
        return "modificarP";
    }

    @GetMapping("/eliminarP/{ID_PROFESION}")
    public String eliminarP(Profesion profe) {
        profeService.eliminar(profe);
        return "redirect:/crudProf";
    }

    // ---------------------------------- para USUARIOS
    @GetMapping("/agregarUser")
    public String agregarUser(Usuario usuario, Model model) { 
        var departamentos = deptoService.listaDeptos();
        var profesions = profeService.listaProfes();

        System.out.println(departamentos);
        model.addAttribute("selectdepa", "Seleccione un departamento");
        model.addAttribute("departamentos", departamentos);

        System.out.println(profesions);
        model.addAttribute("selectprof", "Seleccione una profesion");
        model.addAttribute("profesions", profesions);
        model.addAttribute("usuario", usuario);
        
        return "editarUser";
    }

    @PostMapping("/guardarUser")
    public String guardarUser(Usuario usuario, Model model)    {        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        usuario.setFECHA_REGISTRO(dtf.format(now).toString());
        System.out.println(usuario.toString());
        userService.guardar(usuario);
        var users = userService.listaUsers();   
        model.addAttribute("users", users);        
        return "misUsers";
    }

    @GetMapping("/editarUser/{ID_USUARIO}")
    public String editarUser(Usuario ID_USUARIO, Model model) {
        System.out.println(ID_USUARIO.toString());
        var departamentos = deptoService.listaDeptos();
        var profesions = profeService.listaProfes();

        System.out.println(departamentos);
        model.addAttribute("selectdepa", "Seleccione un departamento");
        model.addAttribute("departamentos", departamentos);

        System.out.println(profesions);
        model.addAttribute("selectprof", "Seleccione una profesion");
        model.addAttribute("profesions", profesions);
        
        var user = userService.encontrarUser(ID_USUARIO);
        model.addAttribute("usuario", user);
        return "editarUser";
    }

    @GetMapping("/eliminarUser/{ID_USUARIO}")
    public String eliminarUser(Usuario user) {
        userService.eliminar(user);
        return "redirect:/misUsers";
    }
}
