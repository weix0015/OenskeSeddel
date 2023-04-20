package com.example.oenskeseddel.Controller;

import com.example.oenskeseddel.Model.Bruger;
import com.example.oenskeseddel.Model.Login;
import com.example.oenskeseddel.Model.Ønske;
import com.example.oenskeseddel.Service.BrugerService;
import com.example.oenskeseddel.Service.ØnskeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    private BrugerService brugerService;
    private ØnskeService ønskeService;

    private Bruger bruger;

    public HomeController(BrugerService brugerService, ØnskeService ønskeService) {
        this.brugerService = brugerService;
        this.ønskeService = ønskeService;
    }

    // Home page
    @GetMapping("/")
    public String index() {
        return "Home/index";
    }

    // metode til "opret bruger" knappen på forsiden
    @GetMapping("/createBruger")
    public String createBruger() {
        return "Home/createBruger";
    }

    // "oprettes ny bruger" knappen opret ny bruger og vender tilbage til forsiden
    @PostMapping("/createNewBruger")
    public String createNew(@ModelAttribute Bruger bruger) {
        brugerService.addBruger(bruger);
        return "redirect:/";
    }

    // metode til "login" knappen på forsiden
    @GetMapping("/login")
    public String login(@ModelAttribute Login login) {
        return "Home/login";
    }

    // metode til efter login, hvis login input er forkert sendes bruger til error side,
    // hvis login input er rigtig kommer han til egen ønskeseddel.
    // Vi redirecter i bunden af metoden, da det sørger for at vi bliver sendt over på den rigtige html side
    // i stedet for at forblive på samme side.
    @PostMapping("/brugerLogin")
    public String brugerLogin(@ModelAttribute Login login) {
        String brugernavn = login.getBrugernavn();
        bruger = brugerService.findBrugernavn(brugernavn);
        if (bruger != null) {
            return "redirect:/createOenskeseddel/" + bruger.getBruger_id();
        } else {
            return "Home/loginError";
        }
    }

    @GetMapping("/createOenskeseddel")
    public String index(Model model) {
        List<Ønske> ønskeList = ønskeService.fetchAll();
        model.addAttribute("oenske", ønskeList);
        return "Home/createOenskeseddel" + bruger.getBruger_id();
    }

    // metode til at vise brugerens (den bestemte bruger der er login) ønskeseddel
    //PathVariable refererer til den værdi som vi angiver oppe i mapping. Efterfølgende kan vi så bruge variablen.
    @GetMapping("/createOenskeseddel/{bruger_id}")
    public String indexForUser(Model model, @PathVariable int bruger_id) {
        List<Ønske> ønskeList = ønskeService.fetchUserWishes(bruger_id);
        model.addAttribute("oenske", ønskeList);
        return "Home/createOenskeseddel";
    }

    // metode til at tilføje nye ønske
    @PostMapping("/createNewOenske")
    public String createNewØnske(@ModelAttribute Ønske ønske) {
        ønske.setBruger_id(bruger.getBruger_id());
        ønskeService.addØnske(ønske);
        return "redirect:/createOenskeseddel/" + bruger.getBruger_id();
    }

    // metode til at slette ønsker fra ønskeseddel
    @GetMapping("/sletOenske/{id}")
    public String sletOenske(@PathVariable("id") int id) {
        boolean deleted = ønskeService.sletOenske(id);
        if (deleted) {
            return "redirect:/createOenskeseddel/" + bruger.getBruger_id();
        } else {
            return "redirect:/Home/loginError";
        }
    }

    // methode til at opdater / redigere ønsker, der sendes til en ny side
    @GetMapping("/opdaterOenske/{id}")
    public String opdaterOenske(@PathVariable("id") int id, Model model) {
        model.addAttribute("oenske", ønskeService.findeØnske(id));
        return "Home/redigerOenske";
    }

    // metode til til sendes tilbage til ønskeseddel side efter opdater / redigere ønsket
    @PostMapping("/opdaterOenske")
    public String opdaterOenske(@ModelAttribute Ønske ønske) {
        ønskeService.opdaterOenske(ønske.getId(), ønske);
        return "redirect:/createOenskeseddel/" + bruger.getBruger_id();
    }
}

