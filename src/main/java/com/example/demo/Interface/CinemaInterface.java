package com.example.demo.Interface;

import com.example.demo.Modelo.Cinema;
import org.springframework.data.repository.CrudRepository;


public interface CinemaInterface extends CrudRepository <Cinema, Integer> {
    
}
