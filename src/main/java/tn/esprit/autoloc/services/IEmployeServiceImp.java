package tn.esprit.autoloc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.repositories.AgenceRepository;
import tn.esprit.autoloc.repositories.EmployeRepository;
import java.util.List;

@Service
@AllArgsConstructor

public class IEmployeServiceImp implements IEmployeService {
    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }
    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> consulterEmployes(){
        return employeRepository.findAll();
    }
    @Override
    public Employe consulterEmployeById(Long idEmploye) {
        return employeRepository.findById(idEmploye).orElse(null);
    }
    @Override
    public void supprimerEmploye(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }
    @Override
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = employeRepository.findById(idEmploye).get();
        employe.setAgence(null);
        return employeRepository.save(employe);
    }
    @Override
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {

        Employe employe = employeRepository.findById(idEmploye).get();
        Agence agence = agenceRepository.findById(idAgence).get();
        employe.setAgence(agence);
        return employeRepository.save(employe);
    }
}
