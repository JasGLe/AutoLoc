package tn.esprit.autoloc.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idAgence;
     String nom;
     String ville;
     String adresse;
     Long telephone;

     @OneToMany( mappedBy = "agence")
     List<Vehicule> vehicules;
     @OneToMany( mappedBy = "agence")
     List<Employe> employes;


}
