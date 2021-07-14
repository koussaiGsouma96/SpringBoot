package tech.getarrays.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nom;
    private String prenom;
    private int phone;

    private String photoProfil;
    private String email;
    private String password;

    @OneToMany(targetEntity = OffreEmploi.class , mappedBy = "admin",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OffreEmploi> offreEmploiList;

    public Admin() {

    }

    public Admin(Long id, String nom, String prenom, String photoProfil, String email, String password,int phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.photoProfil = photoProfil;
        this.email = email;
        this.phone = phone;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhotoProfil() {
        return photoProfil;
    }

    public void setPhotoProfil(String photoProfil) {
        this.photoProfil = photoProfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", photoProfil='" + photoProfil + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

