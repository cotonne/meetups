package com.example.demo.dvds;


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
public class DvdResource {

    private DvdService dvdService;

    public DvdResource(DvdService dvdService) {
        this.dvdService = dvdService;
    }

    @GetMapping("/dvd/{id}")
    public ResponseEntity<Dvd> get(@PathVariable Long id) {
        String currentPrincipalName = SecurityUtils.getUsername();
        Optional<Dvd> optionalDvd = dvdService.find(id, currentPrincipalName);
        return optionalDvd.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dvd")
    public ResponseEntity<Collection<Dvd>> getDvds() {
        String currentPrincipalName = SecurityUtils.getUsername();
        Collection<Dvd> dvds = dvdService.findAll(currentPrincipalName);
        return ResponseEntity.ok(dvds);
    }

    @DeleteMapping("/dvd/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        String currentPrincipalName = SecurityUtils.getUsername();
        dvdService.delete(id, currentPrincipalName);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/dvd")
    public ResponseEntity create(@Validated @RequestBody DvdDto dvdDto) {
        String currentPrincipalName = SecurityUtils.getUsername();
        Dvd save = dvdService.create(dvdDto, currentPrincipalName);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
