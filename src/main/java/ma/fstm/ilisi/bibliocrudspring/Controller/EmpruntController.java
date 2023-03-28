package ma.fstm.ilisi.bibliocrudspring.Controller;

import ma.fstm.ilisi.bibliocrudspring.bean.Adherant;
import ma.fstm.ilisi.bibliocrudspring.bean.Emprunt;
import ma.fstm.ilisi.bibliocrudspring.bean.EmpruntId;
import ma.fstm.ilisi.bibliocrudspring.bean.Exemplaire;
import ma.fstm.ilisi.bibliocrudspring.service.AdherantService;
import ma.fstm.ilisi.bibliocrudspring.service.EmpruntService;
import ma.fstm.ilisi.bibliocrudspring.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/emprunt")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;
    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private AdherantService adherantService;

    public EmpruntController() {
}

    @RequestMapping(method = RequestMethod.GET)
    public String viewEmpruntPage(Model model) {
        List<Emprunt> listEmprunts = empruntService.findAll();
        model.addAttribute("emprunts", listEmprunts);

        return "indexEmprunt";
    }

    @RequestMapping("/new")
    public String showNewEmpruntPage(Model model) {
        Emprunt emprunt = new Emprunt();
        List<Exemplaire> listExemplaires=exemplaireService.findFreeExemplaire();
        List<Adherant> listAdherants=adherantService.findAll();

        model.addAttribute("emprunt", emprunt);
        model.addAttribute("exemplaires",listExemplaires);
        model.addAttribute("adherants",listAdherants);

        return "new_emprunt";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmprunt(@ModelAttribute("emprunt") Emprunt emprunt) {
        emprunt.getId().setDateemp(LocalDate.now().toString());
        empruntService.save(emprunt);
        return "redirect:/emprunt";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmprunt(@PathVariable(name = "id") String id) {
        empruntService.delete(EmpruntId.parseString(id));
        return "redirect:/emprunt";
    }


}
