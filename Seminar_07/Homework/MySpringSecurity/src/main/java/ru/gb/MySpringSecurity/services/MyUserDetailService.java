package ru.gb.MySpringSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gb.MySpringSecurity.model.CustomUserDetails;
import ru.gb.MySpringSecurity.repositories.UserRepo;
import ru.gb.MySpringSecurity.model.User;

import java.util.Optional;
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>  user = userRepo.findByUsername(username);
        if (user.isEmpty()){
            System.out.println("User " +  username + " not found");
        } else {
            System.out.println("User " +  username + " found in database");
        }

        return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException(username + " not found"));
    }
}
