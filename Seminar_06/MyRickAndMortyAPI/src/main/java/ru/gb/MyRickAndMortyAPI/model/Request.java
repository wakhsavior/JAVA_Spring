package ru.gb.MyRickAndMortyAPI.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class Request <E>{
    private Info info;
    private List<E> results;
}
