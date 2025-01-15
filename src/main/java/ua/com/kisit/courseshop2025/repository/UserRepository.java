package ua.com.kisit.courseshop2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.courseshop2025.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
}
