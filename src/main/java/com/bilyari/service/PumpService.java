package com.bilyari.service;

import com.bilyari.model.Pump;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PumpService {

    private final List<Pump> pumps;

    public PumpService() {
        this.pumps = new ArrayList<>();
    }

    public List<Pump> getAllPumps() {
        return this.pumps.stream().sorted(Comparator.comparingInt(Pump::getId)).toList();
    }

    public void updatePumpValue(int id, double value) {

        Optional<Pump> optionalPump = getPump(id);

        if (optionalPump.isEmpty()) {
            this.pumps.add(createPump(id, value));

        } else {
            optionalPump.get().setValue(value);
        }
    }


    public void updatePumpName(int id, String name) {
        Optional<Pump> pump = getPump(id);
        pump.ifPresent(value -> value.setName(name));
    }

    private Optional<Pump> getPump(int id) {
        return this.pumps.stream().filter(p -> p.getId() == id).findFirst();
    }

    private Pump createPump(int id, double value) {
        Pump pump = new Pump();
        pump.setId(id);
        pump.setName("Pump " + id);
        pump.setValue(value);

        return pump;
    }
}
