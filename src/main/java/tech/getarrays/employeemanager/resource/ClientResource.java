package tech.getarrays.employeemanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.Client;
import tech.getarrays.employeemanager.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientResource {
    private final ClientService clientservice;

    public ClientResource(ClientService clientservice) {this.clientservice = clientservice; }

    @GetMapping ("/all")
    public ResponseEntity<List<Client>>getAllClients(){
        List<Client> clients = clientservice.findAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Client>getClientById(@PathVariable("id") Long id){
        Client client = clientservice.findClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Client>  addClient(@RequestBody Client client)
    {
        Client newClient = clientservice.addClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable("id") Long id ){
        clientservice.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
      Client updateclient = clientservice.updateClient(client);
      return new ResponseEntity<>(updateclient, HttpStatus.OK);
    }
}
