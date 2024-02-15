package my.spring.MVC.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
    private String firstName;
    private String lastName;

    public Member() {
    }

}
