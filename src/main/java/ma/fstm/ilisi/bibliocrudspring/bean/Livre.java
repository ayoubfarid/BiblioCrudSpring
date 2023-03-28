package ma.fstm.ilisi.bibliocrudspring.bean;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="LIVRE"
    ,schema="BIBLIO"
)
public class Livre  implements java.io.Serializable {

    public Livre(String isbn, String titre) {
        this.isbn = isbn;
        this.titre = titre;
    }


     private String isbn;
     private String titre;
     private Set<Exemplaire> exemplaires = new HashSet(0);

    public Livre() {
    }

	
    public Livre(String isbn) {
        this.isbn = isbn;
    }
    public Livre(String isbn, String titre, Set exemplaires) {
       this.isbn = isbn;
       this.titre = titre;
       this.exemplaires = exemplaires;
    }
   
     @Id

    
    @Column(name="ISBN", unique=true, nullable=false, length=13)
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    
    @Column(name="TITRE", length=100)
    public String getTitre() {
        return this.titre;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="livre")
    public Set<Exemplaire> getExemplaires() {
        return this.exemplaires;
    }
    
    public void setExemplaires(Set<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }




}


