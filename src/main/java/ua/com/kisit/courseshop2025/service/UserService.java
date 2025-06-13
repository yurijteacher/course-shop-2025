package ua.com.kisit.courseshop2025.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.kisit.courseshop2025.entity.Users;
import ua.com.kisit.courseshop2025.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {


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

    public List<Users> findAll(){
        return userRepository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }

        return user;
    }
}
