package com.example.demo.reservations;

import com.example.demo.dvds.Dvd;
import com.example.demo.dvds.DvdService;
import com.example.demo.users.User;
import com.example.demo.users.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private UserService userService;
    private DvdService dvdService;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Optional<Reservation> find(Long id, String uuid) {
        return reservationRepository.findByIdAndUuid(id, uuid);
    }

    public Collection<Reservation> findAll(String uuid) {
        return reservationRepository.findByUuid(uuid);
    }

    public void delete(Long id, String uuid) {
        reservationRepository.deleteByIdAndUuid(id, uuid);
    }

    public Optional<Reservation> create(ReservationDto reservationDto, String uuid) {
        Optional<User> optionalUser = userService.find(reservationDto.getIdUser(), uuid);
        Optional<Dvd> optionalDvd = dvdService.find(reservationDto.getIdDvd(), uuid);
        if (!optionalDvd.isPresent() || !optionalUser.isPresent()) {
            return Optional.empty();
        }

        Reservation reservation = new Reservation();
        reservation.setIdDvd(reservationDto.getIdDvd());
        reservation.setIdUser(reservationDto.getIdUser());
        reservation.setQuantity(reservationDto.getQuantity());
        reservation.setUuid(uuid);
        reservation = reservationRepository.save(reservation);
        return Optional.ofNullable(reservation);
    }
}
