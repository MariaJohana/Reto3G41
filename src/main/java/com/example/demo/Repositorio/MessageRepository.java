package com.example.demo.Repositorio;

import com.example.demo.Interface.MessageInterface;
import com.example.demo.Modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
    @Autowired
    private MessageInterface extensionesCrud;
    //Se crea la tabla Category para poderla leer toda la tabla
    public List<Message> getAll (){
        //se devuelve la lista para leer toda la tabla usando findAll
        return (List<Message>) extensionesCrud.findAll();
    }
    // se le pasa el atributo id para leer por id
    public Optional <Message> getMessage(int id){
        return extensionesCrud.findById(id);
    }
    
    public Message save (Message message){
        return extensionesCrud.save(message);
    }
    
     public void delete (Message message){
         extensionesCrud.delete(message);
    }
}
