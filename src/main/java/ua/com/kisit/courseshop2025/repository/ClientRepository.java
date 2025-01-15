package ua.com.kisit.courseshop2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.courseshop2025.entity.Clients;

public interface ClientRepository extends JpaRepository<Clients, Long> {
}
