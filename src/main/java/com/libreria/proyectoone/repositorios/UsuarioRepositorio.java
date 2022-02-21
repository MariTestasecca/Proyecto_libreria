package com.libreria.proyectoone.repositorios;

import com.libreria.proyectoone.entidades.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

 @Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    
    public void registrar(Usuario usuario);
    public void validar(Usuario usuario);
    public void deshabilitar(Usuario usuario);
    public void habilitar(Usuario usuario);
    public void modificar(Usuario usuario);
    
    public Optional<Usuario> findById(String id);
   
    @Query("SELECT c FROM Usuario WHERE c.usuario.id= :id")
    public List<Usuario>buscarUsuario(@Param("id")Long id); 
  
    
}
