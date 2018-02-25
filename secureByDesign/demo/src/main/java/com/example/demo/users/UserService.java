package com.example.demo.users;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> find(Long id, String uuid) {
        return Optional.ofNullable(userRepository.findByIdAndUuid(id, uuid));
    }

    public void delete(Long id, String uuid) {
        userRepository.deleteByIdAndUuid(id, uuid);
    }

    public User save(UserDTO userDto, String username) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setUuid(username);
        return userRepository.save(user);
    }

    public Collection<User> findAll(String uuid) {
        return userRepository.findByUuid(uuid);
    }
}
