package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Client;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.ClientRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService
{
    @Autowired
private final ClientRepo clientrepo;

    public ClientService(ClientRepo clientrepo) {
        this.clientrepo = clientrepo;
    }


    public Client addClient(Client client){
        return clientrepo.save(client);
    }

    public List<Client> findAllClients()
    {
        return clientrepo.findAll();
    }
    public Client updateClient(Client client)
    {
        return clientrepo.save(client);
    }
    public Client findClientById(Long id)
    {
        return (Client) clientrepo.findClientById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteClient(Long id)
    {
        clientrepo.deleteClientById(id);
    }

}
