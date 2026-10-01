package tn.esprit.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.esprit.autoloc.entities.enums.CategorieVehicule;
import tn.esprit.autoloc.entities.enums.StatutVehicule;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(VehiculeRepository repository) {
        return args -> {

            Vehicule v1 = new Vehicule(
                    null,
                    "123 TUN 456",
                    "Toyota",
                    "Yaris",
                    CategorieVehicule.CITADINE,
                    new BigDecimal("120.00"),
                    StatutVehicule.DISPONIBLE
            );

            Vehicule v2 = new Vehicule(
                    null,
                    "789 TUN 012",
                    "BMW",
                    "Serie 3",
                    CategorieVehicule.BERLINE,
                    new BigDecimal("250.00"),
                    StatutVehicule.DISPONIBLE
            );

            repository.save(v1);
            repository.save(v2);
        };
    }
}