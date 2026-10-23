package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Paiement;
import tn.esprit.autoloc.services.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("paiement")
public class PaiementController {
    private final IPaiementService paiementService;

    @PostMapping("/ajouter")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @DeleteMapping("/supprimer/{idPaiement}")
    public void supprimerPaiement(@PathVariable Long idPaiement) {
        paiementService.supprimerPaiement(idPaiement);
    }

    @GetMapping("/getbyId/{idPaiement}")
    public Paiement consulterPaiementById(@PathVariable Long idPaiement) {
        return paiementService.consulterPaiementById(idPaiement);
    }

    @PutMapping
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @GetMapping
    public List<Paiement> consulterPaiements() {
        return paiementService.consulterPaiements();
    }
}
