package com.example.Seminar_04.Homework.services;

import com.example.Seminar_04.Homework.model.IP;
import com.example.Seminar_04.Homework.model.Switch;
import com.example.Seminar_04.Homework.repository.SwitchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SwitchService {
    private final SwitchRepository switchRepository;

    public void addSwitch(Switch sw) {
        switchRepository.save(sw);
    }

    public List<Switch> findAll() {
        return switchRepository.getSwitches();
    }

    public void deleteSwitchById(int id) {
        switchRepository.deleteSwitchById(id);
    }

    public Optional<Switch> getSwitchById(int id) {
        return switchRepository.getSwitchById(id);
    }

}
