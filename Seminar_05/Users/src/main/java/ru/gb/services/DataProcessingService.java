package ru.gb.services;

import ru.gb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }
}
