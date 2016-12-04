package DAO;
import AbstractPackage.AbstractClass;
import Obj.Facultet;
import Obj.Subject;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by max on 22.05.16.
 */
public class MySqlSubjectDAO<S>  extends AbstractClass<Subject>{
    public List<Subject> getListSubjectByLogin(String login){
        List <Subject> listofSubjectsForStudent = null;
        String sql = "SELECT idSubject , subject From Subjects, Actors_subjects , Actors " +
                "WHERE Subjects.idSubject = Actors_subjects.id_Subject " +
                "AND Actors_subjects.id_Actor = Actors.idActors AND Actors.login = ?";
        try {
            conn = createConnection();
            pmst = conn.prepareStatement(sql);
            prepareStatementForShowList(pmst , login);
            rs =pmst.executeQuery();
            listofSubjectsForStudent = parseResultSet(rs);


        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return listofSubjectsForStudent  ;





    }

    @Override
    public String getSubject() {
        return null;
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Subjects";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Subjects ( subject ) values (?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Subjects SET subject = ? WHERE subject= ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Subjects WHERE subject = ? ";
    }
    @Override
    protected List parseResultSet(ResultSet rs) throws SQLException {
        LinkedList<Subject> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Subject subject = new Subject();
                subject .setIdSubject(rs.getInt("idSubject"));
                subject .setSubject(rs.getString("subject"));
                result.add(subject );
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return result;
    }

     @Override
    protected void prepareStatementForShowList(PreparedStatement statement, String args) throws SQLException {
        statement.setString(1 , args);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, String[] args) throws SQLException {
        statement.setString(1 , args[0]);
        statement.setString(2 , args[1]);
    }

    @Override
    protected void prepareStatementForShowInformation(PreparedStatement statement, String[] args) throws SQLException {
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, String[] args) throws SQLException {
        statement.setString(1 , args[0]);
    }


    @Override
    protected void prepareStatementForInsertBeetween(PreparedStatement statement, List<String> args) throws SQLException {
        statement.setString(1 , args.get(0));
        statement.setString(2 ,args.get(1));
        statement.setString(3 ,args.get(2));
    }

    public String addRecordInString ( ){
        return "INSERT INTO Actors_subjects (id_Actor ,  id_Subject , scores ) values ( ? , ? , ?)";
    }

    @Override
    public String deleteRecordInString() {
        return null;
    }

    public String addSubjectQuery ( ){
        return  "Insert INTO Faculties_subjects ( id_faculties , id_subject ) values ( ? , ? )";

    }


    public String getList ( ){
        return "SELECT   Subjects.idSubject  , Subjects.subject FROM Subjects, Faculties_subjects, " +
                " Faculties WHERE Subjects.idSubject = Faculties_subjects.id_subject AND " +
                "Faculties_subjects.id_faculties " +
                "= Faculties.idFaculties AND Faculties.name_faculty = ? ";
    }


    @Override
    public String getListSub() {
        return "SELECT Subjects.subject , Actors_subjects.scores    FROM Actors, Actors_subjects," +
                " Subjects WHERE Actors.idActors = Actors_subjects.id_actor AND Actors_subjects.id_Subject = Subjects.IdSubject AND Actors.login = ? ";
    }

    @Override
    public String getInformation() {
        return "SELECT FROM Actors WHERE subject = ?";
    }

    @Override
    public void create(String [ ] args) {

//        Subject g = new Subject( );
        try {
            persist( args);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        return g;
    }
    @Override
    public Subject getByPK(int key) {
        return null;
    }

    @Override
    public Subject getObjectByUniqueField(String smth) throws SQLException {
        return null;
    }

}
