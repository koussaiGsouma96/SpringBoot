package tech.getarrays.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String description;
    private String pasword;
    private int age;
    private String Diplome;
   // @Column(nullable = false, updatable = false)
  //  private String employeeCode;

    @OneToMany(targetEntity = Commentaire.class , mappedBy = "employee",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Commentaire> commentaireList;

    public Employee() {
    }

    public Employee( String nom, String prenom, String email, String jobTitle, String phone, String imageUrl, String description, String pasword, int age, String diplome, String employeeCode) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.description = description;
        this.pasword = pasword;
        this.age = age;
        Diplome = diplome;
        //this.employeeCode = employeeCode;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiplome() {
        return Diplome;
    }

    public void setDiplome(String diplome) {
        Diplome = diplome;
    }

    //public String getEmployeeCode() {
     //   return employeeCode;
    //}

    //public void setEmployeeCode(String employeeCode) {
        //this.employeeCode = employeeCode;
   // }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", pasword='" + pasword + '\'' +
                ", age=" + age +
                ", Diplome='" + Diplome + '\'' +
                '}';
    }
}