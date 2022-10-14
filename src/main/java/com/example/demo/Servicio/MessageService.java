
package com.example.demo.Servicio;

import com.example.demo.Modelo.Message;
import com.example.demo.Repositorio.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MessageService {
    @Autowired
     private MessageRepository messageRepository;
    
    // para poder leer
    public List <Message> getAll(){
       return messageRepository.getAll();
    }
    //para buscar por id
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    // metodo para poder guardar
    public Message save (Message message){
        // si el id no existe se ejecuta 
        if (message.getIdMessage() == null){
            return messageRepository.save(message);
        } else {
            // si el id esta no lo debe crear
            Optional <Message> message1 = messageRepository.getMessage(message.getIdMessage());
            if(message1.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
    
    

}
