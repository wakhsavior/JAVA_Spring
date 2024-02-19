package my.spring.Homework_CRUD.services;


import lombok.RequiredArgsConstructor;
import my.spring.Homework_CRUD.model.User;
import my.spring.Homework_CRUD.repositories.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
    public void updateUser(User user){userRepository.updateById(user);}
    public Optional<User> getUserById(int id){
        return userRepository.getUserById(id);
    }

}