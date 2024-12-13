package me.georgi.lyubenov.toystore.repository;

import me.georgi.lyubenov.toystore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

        User findByFirstNameAndLastName(String userFirstName, String userLastName);
}
