package ru.gb.MyRickAndMortyAPI.repositories;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.gb.MyRickAndMortyAPI.model.Character;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.gb.MyRickAndMortyAPI.configs.APIResourses;
import ru.gb.MyRickAndMortyAPI.model.Request;

import java.lang.reflect.ParameterizedType;

@Repository
@RequiredArgsConstructor
public class CharacterRepo {
    private final RestTemplate restTemplate = new RestTemplate();
    private final APIResourses apiResourses;

    public  Request<Character> getAllCharacters(){

        ResponseEntity<Request<Character>> response = restTemplate.exchange(apiResourses.getCharacters(), HttpMethod.GET,null,
                new ParameterizedTypeReference<Request<Character>>(){});

        return response.getBody();
    }
    public Character getCharacterById(int id){
        return restTemplate.getForEntity(apiResourses.getCharacters()+"/"+id,Character.class).getBody();
    }
    public Request<Character> getCharacterPage(String urlPage){
        System.out.println(urlPage);
        ResponseEntity<Request<Character>> response = restTemplate.exchange(urlPage, HttpMethod.GET,null,
                new ParameterizedTypeReference<Request<Character>>(){});

        return response.getBody();
    }


}
