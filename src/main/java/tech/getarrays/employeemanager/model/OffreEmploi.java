package tech.getarrays.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class OffreEmploi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false , updatable = false)
    private Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false , updatable = true)
    private Date created_at;
    private Date updated_at;
    private String descrption;
    private String typeEmploi;
    private String image;

  @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name="admin_id")
    private Admin admin;





    public OffreEmploi() { }

    public OffreEmploi(Long id, Date created_at, Date updated_at, String descrption, String typeEmploi ,Client client) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.descrption = descrption;
        this.typeEmploi = typeEmploi;
       this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getTypeEmploi() {
        return typeEmploi;
    }

    public void setTypeEmploi(String typeEmploi) {
        this.typeEmploi = typeEmploi;
    }

   public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "OffreEmploi{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", descrption='" + descrption + '\'' +
                ", typeEmploi='" + typeEmploi + '\'' +
                ", client=" + client +
                '}';
    }
    //un client peut avoir plesieur offres
    //un offre relier à un seule client
    //L’offres ne peut exister sans un client.
    //client peut avoir 0 à n offres
    // employee = offres
    // departement = client.

}
