package com.libreria.proyectoone.servicios;

import com.libreria.proyectoone.Exception.Exceptions;
import com.libreria.proyectoone.entidades.Editorial;
import com.libreria.proyectoone.entidades.Libro;
import com.libreria.proyectoone.repositorios.EditorialRepositorio;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicio {

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    /*
    consulta
    creación
    modificación
    dar de baja 
    */
    public void registrar(String autor, Date alta, Libro libro) throws Exceptions {
        validar(autor, alta, libro);

        Editorial editorial = new Editorial();
        editorial.setAutor(autor);
        editorial.setAlta(new Date());
        editorial.setLibro(libro);

        editorialRepositorio.save(editorial);

    }

    public void modificar(Long id, String nombre, String apellido, String mail, String clave) throws Exceptions, Exception {

        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            editorial.setAutor();
            editorial.setAlta(new Date());
            editorial.setLibro();

            editorialRepositorio.save(editorial);
        } else {
            throw new Exception("No se pudo modificar la editorial ");
        }
    }

    public void deshabilitar(String idEditorial) throws Exception {
        Optional<Editorial> respuesta = editorialRepositorio.findById(idEditorial);
        if (respuesta.isPresent()) {
           Editorial editorial = respuesta.get();

            editorial.setAlta(null);
            editorialRepositorio.save(editorial);
        } else {
            throw new Exception("No se pudo deshabilitar la editorial seleccionada");
        }

    }

    public void habilitar(String idEditorial) throws Exception {
        Optional<Editorial> respuesta = editorialRepositorio.findById(idEditorial);
        if (respuesta.isPresent()) {
           Editorial editorial = respuesta.get();

            editorial.setAlta(new Date());
            editorialRepositorio.save(editorial);
        } else {
            throw new Exception("No se pudo habilitar la editorial seleccionada");
        }

    }

    public void validar(String autor, Date alta, Libro libro) throws Exceptions {

        if (autor == null || autor.isEmpty()) {
            throw new Exceptions("El autor no es correcto, no puede ser nulo");
        }
        if (alta == null) {
            throw new Exceptions("Debe indicar una fecha para dar de alta la Editorial");
        }

    }

}
