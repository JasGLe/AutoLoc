package tn.esprit.autoloc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repositories.VehiculeRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class IVehiculeServiceImp implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;

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
}
