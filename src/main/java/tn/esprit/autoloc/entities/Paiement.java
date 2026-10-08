package tn.esprit.autoloc.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.autoloc.entities.enums.ModePaiement;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPaiement;
    Long montant;
    Date datePaiement;
    ModePaiement modePaiement;
    @ManyToOne
    Contrat contrat;

}
