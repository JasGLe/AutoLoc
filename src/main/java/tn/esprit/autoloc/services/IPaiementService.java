package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Paiement;
import java.util.List;

public interface IPaiementService {
    Paiement ajouterPaiement(Paiement paiement);
    Paiement modifierPaiement(Paiement paiement);
    Paiement consulterPaiementById(Long idPaiement);
    List<Paiement> consulterPaiements();
    void supprimerPaiement(Long idPaiement);
}
