package ru.gb.MyRickAndMortyAPI.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.gb.MyRickAndMortyAPI.configs.ConfigCustomer;
import ru.gb.MyRickAndMortyAPI.model.Location;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LocationRepo {
    private RestTemplate restTemplate = new RestTemplate();
    private final ConfigCustomer configCustomer;
    public Location getLocation(int id){
//        return restTemplate.getForEntity(configCustomer.getRestURL())
    return  null;
    }
}
