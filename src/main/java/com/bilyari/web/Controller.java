package com.bilyari.web;

import com.bilyari.model.Pump;
import com.bilyari.service.PumpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*", "http://localhost:3000"})
public class Controller {

    private final PumpService pumpService;

    public Controller(PumpService pumpService) {
        this.pumpService = pumpService;
    }

    @GetMapping("/pumps")
    public List<Pump> getPumpsValues() {
        return this.pumpService.getAllPumps();
    }

    @PostMapping("/pump")
    public void receivePumpValue(@RequestParam int id, @RequestParam double value) {
        this.pumpService.updatePumpValue(id, value);
    }
}
