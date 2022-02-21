
package com.libreria.proyectoone.servicios;

import com.libreria.proyectoone.Exception.Exceptions;
import com.libreria.proyectoone.entidades.Autor;
import com.libreria.proyectoone.entidades.Libro;
import com.libreria.proyectoone.repositorios.AutorRepositorio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServicio {
    
    /*
    consulta
    creación
    modificación
    dar de baja 
    */
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    private Libro libro;

    public void registrar(String id, String nombre, Date alta, String Libro) throws Exceptions {
        validar(id, nombre, alta);

        Autor autor = new Autor();
       
        autor.setNombre(id);
        autor.setLibro(libro);
        autor.setAlta(new Date());

        autorRepositorio.save(autor);

    }
    
     public void validar(String id, String autor, Date alta) throws Exceptions {

        if (autor == null || autor.isEmpty()) {
            throw new Exceptions("El nombre del autor no es correcto, no puede ser nulo");
        }
        if (alta == null) {
            throw new Exceptions("El alta no puede ser nula, debe indicar una fecha");
        }
             
    }
//     
//      public void deshabilitar(String id) throws Exception {
//        Optional<Autor> respuesta = (Optional<Autor>) autorRepositorio.findById(id);
//        if (respuesta.isPresent()) {
//            Autor autor = respuesta.get();
//
//            autor.setAlta(null);
//            autorRepositorio.save(autor);
//        } else {
//            throw new Exception("No se puede dar de baja al autor solicitado");
//        }
//        
//    }
//
//    public void habilitar(String id) throws Exception {
//        Optional<Autor> respuesta = (Optional<Autor>) autorRepositorio.findById(id);
//        if (respuesta.isPresent()) {
//            Autor autor = respuesta.get();
//
//            autor.setAlta(new Date());
//            autorRepositorio.save(autor);
//        } else {
//            throw new Exception("No se encontró el autor solicitado");
//        }
//        
//    }
   
    
    /*
    Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para administrar autores (consulta, creación, modificación y dar de baja).
    */
}
