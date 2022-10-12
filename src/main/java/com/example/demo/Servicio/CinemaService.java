
package com.example.demo.Servicio;

import com.example.demo.Modelo.Cinema;
import com.example.demo.Repositorio.CinemaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    @Autowired
     private CinemaRepository cinemaRepository;
    
    // para poder leer
    public List <Cinema> getAll(){
       return cinemaRepository.getAll();
    }
    //para buscar por id
    public Optional<Cinema> getCinema(int id){
        return cinemaRepository.getCinema(id);
    }
    // metodo para poder guardar
    public Cinema save (Cinema cinema){
        // si el id no existe se ejecuta 
        if(cinema.getId()==null){
           return cinemaRepository.save(cinema);
        } else {
            // si el id esta no lo debe crear
            Optional <Cinema> cinema1 = cinemaRepository.getCinema(cinema.getId());
            if(cinema1.isEmpty()){
                return cinemaRepository.save(cinema);
            }else{
                return cinema;
            }
        }
    }
    
     // metodo para actualizar
    public Cinema update(Cinema p){
        if(p.getId()!=null){
            Optional<Cinema> q = cinemaRepository.getCinema(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                cinemaRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    
    // metodo para borrar
    public boolean delete(int id){
        boolean flag=false;
        Optional<Cinema>p= cinemaRepository.getCinema(id);
        if(p.isPresent()){
           cinemaRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }
}


