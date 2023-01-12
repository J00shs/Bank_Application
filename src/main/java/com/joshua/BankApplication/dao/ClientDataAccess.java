package com.joshua.BankApplication.dao;

import com.joshua.BankApplication.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("postgres")
public class ClientDataAccess implements ClientDao{
    @Override
    public int insertClient(UUID id, Client client) {
        return 0;
    }

    @Override
    public List<Client> selectAllClient() {
        return List.of(new Client(UUID.randomUUID(), "FROM POSTGRES DB"));
    }

    @Override
    public Optional<Client> selectClientByID(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteClientById(UUID id) {
        return 0;
    }

    @Override
    public int updateClientByID(UUID id, Client client) {
        return 0;
    }
}
