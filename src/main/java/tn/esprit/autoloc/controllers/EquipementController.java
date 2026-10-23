package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.services.IEquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("equipement")
public class EquipementController {
    private final IEquipementService equipementService;

    @PostMapping("/ajouter")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @DeleteMapping("/supprimer/{idEquipement}")
    public void supprimerEquipement(@PathVariable Long idEquipement) {
        equipementService.supprimerEquipement(idEquipement);
    }

    @GetMapping("/getbyId/{idEquipement}")
    public Equipement consulterEquipementById(@PathVariable Long idEquipement) {
        return equipementService.consulterEquipementById(idEquipement);
    }

    @PutMapping
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @GetMapping
    public List<Equipement> consulterEquipements() {
        return equipementService.consulterEquipements();
    }
}
