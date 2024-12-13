package me.georgi.lyubenov.toystore.controller;


import me.georgi.lyubenov.toystore.dto.ToyDTO;
import me.georgi.lyubenov.toystore.model.Toy;
import me.georgi.lyubenov.toystore.service.ToyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/toys")
public class ToyController {

    private final ToyService toyService;


    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }
    @PostMapping
    public Toy createToy(@RequestBody ToyDTO toyDTO) {
        Toy newToy =toyService.addToy(toyDTO);
        return newToy;
    }
    @GetMapping
    public List<ToyDTO> getAllToys() {
        return toyService.findAllToys();
    }

    @GetMapping("/names")
    public List<String> getAllToyNames() {
        return toyService.getALlToyNames();
    }
    @GetMapping("/{id}")
    public ToyDTO getToyById(@PathVariable int id) {
        return toyService.getToyById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteToy(@PathVariable Integer id) {
        toyService.deleteToyById(id);
    }
    @PatchMapping("/{id}")
    public ToyDTO updateToy(@PathVariable int id,@RequestBody ToyDTO toyDTO) {
            return toyService.updateToy(id, toyDTO);
    }
}
