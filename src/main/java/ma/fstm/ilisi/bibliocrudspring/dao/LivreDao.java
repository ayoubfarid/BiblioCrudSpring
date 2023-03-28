package ma.fstm.ilisi.bibliocrudspring.dao;

import ma.fstm.ilisi.bibliocrudspring.bean.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreDao extends JpaRepository<Livre, String> {
}
