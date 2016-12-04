package Obj;
import lombok.*;
/**
 * Created by max on 22.05.16.
 */
@NoArgsConstructor(force = true)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Subject {
    private int idSubject;
    private String subject;
}
