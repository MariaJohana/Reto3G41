
package com.example.demo.Servicio;

import com.example.demo.Modelo.Reservation;
import com.example.demo.Repositorio.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
     private ReservationRepository reservationRepository;
    
    // para poder leer
    public List <Reservation> getAll(){
       return reservationRepository.getAll();
    }
    //para buscar por id
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    // metodo para poder guardar
    public Reservation save (Reservation reservation){
        // si el id no existe se ejecuta 
        if (reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        } else {
            // si el id esta no lo debe crear
            Optional <Reservation> reservation1 = reservationRepository.getReservation(reservation.getIdReservation());
            if(reservation1.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    
}
