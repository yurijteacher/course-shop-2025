package ua.com.kisit.courseshop2025.service;


import org.springframework.stereotype.Service;
import ua.com.kisit.courseshop2025.entity.Users;
import ua.com.kisit.courseshop2025.repository.UserRepository;

@Service
public class UserService {


    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean getUserByUsername(String username) {
        return userRepository.findAllByUsername(username).isEmpty() ? false : true;
    }

    public Users saveNewUserToDB(Users user) {
        return userRepository.save(user);
    }

    public boolean getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findAllByUsernameAndPassword(username, password).isEmpty() ? false : true;
    }

    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
