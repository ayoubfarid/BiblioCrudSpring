package ma.fstm.ilisi.bibliocrudspring.dao;


import ma.fstm.ilisi.bibliocrudspring.bean.Emprunt;
import ma.fstm.ilisi.bibliocrudspring.bean.EmpruntId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntDao extends JpaRepository<Emprunt, EmpruntId> {
}
