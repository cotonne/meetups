package com.example.demo.reservations;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByIdAndUuid(Long id, String s);

    Collection<Reservation> findByUuid(String uuid);

    void deleteByIdAndUuid(Long id, String uuid);
}
