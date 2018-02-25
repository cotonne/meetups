package com.example.demo.dvds;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class DvdService {
    private DvdRepository dvdRepository;

    public DvdService(DvdRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }

    public Optional<Dvd> find(Long id, String uuid) {
        return Optional.ofNullable(dvdRepository.findByIdAndUuid(id, uuid));
    }

    public void delete(Long id, String uuid) {
        dvdRepository.deleteByIdAndUuid(id, uuid);
    }

    public Dvd create(DvdDto dvdDto, String uuid) {
        Dvd dvd = new Dvd();
        dvd.setName(dvdDto.getName());
        dvd.setQuantity(dvdDto.getQuantity());
        dvd.setUuid(uuid);
        return dvdRepository.save(dvd);
    }

    public Collection<Dvd> findAll(String uuid) {
        return dvdRepository.findByUuid(uuid);
    }
}
