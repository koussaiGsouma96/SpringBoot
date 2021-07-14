package tech.getarrays.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id ;
    private Date date_de_publication;
    private Date update_at;
    private String cmntr;
    private String avis;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public Commentaire() {
    }

    public Commentaire(Long id, Date date_de_publication, Date update_at, String avis, Client client, Employee employee) {
        this.id = id;
        this.date_de_publication = date_de_publication;
        this.update_at = update_at;
        this.avis = avis;
        this.client = client;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_de_publication() {
        return date_de_publication;
    }

    public void setDate_de_publication(Date date_de_publication) {
        this.date_de_publication = date_de_publication;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
