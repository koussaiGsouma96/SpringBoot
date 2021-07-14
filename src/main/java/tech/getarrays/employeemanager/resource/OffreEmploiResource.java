package tech.getarrays.employeemanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Client;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.model.OffreEmploi;
import tech.getarrays.employeemanager.repo.ClientRepo;
import tech.getarrays.employeemanager.repo.OffreEmploiRepo;
import tech.getarrays.employeemanager.service.OffreEmploiService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/offre")
public class OffreEmploiResource {
    private final OffreEmploiRepo offreEmploiRepo;
    private final ClientRepo clientRepo ;
    private final OffreEmploiService offreEmploiService;

    public OffreEmploiResource(OffreEmploiRepo offreEmploiRepo, ClientRepo clientRepo , OffreEmploiService offreEmploiService) {
        this.offreEmploiRepo = offreEmploiRepo;
        this.clientRepo = clientRepo;
        this.offreEmploiService = offreEmploiService;
    }
/*
    @PostMapping("add")
    public ResponseEntity<OffreEmploi> create(@RequestBody @Validated OffreEmploi offreEmploi) {
        Optional<Client> optionalClient = clientRepo.findById(offreEmploi.getClient().getId());
        if (!optionalClient.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        offreEmploi.setClient(optionalClient.get());

        OffreEmploi savedOffre = offreEmploiRepo.save(offreEmploi);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedOffre.getId()).toUri();

        return ResponseEntity.created(location).body(savedOffre);
    }
 */


    @GetMapping("/all")
    public ResponseEntity<List<Client>>getAllOffreEmplois(){
        List<OffreEmploi> offreEmplois = offreEmploiService.findAllOffreEmplois();
        return new ResponseEntity(offreEmplois , HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<OffreEmploi> getOffreEmploiById (@PathVariable("id") Long id) {
        OffreEmploi offreEmploi = offreEmploiService.findOffreEmploiById(id);
        return new ResponseEntity<>(offreEmploi, HttpStatus.OK);
    }
    @PostMapping("/add")
    public void addOffreEmpoi(@RequestBody OffreEmploi offreEmploi, @RequestParam Long clientId) {
        offreEmploiService.addOffreEmploi(offreEmploi, clientId);
    }
    @PutMapping("/update")
    public ResponseEntity<OffreEmploi> updateOffreEmploi(@RequestBody OffreEmploi offreEmploi) {
        OffreEmploi updateOffreEmploi = offreEmploiService.updateOffreEmploi(offreEmploi);
        return new ResponseEntity<>(offreEmploi, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOffreEmploi(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
