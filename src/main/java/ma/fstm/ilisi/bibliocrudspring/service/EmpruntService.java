package ma.fstm.ilisi.bibliocrudspring.service;

import ma.fstm.ilisi.bibliocrudspring.bean.Emprunt;
import ma.fstm.ilisi.bibliocrudspring.bean.EmpruntId;
import ma.fstm.ilisi.bibliocrudspring.dao.EmpruntDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmpruntService {
    @Autowired
    private EmpruntDao empruntDao;

    public void  save(Emprunt emprunt) {
         empruntDao.save(emprunt);
    }

    public Optional<Emprunt> findById(EmpruntId empruntId) {
        return empruntDao.findById(empruntId);
    }

    public void deleteById(EmpruntId empruntId) {
        empruntDao.deleteById(empruntId);
    }

    public void delete(Emprunt entity) {
        empruntDao.delete(entity);
    }
    public void delete(EmpruntId empruntId) {
        empruntDao.deleteById(empruntId);
    }

    public void update(Emprunt emprunt){
        empruntDao.save(emprunt);
    }

    public List<Emprunt> findAll(){
       return empruntDao.findAll();
    }
}
