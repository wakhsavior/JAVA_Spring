package ru.gb.MyRickAndMortyAPI.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.gb.MyRickAndMortyAPI.model.Character;
import ru.gb.MyRickAndMortyAPI.model.Request;
import ru.gb.MyRickAndMortyAPI.repositories.CharacterRepo;

@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepo characterRepo;
    public Request<Character> getAllCharacters(){
        return characterRepo.getAllCharacters();
    }
    public Character getCharacterById(int id){
        return characterRepo.getCharacterById(id);
    }
public Request<Character> getCharacterPage(String urlPage){
        return characterRepo.getCharacterPage(urlPage);
}
}
