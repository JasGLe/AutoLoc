package tn.esprit.autoloc.services;
import tn.esprit.autoloc.entities.Vehicule;
import java.util.List;

public interface IVehiculeService {
    Vehicule ajouterVehicule(Vehicule vehicule);
    Vehicule modifierVehicule(Vehicule vehicule);
    void supprimerVehicule(Long idVehicule);
    List<Vehicule> consulterVehicules();
    Vehicule consulterVehiculeById(Long idVehicule);
}
