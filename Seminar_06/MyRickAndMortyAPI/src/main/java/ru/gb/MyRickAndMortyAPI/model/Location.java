package ru.gb.MyRickAndMortyAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
public class Location {
    private  Integer id;
    private final String name;
    private  String type;
    private  String dimension;
    private  List<String> residents;
    private final String url;
    private  String created;

    public Location(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
