package ru.gb.MyRickAndMortyAPI.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.gb.MyRickAndMortyAPI.configs.ConfigCustomer;
import ru.gb.MyRickAndMortyAPI.configs.APIResourses;

@Repository
@RequiredArgsConstructor
public class MainRepo {
    private RestTemplate restTemplate = new RestTemplate();
    private final APIResourses apiResourses;
    private final ConfigCustomer configCustomer;

    public void getAPIResourses(){
        APIResourses tmp = restTemplate.getForEntity(configCustomer.getRestURL(),APIResourses.class).getBody();
        apiResourses.setCharacters(tmp.getCharacters());
        apiResourses.setLocations(tmp.getLocations());
        apiResourses.setEpisodes(tmp.getEpisodes());
    }


}
