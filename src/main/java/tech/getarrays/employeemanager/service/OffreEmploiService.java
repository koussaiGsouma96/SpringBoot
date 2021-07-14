package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Client;
import tech.getarrays.employeemanager.model.OffreEmploi;
import tech.getarrays.employeemanager.repo.ClientRepo;
import tech.getarrays.employeemanager.repo.OffreEmploiRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class OffreEmploiService {
    @Autowired
private final OffreEmploiRepo ofrreOffreEmploiRepo;
    private final ClientRepo clientRepo;

    public OffreEmploiService(OffreEmploiRepo ofrreOffreEmploiRepo, ClientRepo clientRepo) {
        this.ofrreOffreEmploiRepo = ofrreOffreEmploiRepo;
        this.clientRepo = clientRepo;
    }
    public void addOffreEmploi(OffreEmploi offreEmploi, Long clientId) {
        // First we need to retrieve user from DB

        if (clientId != null) {
            Client client = clientRepo.findById(clientId).orElse(null);
            // Check if user exists in database
            if (client != null) {
                // associate the user to the post
                offreEmploi.setClient(client);
            }
        }
        // save post
        ofrreOffreEmploiRepo.save(offreEmploi);
    }
    public List<OffreEmploi> findAllOffreEmplois()
    {
        return ofrreOffreEmploiRepo.findAll();
    }
    public OffreEmploi updateOffreEmploi(OffreEmploi offreEmploi)
    {
        return ofrreOffreEmploiRepo.save(offreEmploi);
    }
    public OffreEmploi findOffreEmploiById(Long id)
    {
        return (OffreEmploi) ofrreOffreEmploiRepo.findOffreEmploitById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteOffreEmploi(Long id)
    {
        ofrreOffreEmploiRepo.deleteOffreEmploiById(id);
    }

}
