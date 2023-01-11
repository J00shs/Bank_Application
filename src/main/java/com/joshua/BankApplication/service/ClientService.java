package com.joshua.BankApplication.service;

import com.joshua.BankApplication.dao.ClientDao;
import com.joshua.BankApplication.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientDao clientDao;
@Autowired
    public ClientService(@Qualifier("someClient") ClientDao clientDao) {
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
}
