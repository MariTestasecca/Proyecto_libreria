
package com.libreria.proyectoone.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Autor implements Serializable {
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//si es un numero y no aclaro nada, es autoincremental
    private Long id;
    
    private String nombre;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date alta; 
    
   
    @OneToOne
    private Libro libro; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + ", libro=" + libro + '}';
    }

   

  

    

   
  
    
}
