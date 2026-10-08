package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.autoloc.entities.enums.StatusReservation;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReservation;
    Date dateDebut;
    Date dateFin;
    StatusReservation status;

    @ManyToOne
    Vehicule vehicule;
    @OneToOne
    Contrat contrat;
    @ManyToOne
    Client client;


}
