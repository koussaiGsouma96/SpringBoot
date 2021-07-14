package tech.getarrays.employeemanager.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String nom;
    private String prenom;
    private String photoProfil;
    private String email;
    private String password;


    @OneToMany(targetEntity = OffreEmploi.class , mappedBy = "client",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OffreEmploi> offreEmploiList;

    @OneToMany(targetEntity = Commentaire.class , mappedBy = "client",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Commentaire> commentaireList;


    public Client() {

    }

    public Client(long id, String nom, String prenom, String photoProfil, String email, String password /*,List<OffreEmploi> offreEmploiList, List<Commentaire> commentaireList*/) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.photoProfil = photoProfil;
        this.email = email;
        this.password = password;
        //this.offreEmploiList = offreEmploiList;
       // this.commentaireList = commentaireList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
/*
    public List<OffreEmploi> getOffreEmploiList() {
        return offreEmploiList;
    }

    public void setOffreEmploiList(List<OffreEmploi> offreEmploiList) {
        this.offreEmploiList = offreEmploiList;
    }



    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }*/
}
