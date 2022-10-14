package com.example.demo.Controlador;

import com.example.demo.Modelo.Cinema;
import com.example.demo.Servicio.CinemaService;
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
@RequestMapping("/api/Cinema")


public class CinemaController {
    
    @Autowired
    private CinemaService cinemaService;
    // el get maping poder leere dentro de la tabla
    @GetMapping("/all")
    // para leer toda la tabla
    public List<Cinema> getAll(){
        return cinemaService.getAll();
    }
    
    // para leer el id
    @GetMapping("/{id}")
    //para guardar variable
    public Optional <Cinema> getCategory (@PathVariable("id")int id){
        return cinemaService.getCinema(id);
    }
    
    // para poder crear
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(@RequestBody  Cinema cinema){
        return cinemaService.save(cinema);
    
    }
}
