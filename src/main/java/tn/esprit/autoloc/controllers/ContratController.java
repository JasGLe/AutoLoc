package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.services.IContratService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("contrat")
public class ContratController {
    private final IContratService contratService;

    @PostMapping("/ajouter")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajoutercontrat(contrat);
    }

    @DeleteMapping("/supprimer/{idContrat}")
    public void supprimerContrat(@PathVariable Long idContrat) {
        contratService.supprimerContrat(idContrat);
    }

    @GetMapping("/getbyId/{idContrat}")
    public Contrat consulterContratById(@PathVariable Long idContrat) {
        return contratService.consulterContratById(idContrat);
    }

    @PutMapping
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @GetMapping
    public List<Contrat> consulterContrats() {
        return contratService.consulterContrats();
    }
}
