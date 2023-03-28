package ma.fstm.ilisi.bibliocrudspring.service;

import ma.fstm.ilisi.bibliocrudspring.bean.Adherant;
import ma.fstm.ilisi.bibliocrudspring.dao.AdherantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdherantService {
    @Autowired
    private AdherantDao adherantDao;
    public void save(Adherant adherant){
         adherantDao.save(adherant);
    }

    public Optional<Adherant> findById(String s) {
        return adherantDao.findById(s);
    }

    public void deleteById(String s) {
        adherantDao.deleteById(s);
    }
    public void update(Adherant adherant){
        adherantDao.save(adherant);
    }
    public void delete(Adherant entity) {
        adherantDao.delete(entity);
    }
    public void deleteByCin(String cin){
        adherantDao.deleteById(cin);
    }

    public List<Adherant> findAll(){
        return adherantDao.findAll();
    }





}
