package com.example.demo.uuid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UuidResource {


    private UuidService uuidService;

    public UuidResource(UuidService uuidService) {
        this.uuidService = uuidService;
    }

    @GetMapping("/uuid")
    public ResponseEntity<Uuid> generate() {
        Uuid uuid = uuidService.create();
        return ResponseEntity.ok(uuid);
    }
}
