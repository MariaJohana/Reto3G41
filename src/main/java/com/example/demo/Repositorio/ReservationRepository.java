package com.example.demo.Repositorio;

import com.example.demo.Interface.ReservationInterface;
import com.example.demo.Modelo.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationInterface extensionesCrud;
    //Se crea la tabla Category para poderla leer toda la tabla
    public List<Reservation> getAll (){
        //se devuelve la lista para leer toda la tabla usando findAll
        return (List<Reservation>) extensionesCrud.findAll();
    }
    // se le pasa el atributo id para leer por id
    public Optional <Reservation> getReservation(int id){
        return extensionesCrud.findById(id);
    }
    
    public Reservation save (Reservation reservation){
        return extensionesCrud.save(reservation);
    }
    
     public void delete (Reservation reservation){
         extensionesCrud.delete(reservation);
    }
    
}
