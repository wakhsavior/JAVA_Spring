package ru.gb.MyRickAndMortyAPI.repositories;

import lombok.RequiredArgsConstructor;
import ru.gb.MyRickAndMortyAPI.model.Character;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.gb.MyRickAndMortyAPI.configs.APIResourses;
import ru.gb.MyRickAndMortyAPI.model.Request;

@Repository
@RequiredArgsConstructor
public class CharacterRepo {
    private final RestTemplate restTemplate = new RestTemplate();
    private final APIResourses apiResourses;

    public Request<Character> getAllCharacters(){
        return restTemplate.getForEntity(apiResourses.getCharacters(),Request.class).getBody();
    }
    public Character getCharacterById(int id){
        return restTemplate.getForEntity(apiResourses.getCharacters()+"/"+id,Character.class).getBody();
    }


}
