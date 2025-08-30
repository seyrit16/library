package com.example.library.service;

import com.example.library.model.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);

    Client updateClient(Long id, Client client);

    void deleteClient(Long id);

    Client getClientById(Long id);

    List<Client> getAllClients();
}
