package com.example.Seminar_04.Homework.repository;

import com.example.Seminar_04.Homework.model.IP;
import com.example.Seminar_04.Homework.model.Switch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Getter
public class SwitchRepository {
    private final List<Switch> switches;
    private int id = 1;

    public Switch createSwitch(String ipAddress, String hostname, String model, String vendor) {
        Switch sw = new Switch(id++);
        sw.setIpAddress(IP.createIP(ipAddress));
        sw.setHostname(hostname);
        sw.setModel(model);
        sw.setVendor(vendor);
        return sw;
    }

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

    public void updateSwitchById(int id, String ipAddress, String hostname, String model, String vendor) {
        Optional<Switch> swOpt = getSwitchById(id);
        Switch sw;
        if(swOpt.isPresent()){
            sw = swOpt.get();
            sw.setIpAddress(IP.createIP(ipAddress));
            sw.setHostname(hostname);
            sw.setModel(model);
            sw.setVendor(vendor);
        }
    }
}
