
package com.example.demo.Servicio;

import com.example.demo.Modelo.Client;
import com.example.demo.Repositorio.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
     private ClientRepository clientRepository;
    
    // para poder leer
    public List <Client> getAll(){
       return clientRepository.getAll();
    }
    //para buscar por id
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    
    // metodo para poder guardar
    public Client save (Client client){
        // si el id no existe se ejecuta 
        if (client.getIdClient() == null){
            return clientRepository.save(client);
        } else {
            // si el id esta no lo debe crear
            Optional <Client> client1 = clientRepository.getClient(client.getIdClient());
            if(client1.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
   
}
