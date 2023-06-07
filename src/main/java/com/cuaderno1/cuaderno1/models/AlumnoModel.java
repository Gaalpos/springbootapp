package com.cuaderno1.cuaderno1.models;
import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="alumno")
public class AlumnoModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true, nullable=false)
    private long id;

    @Column(length = 500)
    private String name;
    private String fecha;
    // @Column(nullable = false)
    
    public AlumnoModel() {
    }
    public AlumnoModel(long id, String name, String fecha) {
        this.id = id;
        this.name = name;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
   


    //private LocalDateTime createdAt;

     
 

    // public AlumnoModel() {
       
    // }

    // public AlumnoModel(long id, String name, LocalDateTime createdAt) {
    //     this.id = id;
    //     this.name = name;
    //     this.createdAt = createdAt;
    // }

    // public long getId() {
    //     return id;
    // }

    // public void setId(long id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public LocalDateTime getCreatedAt() {
    //     return createdAt;
    // }

    // public void setCreatedAt(LocalDateTime fecha) {
    //     this.createdAt = fecha;
    // }


    
    
    
    
}
