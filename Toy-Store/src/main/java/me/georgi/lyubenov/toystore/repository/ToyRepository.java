package me.georgi.lyubenov.toystore.repository;

import me.georgi.lyubenov.toystore.model.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ToyRepository extends JpaRepository<Toy,Integer> {
    public Toy findByName(String name);
}
