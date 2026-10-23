package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.services.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("employe")
public class EmployeController {
    private final IEmployeService employeService;

    @PostMapping("/ajouter")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @DeleteMapping("/supprimer/{idEmploye}")
    public void supprimerEmploye(@PathVariable Long idEmploye) {
        employeService.supprimerEmploye(idEmploye);
    }

    @GetMapping("/getbyId/{idEmploye}")
    public Employe consulterEmployeById(@PathVariable Long idEmploye) {
        return employeService.consulterEmployeById(idEmploye);
    }

    @PutMapping
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @GetMapping
    public List<Employe> consulterEmployes() {
        return employeService.consulterEmployes();
    }
}
