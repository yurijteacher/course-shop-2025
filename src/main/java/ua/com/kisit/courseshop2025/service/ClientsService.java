package ua.com.kisit.courseshop2025.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.courseshop2025.entity.Clients;
import ua.com.kisit.courseshop2025.repository.ClientRepository;

@Service
public class ClientsService {

    private final ClientRepository clientRepository;


    public ClientsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveNewClients(Clients client) {
        clientRepository.save(client);
    }

    public Clients findById(Long id) {
        return clientRepository.findById(id).get();
    }

}
