package ma.fstm.ilisi.bibliocrudspring.bean;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="EXEMPLAIRE"
    ,schema="BIBLIO"
)
public class Exemplaire  implements java.io.Serializable {

   

     private Long idexp;
     private Livre livre;
     private Set<Emprunt> emprunts = new HashSet(0);

    public Exemplaire() {
    }

	
    public Exemplaire(Long idexp) {
        this.idexp = idexp;
    }
    public Exemplaire(Long idexp, Livre livre, Set emprunts) {
       this.idexp = idexp;
       this.livre = livre;
       this.emprunts = emprunts;
    }
    public Exemplaire(Livre livre){
        this.livre=livre;
    }
    public Exemplaire(Long idexp, Livre livre) {
        this.idexp = idexp;
        this.livre = livre;
    }
    
    
   
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDEXP", unique=true)
    public Long getIdexp() {
        return this.idexp;
    }
    
    public void setIdexp(Long idexp) {
        this.idexp = idexp;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ISBN")
    public Livre getLivre() {
        return this.livre;
    }
    
    public void setLivre(Livre livre) {
        this.livre = livre;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="exemplaire")
    public  Set<Emprunt> getEmprunts() {
        return this.emprunts;
    }
    
    public void setEmprunts( Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }




}


