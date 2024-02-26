package ru.gb.MyRickAndMortyAPI.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.MyRickAndMortyAPI.repositories.MainRepo;

@Service
@RequiredArgsConstructor
public class MainService {
    private final MainRepo mainRepo;

    public void getAPIResourses(){
        mainRepo.getAPIResourses();

    }
}
