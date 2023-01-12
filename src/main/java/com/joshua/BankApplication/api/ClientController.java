package com.joshua.BankApplication.api;

import com.joshua.BankApplication.model.Client;
import com.joshua.BankApplication.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


/*
    A class that is responsible for handling user input and returning information
 */

//Mapping for PostMan
@RequestMapping("api/v3/client")

@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }
    //Method that will actaually add the person to the database from Postman or other service
    //Uses the "addClient" method from the ClientService class
   @PostMapping
    public void addClient(@Validated @NonNull @RequestBody Client client){
        clientService.addClient(client);

    }

    @GetMapping
    public List<Client> getAllClient(){
        return  clientService.getAllClient();
    }

    //Returns a single client based on ID
    @GetMapping(path = "{id}")
    public Client getClientbyID(@PathVariable("id") UUID id){
        return clientService.getClientById(id)
                .orElse(null);
    }

    @DeleteMapping(path ="{deleteId}")
    public void deleteClientById(@PathVariable("deleteId") UUID id){
        clientService.deleteClient(id);

    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody Client clientToUpdate){
        clientService.updateClient(id, clientToUpdate);
    }
}
