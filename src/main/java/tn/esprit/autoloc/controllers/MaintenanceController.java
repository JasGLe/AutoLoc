package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.services.IMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("maintenance")
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @PostMapping("/ajouter")
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @DeleteMapping("/supprimer/{idMaintenance}")
    public void supprimerMaintenance(@PathVariable Long idMaintenance) {
        maintenanceService.supprimerMaintenance(idMaintenance);
    }

    @GetMapping("/getbyId/{idMaintenance}")
    public Maintenance consulterMaintenanceById(@PathVariable Long idMaintenance) {
        return maintenanceService.consulterMaintenanceById(idMaintenance);
    }

    @PutMapping
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @GetMapping
    public List<Maintenance> consulterMaintenances() {
        return maintenanceService.consulterMaintenance();
    }
}
