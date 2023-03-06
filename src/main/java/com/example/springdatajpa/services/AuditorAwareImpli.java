package com.example.springdatajpa.services;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpli implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.of("Admin");
    }
}
