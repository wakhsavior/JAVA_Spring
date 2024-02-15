package my.spring.MVC.SMS.utils;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class StudentRepository {
private static List<String> students;
private static int id = 0;

    public StudentRepository() {
        if (students ==null){
            students = new ArrayList<>();
        }
    }
}
