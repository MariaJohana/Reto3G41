package com.example.demo.Controlador;

import com.example.demo.Modelo.Client;
import com.example.demo.Servicio.ClientService;
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
@RequestMapping("/api/Client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    // el get maping poder leere dentro de la tabla
    @GetMapping("/all")
    // para leer toda la tabla
    public List<Client> getAll(){
        return clientService.getAll();
    }
    
    // para leer el id
    @GetMapping("/{id}")
    //para guardar variable
    public Optional <Client> getCategory (@PathVariable("id")int id){
        return clientService.getClient(id);
    }
    
    // para poder crear
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody  Client client){
        return clientService.save(client);
    
    }
}
