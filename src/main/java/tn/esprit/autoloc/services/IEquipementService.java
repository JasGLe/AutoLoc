package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement consulterEquipementById(Long idEquipement);
    void supprimerEquipement(Long idEquipement);
    Equipement ajouterEquipement(Equipement equipement);
    Equipement modifierEquipement(Equipement equipement);
    List<Equipement> consulterEquipements();
}
