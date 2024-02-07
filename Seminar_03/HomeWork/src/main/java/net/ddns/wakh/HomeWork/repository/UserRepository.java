package net.ddns.wakh.HomeWork.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.ddns.wakh.HomeWork.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Репозиторий хранения пользователей в ArrayList, заполнен с использование lombok
 */
@Repository
@Getter
public class UserRepository {
    private Map<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong();

    public void saveUser(User user) {
        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }
        users.put(user.getId(), user);
    }

    public void deleteUserById(Long id) {
        users.remove(id);
    }

    public User getUserById(Long id) {
        return users.get(id);
    }

    public List<User> getUsers() {
        return users.values().stream().toList();
    }
}
