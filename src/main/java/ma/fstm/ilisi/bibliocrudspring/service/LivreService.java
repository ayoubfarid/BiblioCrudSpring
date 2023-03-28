package ma.fstm.ilisi.bibliocrudspring.service;

import ma.fstm.ilisi.bibliocrudspring.bean.Livre;
import ma.fstm.ilisi.bibliocrudspring.dao.LivreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService {
    @Autowired
    private LivreDao livreDao;

    public void save(Livre livre){
        livreDao.save(livre);
    }

    public void delete(Livre livre){
        livreDao.delete(livre);
    }

    public void deleteByISBN(String ISBN){
        livreDao.deleteById(ISBN);
    }
    public Optional<Livre> findByISBN(String ISBN){
        livreDao.findById(ISBN);
        return null;
    }
    public void update(Livre livre){
        livreDao.save(livre);
    }

    public List<Livre> findAll(){
        return livreDao.findAll();
    }

}
