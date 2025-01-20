package ua.com.kisit.courseshop2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.courseshop2025.entity.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {


    List<Users> findAllByUsername(String login);

    List<Users> findAllByUsernameAndPassword(String login, String password);

    Users findByUsername(String username);

}
