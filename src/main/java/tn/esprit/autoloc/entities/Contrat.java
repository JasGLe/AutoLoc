package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContrat;
    Date dateSignature;
    Long montantTotal;
    Boolean valide;

    @OneToOne (mappedBy = "contrat")
    Reservation reservation;
    @OneToMany ( mappedBy = "contrat")
    List<Paiement> paiements;
}
