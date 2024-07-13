package com.bilyari.web;

import com.bilyari.model.Pump;
import com.bilyari.service.PumpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*", "https://bilyari.onrender.com", "http://localhost:3000"})
public class Controller {

    private final PumpService pumpService;

    public Controller(PumpService pumpService) {
        this.pumpService = pumpService;
    }

    @GetMapping("/pumps")
    public List<Pump> getPumpsValues() {
        return this.pumpService.getAllPumps();
    }

    @PostMapping("/pump-value")
    public void receivePumpValue(@RequestParam int id, @RequestParam double value) {
        this.pumpService.updatePumpValue(id, value);
    }

    @PostMapping("/pump-name")
    public void updatePumpName(@RequestParam int id, @RequestParam String name) {
        this.pumpService.updatePumpName(id, name);
    }
}
