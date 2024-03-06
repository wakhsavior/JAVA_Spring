package ru.gb.MyRickAndMortyAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Episode {
    private final Integer id;
    private final String name;
    private final String air_date;
    private final String episode;
    private final List<String> characters;
    private final String url;
    private final String created;
}
