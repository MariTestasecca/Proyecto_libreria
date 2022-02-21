
package com.libreria.proyectoone.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Editorial implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//si es un numero y no aclaro nada, es autoincremental
    private Long id;
    
    private String autor;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date alta; 
    
   
    private Libro libro; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Editorial{" + "id=" + id + ", autor=" + autor + ", alta=" + alta + ", libro=" + libro + '}';
    }

    public void setAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setLibro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    
    
}
