
package com.example.demo.Controlador;

import com.example.demo.Modelo.Reservation;
import com.example.demo.Servicio.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
     @Autowired
    private ReservationService reservationService;
    // el get maping poder leere dentro de la tabla
    @GetMapping("/all")
    // para leer toda la tabla
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    
    // para leer el id
    @GetMapping("/{id}")
    //para guardar variable
    public Optional <Reservation> getCategory (@PathVariable("id")int id){
        return reservationService.getReservation(id);
    }
    
    // para poder crear
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody  Reservation reservation){
        return reservationService.save(reservation);
    
    }
}
