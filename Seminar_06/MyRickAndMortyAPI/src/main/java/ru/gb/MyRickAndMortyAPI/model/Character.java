package ru.gb.MyRickAndMortyAPI.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;
@Data
@RequiredArgsConstructor
public class Character {


    private final Integer id;
    private final String name;
    private final String status;
    private final String species;
    private final String type;
    private final String gender;
    private final Location origin;
    private final Location location;
    private final String image;
    private final List<String> episode;
    private final String url;
    private final String created;

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", origin=" + origin +
                ", location=" + location +
                ", image='" + image + '\'' +
                ", episode=" + episode +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                '}';
    }

}
