package tn.esprit.autoloc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repositories.EquipementRepository;
import tn.esprit.autoloc.repositories.VehiculeRepository;

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
}
