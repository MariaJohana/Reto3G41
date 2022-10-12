
package com.example.demo.Repositorio;

import com.example.demo.Interface.CinemaInterface;
import com.example.demo.Modelo.Cinema;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class CinemaRepository {
     @Autowired
    private CinemaInterface extensionesCrud;
    //Se crea la tabla Category para poderla leer toda la tabla
    public List<Cinema> getAll (){
        //se devuelve la lista para leer toda la tabla usando findAll
        return (List<Cinema>) extensionesCrud.findAll();
    }
    // se le pasa el atributo id para leer por id
    public Optional <Cinema> getCinema(int id){
        return extensionesCrud.findById(id);
    }
    
    public Cinema save (Cinema cinema){
        return extensionesCrud.save(cinema);
    }
    
     public void delete (Cinema cinema){
         extensionesCrud.delete(cinema);
    }
}
