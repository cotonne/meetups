package com.example.demo.dvds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DvdRepository extends JpaRepository<Dvd, Long>{
    void deleteByIdAndUuid(Long id, String uuid);

    Dvd findByIdAndUuid(Long id, String uuid);

    Collection<Dvd> findByUuid(String uuid);
}
