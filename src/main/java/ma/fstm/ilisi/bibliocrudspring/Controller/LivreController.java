package ma.fstm.ilisi.bibliocrudspring.Controller;

import ma.fstm.ilisi.bibliocrudspring.bean.Exemplaire;
import ma.fstm.ilisi.bibliocrudspring.bean.Livre;
import ma.fstm.ilisi.bibliocrudspring.service.ExemplaireService;
import ma.fstm.ilisi.bibliocrudspring.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/livre")
public class LivreController {
    @Autowired
    private LivreService livreService;
    @Autowired
    private ExemplaireService exemplaireService;

    @RequestMapping("/")
    String viewLivrePage(Model model){
        List<Livre> livres=livreService.findAll();
        model.addAttribute("livres",livres);
        return "indexLivre";
    }
    @RequestMapping("/new")
    String showNewLivrePage(Model model)
    {
        Livre livre= new Livre();
        model.addAttribute("livre",livre);
        return "new_livre";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLivre(@ModelAttribute("livre") Livre livre, @RequestParam("nbr") long nbr) {
        Optional<Livre> l = livreService.findByISBN(livre.getIsbn());
        livreService.save(livre);
        if ( l.isPresent() ){
            Livre ll= l.get();
            long countExp=exemplaireService.findByIsbn(ll.getIsbn()).size();
            long change=nbr - countExp;
            long explaireEmprut=exemplaireService.findEmpruntedByIsbn(ll.getIsbn()).size();
            if(change>=0) {
                for(long i=0;i<change;i++)  exemplaireService.save(new Exemplaire( livre));

            }else if((explaireEmprut-change)<=countExp){
                long i=-change;
                List<Exemplaire> empruLivs=exemplaireService.findEmpruntedByIsbn(ll.getIsbn());
                for(Exemplaire e: exemplaireService.findByIsbn(ll.getIsbn())){
                    System.out.println("change : "+e.getIdexp());
                    if(i==0) break;
                    if(!empruLivs.contains(e)){
                        exemplaireService.delete(e.getIdexp());
                        i--;
                    }
                }
            }else {// 5 exp  3 emprunt retreiveExpEmprunt
                return "redirect:/error";
            }
        }else {
            for (long i = 0; i < nbr; i++) {
                exemplaireService.save(new Exemplaire( livre));
            }
        }
        return "redirect:/livre";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditLivrePage(@PathVariable(name = "id") String id){
        ModelAndView modelView=new ModelAndView("edit_livre");
        Optional<Livre> livre=livreService.findByISBN(id);
        modelView.addObject("livre",livre.get());
        return modelView;
    }
    @RequestMapping("/delete/{id}")
    public String deleteLivre(@PathVariable(name = "id") String id ){
        livreService.deleteByISBN(id);
        return "redirect:/livre";
    }

}
