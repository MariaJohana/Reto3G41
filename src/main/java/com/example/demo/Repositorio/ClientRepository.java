
package com.example.demo.Repositorio;

import com.example.demo.Interface.ClientInterface;
import com.example.demo.Modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    @Autowired
    private ClientInterface extensionesCrud;
    //Se crea la tabla Category para poderla leer toda la tabla
    public List<Client> getAll (){
        //se devuelve la lista para leer toda la tabla usando findAll
        return (List<Client>) extensionesCrud.findAll();
    }
    // se le pasa el atributo id para leer por id
    public Optional <Client> getClient(int id){
        return extensionesCrud.findById(id);
    }
    
    public Client save (Client client){
        return extensionesCrud.save(client);
    }
    
     public void delete (Client client){
         extensionesCrud.delete(client);
    }
}
