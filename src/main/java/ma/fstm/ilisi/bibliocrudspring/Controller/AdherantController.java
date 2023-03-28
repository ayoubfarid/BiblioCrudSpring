package ma.fstm.ilisi.bibliocrudspring.Controller;


import ma.fstm.ilisi.bibliocrudspring.bean.Adherant;
import ma.fstm.ilisi.bibliocrudspring.service.AdherantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/adherant")

public class AdherantController {
    @Autowired
    private AdherantService adherantService;

    @RequestMapping("/")
    public String viewAdherantPage(Model model){
        List<Adherant> listAdherant = adherantService.findAll();
        model.addAttribute("adherants", listAdherant);
        return "indexAdherant";
    }
    @RequestMapping("/new")
    public String showNewAdherantPage(Model model){
        Adherant adherant=new Adherant();
        model.addAttribute("adherant",adherant);
        return "new_adherant";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAdherant(@ModelAttribute("adherant") Adherant adherant){
        adherantService.save(adherant);
        return "redirect:/adherant/";
    }

    @RequestMapping("/edit/{cin}")
    public ModelAndView showEditAdherantPage(@PathVariable(name = "cin") String cin){
        ModelAndView mav = new ModelAndView("edit_adherant");
        Optional<Adherant> adherant = adherantService.findById(cin);
        mav.addObject("adherant",adherant);
        return mav;
    }
    @RequestMapping("/delete/{cin}")
    public String deleteAdherant(@PathVariable(name = "cin") String cin){
        adherantService.deleteByCin(cin);
        return "redirect:/adherant/";
    }


}
