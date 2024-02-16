package com.example.Seminar_04.Homework.repository;

import com.example.Seminar_04.Homework.model.IP;
import com.example.Seminar_04.Homework.model.Switch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@RequiredArgsConstructor
@Getter
public class SwitchRepository {
    private final List<Switch> switches;
    private AtomicInteger counter = new AtomicInteger();


    public void deleteSwitchById(int id) {
        Optional sw = getSwitchById(id);
        if (sw.isPresent())
            switches.remove(sw.get());
    }

    public Optional<Switch> getSwitchById(int id) {
        for (Switch sw : switches) {
            if (sw.getId() == id) {
                return Optional.of(sw);
            }
        }
        return Optional.empty();
    }

    public Switch save(Switch sw) {
        if (sw.getId() == null) {
            sw.setId(counter.incrementAndGet());
        }
        switches.add(sw);
        return sw;
    }
}
