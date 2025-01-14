package ua.com.kisit.courseshop2025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

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

//    public Address() {
//    }
//
//    public Address(Long id, String street, String city,
//                   String state, Clients client) {
//        this.id = id;
//        this.street = street;
//        this.city = city;
//        this.state = state;
//        this.client = client;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public Clients getClient() {
//        return client;
//    }
//
//    public void setClient(Clients client) {
//        this.client = client;
//    }
//
//    @Override
//    public String toString() {
//        return "Address{" +
//                "id=" + id +
//                ", street='" + street + '\'' +
//                ", city='" + city + '\'' +
//                ", state='" + state + '\'' +
//                ", client=" + client +
//                '}';
//    }
}
