package com.joshua.BankApplication.dao;

import com.joshua.BankApplication.model.Client;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


/*
This class is used in conjunction with Postman and does not reflect the
use of an actual database such as POSTGRE or MONGODB
 */
//@Repo allows this class to become a repository for Spring to work
@Repository("someClient")
public class ClientDataAccessService implements ClientDao{
    //A list that will contain all the clients
    private static List<Client> DB = new ArrayList<>();

    //Method to add a new client to the list
    @Override
    public int insertClient(UUID id, Client client) {
        DB.add(new Client(id, client.getName()));
        return 1;
    }

    //Method to return the list
    @Override
    public List<Client> selectAllClient() {
        return DB;
    }

    //Method that searches within the database to see if there is a client with the given ID
    @Override
    public Optional<Client> selectClientByID(UUID id) {
        return DB.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteClientById(UUID id) {
       Optional<Client>clientMaybe= selectClientByID(id);
       if(clientMaybe.isEmpty()){
           return 0;
       }
       DB.remove(clientMaybe.get());
        return 1;
    }

    @Override
    public int updateClientByID(UUID id, Client update) {
        return selectClientByID(id)
                .map(client -> {
                    int indexOfClientToUpdate = DB.indexOf(client);
                    if (indexOfClientToUpdate >= 0) {
                        DB.set(indexOfClientToUpdate, new Client(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}

