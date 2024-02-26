package ru.gb.MyRickAndMortyAPI.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Request <E>{
    private final Info info;
    private final List<E> results;
}
