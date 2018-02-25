package com.example.demo.users;

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
public class UsersResource {
    private UserService userService;

    public UsersResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        String currentPrincipalName = SecurityUtils.getUsername();
        Optional<User> userDTO = userService.find(id, currentPrincipalName);
        return userDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user")
    public ResponseEntity<Collection<User>> getUsers() {
        String currentPrincipalName = SecurityUtils.getUsername();
        Collection<User> userDTO = userService.findAll(currentPrincipalName);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        String currentPrincipalName = SecurityUtils.getUsername();
        userService.delete(id, currentPrincipalName);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user")
    public ResponseEntity create(@Validated @RequestBody UserDTO user) {
        String currentPrincipalName = SecurityUtils.getUsername();
        User save = userService.save(user, currentPrincipalName);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
