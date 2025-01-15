package ua.com.kisit.courseshop2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.courseshop2025.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
