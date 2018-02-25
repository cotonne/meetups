package com.example.demo.uuid;

import com.example.demo.dvds.DvdDto;
import com.example.demo.dvds.DvdService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.Optional;
import java.util.UUID;

@Service
public class UuidService implements UserDetailsService {

    private SecureRandom random = new SecureRandom();
    private UuidRepository uuidRepository;
    private DvdService dvdService;

    private static final String[] dvds = new String[]{
            "Harry Potter and the Philosopher's Stone (2001)",
            "Harry Potter and the Chamber of Secrets (2002)",
            "Harry Potter and the Prisoner of Azkaban (2004)",
            "Harry Potter and the Goblet of Fire (2005)",
            "Harry Potter and the Order of the Phoenix (2007)",
            "Harry Potter and the Half-Blood Prince (2009)",
            "Harry Potter and the Deathly Hallows – Part 1 (2010)",
            "Harry Potter and the Deathly Hallows – Part 2 (2011)",
    };

    public UuidService(UuidRepository uuidRepository, DvdService dvdService) {
        this.uuidRepository = uuidRepository;
        this.dvdService = dvdService;
    }

    @Transactional
    public Uuid create() {
        Uuid uuid = new Uuid();
        uuid.setUsername(UUID.randomUUID().toString());
        long l = random.nextLong();
        uuid.setPassword(String.valueOf(Math.abs(l)));
        uuid = uuidRepository.save(uuid);

        DvdDto dvdDto = new DvdDto();
        for (String name : dvds) {
            dvdDto.setName(name);
            dvdDto.setQuantity(1);
            dvdService.create(dvdDto, uuid.getUsername());
        }

        return uuid;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Uuid> uuidOptional = uuidRepository.findByUsername(s);
        Uuid uuid = uuidOptional.orElseThrow(() -> new UsernameNotFoundException("Unknown username or password"));
        return User
                .withUsername(uuid.getUsername())
                .password(uuid.getPassword())
                .authorities("USER")
                .build();
    }

}
