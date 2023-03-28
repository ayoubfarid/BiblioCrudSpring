package ma.fstm.ilisi.bibliocrudspring.bean;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="ADHERANT"
    ,schema="BIBLIO"
)
public class Adherant  implements java.io.Serializable {

     private String cin;
     private String nom;
     private String prenom;
     private Set<Emprunt> emprunts = new HashSet(0);

    public Adherant() {
    }

    public Adherant( String nom, String prenom,String cin) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }

	
    public Adherant(String cin) {
        this.cin = cin;
    }
    public Adherant( String nom, String prenom,String cin, Set emprunts) {
       this.cin = cin;
       this.nom = nom;
       this.prenom = prenom;
       this.emprunts = emprunts;
    }
   
     @Id
    @Column(name="CIN", unique=true, nullable=false, length=50)
    public String getCin() {
        return this.cin;
    }
    
    public void setCin(String cin) {
        this.cin = cin;
    }

    
    @Column(name="NOM", length=50)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="PRENOM", length=50)
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="adherant")
    public  Set<Emprunt> getEmprunts() {
        return this.emprunts;
    }
    
    public void setEmprunts( Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }




}


