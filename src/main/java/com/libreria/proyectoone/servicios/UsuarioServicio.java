package com.libreria.proyectoone.servicios;

import com.libreria.proyectoone.Exception.Exceptions;
import com.libreria.proyectoone.entidades.Usuario;
import com.libreria.proyectoone.repositorios.UsuarioRepositorio;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    /*
    1-usuario se registre
    2-usuario edite su cuenta
    3-deshabilitar la cuenta
    4-volver a habilitar la cuenta    
     */
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public void registrar(String nombre, String apellido, String clave, String mail) throws Exceptions {
        validar(nombre, apellido, mail, clave);

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setClave(clave);
        usuario.setMail(mail);

        usuario.setAlta(new Date());

        usuarioRepositorio.save(usuario);

    }

    public void modificar(Long id, String nombre, String apellido, String mail, String clave) throws Exceptions, Exception {
        validar(nombre, apellido, mail, clave);

        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setMail(mail);
            usuario.setClave(mail);

            usuarioRepositorio.save(usuario);
        } else {
            throw new Exception("No se encontró el usuario solicitado");
        }
    }

    public void deshabilitar(String id) throws Exception {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();

            usuario.setBaja(new Date());
            usuarioRepositorio.save(usuario);
        } else {
            throw new Exception("No se encontró el usuario solicitado");
        }
        
    }

    public void habilitar(String id) throws Exception {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();

            usuario.setBaja(null);
            usuarioRepositorio.save(usuario);
        } else {
            throw new Exception("No se dió de alta a ningún usuario");
        }

    }

    public void validar(String nombre, String apellido, String clave, String mail) throws Exceptions {

        if (nombre == null || nombre.isEmpty()) {
            throw new Exceptions("El nombre del usuario no es correcto, no puede ser nulo");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new Exceptions("El apellido del usuario no es correcto, no puede ser nulo");
        }
        if (clave == null || clave.isEmpty() || clave.length() < 6) {
            throw new Exceptions("La clave tiene que tener más de 6 dígitos y no ser nula");
        }
        if (mail == null || mail.isEmpty()) {
            throw new Exceptions("El mail no es válido");
        }
    }

}
