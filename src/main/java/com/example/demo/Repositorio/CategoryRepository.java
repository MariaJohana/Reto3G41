package com.example.demo.Repositorio;

import com.example.demo.Interface.CategoryInterface;
import com.example.demo.Modelo.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class CategoryRepository {
    @Autowired
    private CategoryInterface extensionesCrud;
    //Se crea la tabla Category para poderla leer toda la tabla
    public List<Category> getAll (){
        //se devuelve la lista para leer toda la tabla usando findAll
        return (List<Category>) extensionesCrud.findAll();
    }
    // se le pasa el atributo id para leer por id
    public Optional <Category> getCategory(int id){
        return extensionesCrud.findById(id);
    }
    
    public Category save (Category category){
        return extensionesCrud.save(category);
    }
    
     public void delete (Category category){
         extensionesCrud.delete(category);
    }
}
