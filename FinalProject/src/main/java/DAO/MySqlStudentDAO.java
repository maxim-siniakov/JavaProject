package DAO;
import AbstractPackage.AbstractClass;
import Obj.Actor;
import Obj.Facultet;
import Obj.Subject;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by max on 20.05.16.
 */
public class MySqlStudentDAO<A> extends AbstractClass<Actor>{
    @Override
    public String getSubject() {
        return null;
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Actors ";
    }


    @Override
    public String getInformation() {
        return "SELECT * FROM Actors WHERE login = ?";
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Actors WHERE login = ?";
    }

    @Override
    public String getList() {
        return "SELECT  Actors_subjects.scores FROM Actors, Actors_subjects, Subjects WHERE Actors.idActors = Actors_subjects.id_Actor AND  Actors_subjects.id_Subject = Subjects.idSubject AND Actors.login = ? ";
    }




    @Override
    public String getListSub() {
        return null;
    }





    //запрос для добавления в связующую таблицу Actors_faculties
    @Override
    public String addRecordInString (){
//        return "INSERT INTO Actors_faculties (id_Actor, id_Subject , scores) values ( ? , ? , ?) WHERE Actors.idActors = Actors_subjects.id_Actor  ";
        return "INSERT INTO Facultet.Actors_faculties (id_Actor, id_faculty) values ( ? , ?)";

    }

    @Override
    public String deleteRecordInString() {
        return "DELETE FROM Actors_faculties WHERE id_actor = ? AND id_faculty = ?";
    }

    @Override
    public String addSubjectQuery ( ){
        return  "gg";
    }

    @Override
    public void create(String [ ] args) {
        try {
            persist( args);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Actor getByPK(int key) {
        return null;
    }

    @Override
    public Actor getObjectByUniqueField(String smth) throws SQLException {
        return null;
    }
    //строка на для выбора студента с заданной ролью
    public String getChangeRoleStudentTo( ){
        return " Select * FROM Actors WHERE role = 2 ";
    }


    public List<Actor> getSelectStudentByRole (  )throws SQLException {
        List<Actor> list = null;
        String sql =getChangeRoleStudentTo();
        try {
            conn = createConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (NamingException e) {
            e.printStackTrace();
        }finally {
            deleteConnection();
        }
        return list;
    }






    @Override
    protected List<Actor> parseResultSet(ResultSet rs) throws SQLException{
        LinkedList<Actor> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Actor actor = new Actor();
                actor.setId(rs.getInt("idActors"));
                actor.setName(rs.getString("name"));
                actor.setSurname(rs.getString("surname"));
                actor.setMiddlename(rs.getString("middlename"));
                actor.setAge(rs.getInt("age"));
                actor.setDateOfBirth(rs.getString("dateOfbirth"));
                actor.setLogin(rs.getString("login"));
                actor.setPassword(rs.getString("pass"));
                actor.setRole(rs.getInt("role"));
                result.add(actor);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return result;
    }
    //    достаем список предметов для конкретного пользователя
    public List <Subject> getSubjectForStudent (String login){
           MySqlSubjectDAO mySqlSubjectDAO = new MySqlSubjectDAO();
           List<Subject> subjectsForStudent = mySqlSubjectDAO.getListSubjectByLogin(login);
            mySqlSubjectDAO.deleteConnection();
        return subjectsForStudent;
    }

    public List <Float> getScoresSubjects(String login){
        String sql =" SELECT scores FROM Actors_subjects , Actors, Subjects where Actors.idActors = Actors_subjects.id_Actor and Actors_subjects.id_Subject = Subjects.IdSubject and Actors.login = ?";
        List<Float> scores = new ArrayList<>();
        try {
            conn = createConnection();
            pmst = conn.prepareStatement(sql);
            prepareStatementForShowList(pmst , login);
            rs =pmst.executeQuery();
            while ( rs.next()){
                scores.add(rs.getFloat("scores"));
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

//    public void insertSubjectToStudent (String login ){
//
//    }

    @Override
    protected void prepareStatementForShowList(PreparedStatement statement, String args) throws SQLException {
        statement.setString(1 , args);
    }
    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, String[] args) throws SQLException {
    }
    @Override
    protected void prepareStatementForShowInformation(PreparedStatement statement, String [ ] args) throws SQLException {
        statement.setString(1 , args[0]);
    }
    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, String[] args) throws SQLException {
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////
@Override
protected void prepareStatementForInsertBeetween(PreparedStatement statement, List<String> args) throws SQLException {
    statement.setString(1 , args.get(0));
    statement.setString(2 ,args.get(1));

    }



}
