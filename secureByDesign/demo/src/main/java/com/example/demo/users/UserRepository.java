package com.example.demo.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByIdAndUuid(Long id, String currentPrincipalName);

    void deleteByIdAndUuid(Long id, String uuid);

    Collection<User> findByUuid(String uuid);
}
