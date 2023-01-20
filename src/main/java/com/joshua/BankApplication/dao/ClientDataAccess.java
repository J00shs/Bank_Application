package com.joshua.BankApplication.dao;

import com.joshua.BankApplication.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("postgres")
public class ClientDataAccess implements ClientDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertClient(UUID id, Client client) {
        return 0;
    }

    @Override
    public List<Client> selectAllClient() {
        final String sql = "SELECT id, name FROM client";
        return jdbcTemplate.query(sql, (resultset, i)->{
             UUID id = UUID.fromString( resultset.getString("id"));
             String name = resultset.getString("name");
             return new Client(id, name);
         } );
    }

    @Override
    public Optional<Client> selectClientByID(UUID id) {
        final String sql = "SELECT id, name FROM client WHERE id = ?";
        Client client = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultset, i)->{
            UUID clientID = UUID.fromString( resultset.getString("id"));
            String name = resultset.getString("name");
            return new Client(clientID, name);
        } );
        return Optional.ofNullable(client);
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
