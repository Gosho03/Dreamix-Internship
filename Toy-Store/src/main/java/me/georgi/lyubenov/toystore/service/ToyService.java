package me.georgi.lyubenov.toystore.service;

import jakarta.persistence.EntityNotFoundException;
import me.georgi.lyubenov.toystore.dto.ToyDTO;
import me.georgi.lyubenov.toystore.model.Toy;
import me.georgi.lyubenov.toystore.repository.ToyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToyService {

    private final ToyRepository toyRepository;

    public ToyService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    public ToyDTO convertToDTO(Toy toy){
        ToyDTO dto = new ToyDTO();
        dto.setName(toy.getName());
        dto.setPrice(toy.getPrice());
        return dto;
    }
    public Toy convertToEntity(ToyDTO dto){
        Toy toy = new Toy();
        toy.setName(dto.getName());
        toy.setPrice(dto.getPrice());
        return toy;
    }
    //Add a toy
    public Toy addToy(ToyDTO dto){
        return toyRepository.save(convertToEntity(dto));
    }
    //Show all toys
    public List<ToyDTO> findAllToys(){
        return toyRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    //Delete
    public void deleteToyById(int id){
        toyRepository.deleteById(id);
    }
    //Update
    public ToyDTO updateToy(int toyId,ToyDTO dto){
        Optional<Toy> existingToy=toyRepository.findById(toyId);
        if(existingToy.isPresent()){
            Toy toy = existingToy.get();
            toy.setName(dto.getName());
            toy.setPrice(dto.getPrice());
            toyRepository.save(toy);
            return convertToDTO(toy);
        }
        else{
            throw new EntityNotFoundException();
        }
    }
    //Find toy by id
    public ToyDTO getToyById(int id) {
        return toyRepository.findById(id).map(this::convertToDTO).orElse(null);
    }
    public List<String> getALlToyNames() {
        return toyRepository.findAll().stream().map(Toy::getName).toList();


    }
}
