
package com.libreria.proyectoone.repositorios;

import com.libreria.proyectoone.entidades.Autor;
import java.util.List;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

  
@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Id> {
    
//    @Query("SELECT c FROM Autor WHERE c.autor.Id= :Id")
//        public List<Autor>buscarAutorPorId(@Param("id")Long Id); 
//    
//    @Query("SELECT c FROM Autor WHERE c.autor.titulo= :titulo")
//        public List<Autor>buscarAutorPorTitulo(@Param("titulo")String titulo); 

//        public Object findById(String id);
    
   
   
}
