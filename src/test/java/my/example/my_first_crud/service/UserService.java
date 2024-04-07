package my.example.my_first_crud.service;

import my.example.my_first_crud.model.User;
import my.example.my_first_crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();

    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }
    public void updateById(int id,String firstName, String lastName){
        userRepository.updateById(id,firstName,lastName);
    }
}
