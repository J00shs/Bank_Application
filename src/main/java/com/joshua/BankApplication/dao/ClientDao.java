package com.joshua.BankApplication.dao;

import com.joshua.BankApplication.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDao {
    //A method to insert the client into the list. ID and Name must be provided
    int insertClient(UUID id, Client client);

    //A method to insert a client into the list database. Generates a random ID
    default int insertClient(Client client){
        UUID id = UUID.randomUUID();
        return insertClient(id, client);
    }

    List<Client> selectAllClient();

    Optional<Client> selectClientByID(UUID id);
    int deleteClientById(UUID id);

    int updateClientByID(UUID id, Client client);
}
