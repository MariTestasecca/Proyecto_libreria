
package com.libreria.proyectoone.servicios;

import com.libreria.proyectoone.Exception.Exceptions;
import com.libreria.proyectoone.entidades.Autor;
import com.libreria.proyectoone.entidades.Editorial;
import com.libreria.proyectoone.entidades.Libro;
import com.libreria.proyectoone.repositorios.LibroRepositorio;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio {
    
    @Autowired
    private LibroRepositorio libroRepositorio;
    /*
     private long isbn;
    private String titulo; 
    private Integer anio;
    private Integer ejemplares; 
    private Integer ejemplaresPrestados; 
    private Integer ejemplaresRestantes; 
    private boolean alta;
    */
    private Autor autor;
    private Editorial editorial;
    
    @Transactional
    public void agregarLibro(Long id, Long isbn, String titulo,Integer anio,Integer ejemplares,Date alta) throws Exceptions{
        validar(titulo, 0, ejemplares, autor, editorial);

        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAnio(anio); 
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setAlta(alta);
        libro.setEjemplares(ejemplares); 

        libro.setAlta(new Date());

        libroRepositorio.save(libro);

    }
     
    public void validar(String titulo, int isbn, Integer ejemplares, Autor autor, Editorial editorial) throws Exceptions {

        if (titulo == null || titulo.isEmpty()) {
            throw new Exceptions("El título del libro está vacío");
        }
        if (isbn >10) {
            throw new Exceptions("El isbn debe contener 10 dígitos");
        }
        if (ejemplares == null) {
            throw new Exceptions("Debe agregar al menos un ejemplar");
        }
        if (autor == null) {
            throw new Exceptions("Debe agregar el autor");
        }
        if (editorial == null) {
            throw new Exceptions("Debe agregar la editorial");
        }
        
    }
    
    public void modificar(Long id, Long isbn, String titulo,Integer anio,Integer ejemplares,Date alta) throws Exceptions, Exception{
        validar(titulo, 0, ejemplares, autor, editorial);

        Libro respuesta = libroRepositorio.findById(id).get();
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            libro.setAnio(anio);
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            libroRepositorio.save(libro);
        } else {
            throw new Exception("Ocurrió un error y no se pudo modificar los datos del libro solicitado");
        }
    }

    public void deshabilitar(String idLibro) throws Exception {
        Libro respuesta = libroRepositorio.findById(idLibro).get();
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();

            libro.setAlta(null);
            libroRepositorio.save(libro);
        } else {
            throw new Exception("No se deshabilitó el libro solicitado");
        }
        
    }

    public void habilitar(String idLibro) throws Exception {
        Libro respuesta = libroRepositorio.findById(idLibro).get();
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();

            libro.setAlta(new Date());
            libroRepositorio.save(libro);
        } else {
            throw new Exception("No se pudo dar el alta libro solicitado");
        }

    }
   
    public void consultar(String idLibro)throws Exception {
       
        Libro respuesta = libroRepositorio.findById(idLibro).get();
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            
            System.out.println(libro);
        } else {
            throw new Exception("El libro no se encuentra en la lista");
        }
   }

    
    
    //------------------------------------------------------------------------------------------------------
//     
//    @Transactional
//    public void prestarLibro(String titulo, Integer ejemplares,Date alta){
//        
//        Libro respuesta = libroRepositorio.find.get();
//        if (respuesta.isPresent()) {
//    }
    
   
    
    
//    @Transactional
//    public void buscarLibro(Long id, Long isbn, String titulo,Integer anio,Integer ejemplares,boolean alta){
//    
//    }

//    @Transactional 
//    public void buscarLibroPorTitulo();
//    
//    @Transactional 
//    public void buscarLibroPorEjemplares();
//    
//      listarTodos(); como otro método importante
//  
    
    
}
