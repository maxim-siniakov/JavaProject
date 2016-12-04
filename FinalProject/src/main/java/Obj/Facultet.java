package Obj;

/**
 * Created by max on 20.05.16.
 */
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Facultet {
     private int idFaculties;
     private String nameFaculty;
     private int minScores;
     private int limitScores;


public Facultet( String nameFaculty , int minScores , int limitScores){
     this.nameFaculty = nameFaculty;
     this.minScores = minScores;
     this.limitScores = limitScores;
}

//     public Facultet( int IdFaculties , String nameFaculty , int minScores , int limitScores){
//          this.idFaculties = idFaculties;
//          this.nameFaculty = nameFaculty;
//          this.minScores = minScores;
//          this.limitScores = limitScores;
//     }



}
