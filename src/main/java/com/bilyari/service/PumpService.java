package com.bilyari.service;

import com.bilyari.model.Pump;
import org.springframework.stereotype.Service;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PumpService {

    private final List<Pump> pumps;

    public PumpService() {
        this.pumps = new ArrayList<>();
    }

    public List<Pump> getAllPumps() {
        return this.pumps;
    }

    public void updatePumpValue(int id, double value) {

        Optional<Pump> optionalPump = this.pumps.stream().filter(p -> p.getId() == id).findFirst();

        if (optionalPump.isEmpty()) {
            this.pumps.add(createPump(id, value));

        } else {
            optionalPump.get().setValue(value);
        }
    }

    private Pump createPump(int id, double value) {
        Pump pump = new Pump();
        pump.setId(id);
        pump.setName("Pump " + id);
        pump.setValue(value);

        return pump;
    }
}
