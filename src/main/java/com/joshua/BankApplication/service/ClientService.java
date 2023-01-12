package com.joshua.BankApplication.service;

import com.joshua.BankApplication.dao.ClientDao;
import com.joshua.BankApplication.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientDao clientDao;
    //If you want to use Postman, change the inside of @Qualifier to "someClient"
@Autowired
    public ClientService(@Qualifier("postgres") ClientDao clientDao) {
        this.clientDao = clientDao;
    }
    //Method that will add a client using one of the "insertCLient" methods from the ClientDao Interface
    //The "insertClient" method inside will generate the UUID automatically rather than manually
    public int addClient(Client client){
        return clientDao.insertClient(client);
     }
public List<Client> getAllClient(){
    return clientDao.selectAllClient();
}

public Optional<Client>getClientById(UUID id){
    return clientDao.selectClientByID(id);
}

public int deleteClient(UUID id){
    return clientDao.deleteClientById(id);
}

public int updateClient(UUID id, Client newClient){
    return clientDao.updateClientByID(id, newClient);
}
}
