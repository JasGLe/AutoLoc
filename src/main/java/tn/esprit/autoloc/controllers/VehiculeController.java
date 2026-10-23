package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.services.IVehiculeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("vehicule")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @PostMapping("/ajouter")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @DeleteMapping("/supprimer/{idVehicule}")
    public void supprimerVehicule(@PathVariable Long idVehicule) {
        vehiculeService.supprimerVehicule(idVehicule);
    }

    @GetMapping("/getbyId/{idVehicule}")
    public Vehicule consulterVehiculeById(@PathVariable Long idVehicule) {
        return vehiculeService.consulterVehiculeById(idVehicule);
    }

    @PutMapping
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @GetMapping
    public List<Vehicule> consulterVehicules() {
        return vehiculeService.consulterVehicules();
    }
}
