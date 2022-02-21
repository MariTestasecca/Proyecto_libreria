package com.libreria.proyectoone.repositorios;

import com.libreria.proyectoone.entidades.Editorial;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, Long> {

    @Query("SELECT c FROM Editorial WHERE c.editorial.id= :id")
    public List<Editorial> buscarEditorialPorId(@Param("id") Long id);

    @Query("SELECT c FROM Editorial WHERE c.editorial.autor= :autor")
    public List<Editorial> buscarEditorialPorAutor(@Param("autor") String autor);
    
    @Query("SELECT c FROM Editorial WHERE c.editorial.alta= :alta")
    public List<Editorial> buscarEditorialPorAlta(@Param("alta") String alta);

    public Optional<Editorial> findById(String id);

    @Override
    public Optional<Editorial> findById(Long idEditorial);
    
    

    }
