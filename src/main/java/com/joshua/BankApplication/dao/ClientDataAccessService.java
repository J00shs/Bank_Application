package com.joshua.BankApplication.dao;

import com.joshua.BankApplication.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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


}
