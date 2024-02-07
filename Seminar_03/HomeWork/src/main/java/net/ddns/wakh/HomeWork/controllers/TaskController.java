package net.ddns.wakh.HomeWork.controllers;

import lombok.AllArgsConstructor;
import net.ddns.wakh.HomeWork.domain.User;
import net.ddns.wakh.HomeWork.services.DataProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Контроллер работы с пользователями расположен в /tasks
 * Заполнение с использованием Lombok
 */
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    DataProcessingService dataProcessingService;

    /**
     * Метод реагируется на вызов /tasks/sort и запрашивает у Сервиса отсортированный
     * по имени список пользователей
     * @return List<User>
     */
    @GetMapping("/sort")
    public List<User> sortUser() {
        return dataProcessingService.sortUserByName();
    }

    /**
     * Метод реагируется на вызов /tasks/filter/min/max, вместо min max подставляются значения
     * Метод апрашивает у Сервиса список пользователей возраст которых в диапазоне min - max
     * @param min Минимальный возраст
     * @param max Максимальный возраст
     * @return List<User>
     */
    @GetMapping("/filter/{min}/{max}")
    public List<User> sortUser(@PathVariable int min, @PathVariable int max){
        return dataProcessingService.filterUserByAge(min,max);
    }

    /**
     * Метод реагируется на вызов /tasks/calc и запрашивает у Сервиса средний возраст всех сотрудников
     * @return double
     */
    @GetMapping("/calc")
    public double calculateAveUserAge(){
        return dataProcessingService.calculateAverageAge();
    }
}
