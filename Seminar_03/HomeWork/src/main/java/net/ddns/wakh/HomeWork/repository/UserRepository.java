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
 * Репозиторий хранения пользователей в ArrayList.
 * Заполнен с использование lombok
 * Хранение в CoucurentHaskMap для быстрого доступа по ключу в виде ID
 * и параллельной работы в многопоточной среде
 * Так-же хранит количество заведенных пользователей counter
 */
@Repository
@Getter
public class UserRepository {
    private Map<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong();

    /**
     * Сохранение пользователя после создания или изменения. При создании нового пользователя
     * задается Id из счетчика
     * @param user
     */
    public void saveUser(User user) {
        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }
        users.put(user.getId(), user);
    }

    /**
     * Удаление пользователя по ID
     * @param id
     */
    public void deleteUserById(Long id) {
        users.remove(id);
    }

    /**
     * Находит пользователя в Map по ID и возвращает объект
     * @param id Идентификато пользователя
     * @return User Объект класса User
     */
    public User getUserById(Long id) {
        return users.get(id);
    }

    /**
     * Возвращает List Пользователей в репозитории
     * @return List<User> Список пользователей
     */
    public List<User> getUsers() {
        return users.values().stream().toList();
    }
}
