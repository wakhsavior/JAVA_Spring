package ru.gb.MyRickAndMortyAPI.configs;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class APIResourses {
    private String characters;
    private String locations;
    private String episodes;

    @Override
    public String toString() {
        return "APIResourses{" +
                "characters='" + characters + '\'' +
                ", locations='" + locations + '\'' +
                ", episodes='" + episodes + '\'' +
                '}';
    }
}
