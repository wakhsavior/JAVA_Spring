package net.ddns.wak.Java.Spring.repository;

import net.ddns.wak.Java.Spring.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository_old {
    private Map<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong();
    public List<User> findAll(){
        return new ArrayList<>(users.values());
    }
    public User findById(Long id){
        return users.get(id);
    }
    public User save(User user){
        if (user.getId() ==null){
            user.setId(counter.incrementAndGet());
        }
        users.put(user.getId(),user);
        return user;
    }
}
