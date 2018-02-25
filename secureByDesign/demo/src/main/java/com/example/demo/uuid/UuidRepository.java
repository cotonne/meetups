package com.example.demo.uuid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UuidRepository extends JpaRepository<Uuid, Long> {
    Optional<Uuid> findByUsername(String username);
}
