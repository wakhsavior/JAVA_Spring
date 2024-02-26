package ru.gb.MyRickAndMortyAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
public class Location {
    private final Integer id;
    private final String name;
    private final String type;
    private final String dimension;
    private final List<String> residents;
    private final String url;
    private final String created;

}
