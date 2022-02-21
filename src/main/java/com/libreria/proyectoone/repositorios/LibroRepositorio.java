
package com.libreria.proyectoone.repositorios;

import com.libreria.proyectoone.entidades.Libro;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    
    @Query("SELECT c FROM Libro WHERE c.libro.id= :id")
    public List<Libro>buscarLibroPorId(@Param("id")Long id); 
    
    @Query("SELECT c FROM Libro WHERE c.libro.titulo= :titulo")
    public List<Libro>buscarLibroPorTitulo(@Param("titulo")String titulo); 
    
    @Query("SELECT c FROM Libro WHERE c.libro.ejemplares= :ejemplares")
    public List<Libro>buscarLibroPorEjemplares(@Param("ejemplares")Integer ejemplares);
   
    @Query("SELECT c FROM Libro WHERE c.libro.autor= :autor")
    public List<Libro>buscarLibroPorAutor(@Param("autor")String autor);
    
    @Query("SELECT c FROM Libro WHERE c.libro.editorial= :editorial")
    public List<Libro>buscarLibroPorEditorial(@Param("editorial")String editorial);

    public Optional<Libro> findById(String idLibro);
   
}
