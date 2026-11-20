package tn.esprit.autoloc.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repositories.EquipementRepository;
import tn.esprit.autoloc.repositories.VehiculeRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IVehiculeServiceImp implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule){
        return vehiculeRepository.save(vehicule);
    }
    @Override
    public Vehicule modifierVehicule(Vehicule vehicule){
        return vehiculeRepository.save(vehicule);
    }
    @Override
    public List<Vehicule> consulterVehicules(){
        return vehiculeRepository.findAll();
    }
    @Override
    public void supprimerVehicule(Long idVehicule){
        vehiculeRepository.deleteById(idVehicule);
    }
    @Override
    public Vehicule consulterVehiculeById(Long idVehicule){
        return vehiculeRepository.findById(idVehicule).orElse(null);
    }
    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {

        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        Equipement equipement = equipementRepository.findById(idEquipement).get();

        if (vehicule.getEquipements() == null) {
            vehicule.setEquipements(new ArrayList<>());
        }

        if (!vehicule.getEquipements().contains(equipement)) {
            vehicule.getEquipements().add(equipement);
        }

        return vehiculeRepository.save(vehicule);
    }
    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {

        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        Equipement equipement = equipementRepository.findById(idEquipement).get();

        if (vehicule.getEquipements() != null) {
            vehicule.getEquipements().remove(equipement);
        }

        return vehiculeRepository.save(vehicule);
    }

    @Scheduled(initialDelay = 5000, fixedRate = 60000)
    public void actualiserEtatVehicules() {

        List<Vehicule> vehicules = vehiculeRepository.findAll();

        System.out.println("Nombre total de véhicules : " + vehicules.size());

        System.out.println("Date et heure d'actualisation : "
                + LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 * * MON")
    public void genererRapportVehicules() {

        List<Vehicule> vehicules = vehiculeRepository.findAll();

        int nombreTotal = vehicules.size();

        System.out.println("===== RAPPORT DES VEHICULES =====");
        System.out.println("Nombre total de véhicules : " + nombreTotal);
        System.out.println("Date et heure de génération : " + LocalDateTime.now());
        System.out.println("=================================");
    }
}
