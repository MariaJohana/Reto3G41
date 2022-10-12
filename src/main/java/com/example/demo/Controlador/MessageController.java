package com.example.demo.Controlador;

import com.example.demo.Modelo.Message;
import com.example.demo.Servicio.MessageService;
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
@RequestMapping("/api/Message")
public class MessageController {
     @Autowired
    private MessageService messageService;
    // el get maping poder leere dentro de la tabla
    @GetMapping("/all")
    // para leer toda la tabla
    public List<Message> getAll(){
        return messageService.getAll();
    }
    
    // para leer el id
    @GetMapping("/{id}")
    //para guardar variable
    public Optional <Message> getCategory (@PathVariable("id")int id){
        return messageService.getMessage(id);
    }
    
    // para poder crear
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody  Message message){
        return messageService.save(message);
    
    }
}
