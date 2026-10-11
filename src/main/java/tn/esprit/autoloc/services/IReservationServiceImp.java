package tn.esprit.autoloc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Reservation;
import tn.esprit.autoloc.repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IReservationServiceImp implements IReservationService {
    private ReservationRepository reservationRepository;

    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    @Override
    public Reservation consulterReservationByID(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }
    @Override
    public Reservation modifierReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    @Override
    public List<Reservation> consulterReservations(){
        return reservationRepository.findAll();
    }
    @Override
    public void supprimerReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}
