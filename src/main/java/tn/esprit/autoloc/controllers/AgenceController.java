package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.services.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("agence")
public class AgenceController {
    private final IAgenceService agenceService;
    @PostMapping("/ajouter")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }
    @DeleteMapping("/supprimer/{idAgence}")
    public void supprimerAgence(@PathVariable Long idAgence){
        agenceService.supprimerAgence(idAgence);
    }
    @GetMapping("/getbyId/{idAgence}")
    public Agence consulterAgenceById(@PathVariable Long idAgence) {
        return agenceService.consulterAgenceById(idAgence);
    }
    @PutMapping
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }
    @GetMapping
    public List<Agence> consulterAgences(){
        return agenceService.consulterAgences();
    }
}
