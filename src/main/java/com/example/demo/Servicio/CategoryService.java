package com.example.demo.Servicio;

import com.example.demo.Modelo.Category;
import com.example.demo.Repositorio.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
     private CategoryRepository categoryRepository;
    
    // para poder leer
    public List <Category> getAll(){
       return categoryRepository.getAll();
    }
    //para buscar por id
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    // metodo para poder guardar
    public Category save (Category category){
        // si el id no existe se ejecuta 
        if (category.getId() == null){
            return categoryRepository.save(category);
        } else {
            // si el id esta no lo debe crear
            Optional <Category> category1 = categoryRepository.getCategory(category.getId());
            if(category1.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
    
}
