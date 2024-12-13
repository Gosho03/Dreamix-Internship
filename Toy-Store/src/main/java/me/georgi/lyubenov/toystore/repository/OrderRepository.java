package me.georgi.lyubenov.toystore.repository;

import me.georgi.lyubenov.toystore.model.Order;
import me.georgi.lyubenov.toystore.model.Toy;
import me.georgi.lyubenov.toystore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {




}
