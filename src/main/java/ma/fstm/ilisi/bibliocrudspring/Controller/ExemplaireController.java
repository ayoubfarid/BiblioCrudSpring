package ma.fstm.ilisi.bibliocrudspring.Controller;


import ma.fstm.ilisi.bibliocrudspring.bean.Exemplaire;
import ma.fstm.ilisi.bibliocrudspring.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("biblio-api/exemplaire")
public class ExemplaireController {
    @Autowired
    private ExemplaireService exemplaireService;

    @GetMapping("/")
    public List<Exemplaire> findAll(){
        return exemplaireService.findAll();
    }
    @PostMapping("/")
    public void save(@RequestBody Exemplaire exemplaire ){
        exemplaireService.save(exemplaire);
    }
    @PutMapping("/")
    public void update(@RequestBody Exemplaire exemplaire ){
        exemplaireService.update(exemplaire);
    }
    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable String id){
        exemplaireService.deleteByCode(id);
    }
}
