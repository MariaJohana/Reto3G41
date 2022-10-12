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
        if (category.getIdCategory() == null){
            return categoryRepository.save(category);
        } else {
            // si el id esta no lo debe crear
            Optional <Category> category1 = categoryRepository.getCategory(category.getIdCategory());
            if(category1.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
    
    // metodo para actualizar
    public Category update(Category p){
        if(p.getIdCategory()!=null){
            Optional<Category> q = categoryRepository.getCategory(p.getIdCategory());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                categoryRepository.save(q.get());
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
        Optional<Category>p= categoryRepository.getCategory(id);
        if(p.isPresent()){
            categoryRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }
}
