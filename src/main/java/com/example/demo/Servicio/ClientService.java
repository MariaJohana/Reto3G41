
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
    // metodo para actualizar
    public Client update(Client p){
        if(p.getIdClient()!=null){
            Optional<Client> q = clientRepository.getClient(p.getIdClient());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                clientRepository.save(q.get());
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
        Optional<Client>p= clientRepository.getClient(id);
        if(p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }
}
