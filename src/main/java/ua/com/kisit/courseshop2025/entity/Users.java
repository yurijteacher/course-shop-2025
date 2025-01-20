package ua.com.kisit.courseshop2025.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50, message = "значення параметра username повинно знаходитись у діапазоні від 3 до 50 символів")
    private String username;

    @Size(min = 3, max = 50, message = "значення параметра password повинно знаходитись у діапазоні від 3 до 50 символів")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> roleset;
}
