package com.example.demo.Controlador;

import com.example.demo.Modelo.Category;
import com.example.demo.Servicio.CategoryService;
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
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    
    private CategoryService categoryService;
    // el get maping poder leere dentro de la tabla
    @GetMapping("/all")
    // para leer toda la tabla
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    
    // para leer el id
    @GetMapping("/{id}")
    //para guardar variable
    public Optional <Category> getCategory (@PathVariable("id")int id){
        return categoryService.getCategory(id);
    }
    
    // para poder crear
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody  Category category){
        return categoryService.save(category);
    
    }
}
