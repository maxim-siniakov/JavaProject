package Exc;

/**
 * Created by max on 27.07.16.
 */
public class ScoreException extends Exception  {
    private double score;
    public ScoreException ( String message , double score){
        super(message);
        this.score = score;
    }

    public String message ( ){
        return "Wrong ";
//        return "напишите баллы от одного до ста";
    }
}
