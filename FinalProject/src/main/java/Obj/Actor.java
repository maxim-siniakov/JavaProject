package Obj;

/**
 * Created by max on 20.05.16.
 */
import lombok.*;

//@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Actor {
    private int id;
    private String name;
    private String surname;
    private String middlename;
    private String dateOfBirth;
    private int age;
    private String login;
    private String password;
    private int role;


}
