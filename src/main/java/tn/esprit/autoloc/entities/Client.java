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
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClient;
    String nom;
    String prenom;
    String email;
    Long telephone;
    Long numPermis;
    Date dateInscription;

    @OneToMany (mappedBy = "client")
    List<Reservation> reservations;

}
