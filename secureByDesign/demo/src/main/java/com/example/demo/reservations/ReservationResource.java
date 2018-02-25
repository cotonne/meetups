package com.example.demo.reservations;

import com.example.demo.config.SecurityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationResource {

    private ReservationService reservationService;

    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> get(@PathVariable Long id){
        String currentPrincipalName = SecurityUtils.getUsername();
        Optional<Reservation> reservation = reservationService.find(id, currentPrincipalName);
        return reservation.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/reservation")
    public ResponseEntity<Collection<Reservation>> getAll(){
        String currentPrincipalName = SecurityUtils.getUsername();
        Collection<Reservation> reservation = reservationService.findAll(currentPrincipalName);
        return ResponseEntity.ok(reservation);
    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<Reservation> delete(@PathVariable Long id){
        String currentPrincipalName = SecurityUtils.getUsername();
        reservationService.delete(id, currentPrincipalName);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reservation")
    public ResponseEntity create(@Validated @RequestBody ReservationDto reservationDto){
        String currentPrincipalName = SecurityUtils.getUsername();
        Optional<Reservation> save = reservationService.create(reservationDto, currentPrincipalName);

        if(!save.isPresent())
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(save.get().getId()).toUri();
        return ResponseEntity.created(location).build();

    }
}
