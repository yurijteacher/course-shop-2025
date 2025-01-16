package ua.com.kisit.courseshop2025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "address")
public class Address {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI NN
    private Long id;

    private String street;
    private String city;
    private String state;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clients clientes;
}
