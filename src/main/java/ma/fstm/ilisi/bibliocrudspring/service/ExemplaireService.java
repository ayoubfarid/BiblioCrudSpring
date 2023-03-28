package ma.fstm.ilisi.bibliocrudspring.service;

import ma.fstm.ilisi.bibliocrudspring.bean.Exemplaire;
import ma.fstm.ilisi.bibliocrudspring.dao.ExemplaireDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemplaireService {

    @Autowired
    private ExemplaireDao exemplaireDao;

    public void save(Exemplaire exemplaire){
        exemplaireDao.save(exemplaire);
    }

    public void delete(Exemplaire exemplaire){
        exemplaireDao.delete(exemplaire);
    }public void delete(Long id){
        exemplaireDao.deleteById(String.valueOf(id));
    }

    public void deleteByCode(String code){
        exemplaireDao.deleteById(code);
    }

    public void update(Exemplaire exemplaire){
        exemplaireDao.save(exemplaire);
    }
    public List<Exemplaire> findAll(){
       return  exemplaireDao.findAll();
    }


    public List<Exemplaire> findByIsbn(String isbn) {
        return exemplaireDao.findByIsbn(isbn);
    }

    public List<Exemplaire> findEmpruntedByIsbn(String isbn) {
            return exemplaireDao.findEmpruntedByIsbn(isbn);
    }

    public List<Exemplaire> findFreeExemplaire() {
        return exemplaireDao.findFreeExemplaire();
    }
}
