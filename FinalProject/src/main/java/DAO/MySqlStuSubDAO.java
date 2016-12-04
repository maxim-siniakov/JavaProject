package DAO;

import AbstractPackage.AbstractClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by max on 29.05.16.
 */
public class MySqlStuSubDAO extends AbstractClass {
    @Override
    public String getSubject ( ){
        return "SELECT Subjects.subject , Actors_subjects.scores    FROM Actors, Actors_subjects," +
                " Subjects WHERE Actors.idActors = Actors_subjects.id_actor AND Actors_subjects.id_Subject = Subjects.IdSubject AND Actors.login = ? ";
    }

    @Override
    public String getSelectQuery() {
        return null;
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
        return null;
    }

    @Override
    public String getList() {
//          return "SELECT  Actors_subjects.scores FROM Actors, Actors_subjects, Subjects WHERE Actors.idActors = Actors_subjects.id_Actor AND  Actors_subjects.id_Subject = Subjects.idSubject AND Actors.login = ?";
        return "SELECT Actors_subjects.scores FROM Actors_subjects,Actors WHERE Actors.login = ? " +
                "AND Actors.idActors = Actors_subjects.id_actor " ;
    }

    @Override
    public String getListSub() {
        return null;
    }

    @Override
    protected List parseResultSet(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    protected void prepareStatementForShowList(PreparedStatement statement, String args) throws SQLException {
        statement.setString(1 , args);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, String[] args) throws SQLException {

    }

    @Override
    protected void prepareStatementForShowInformation(PreparedStatement statement, String[] args) throws SQLException {
        statement.setString(1 , args[0]);
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, String[] args) throws SQLException {

    }

    @Override
    protected void prepareStatementForInsertBeetween(PreparedStatement statement, List list) throws SQLException {

    }

    //    @Override
//    protected void prepareStatementForInsertBeetween(PreparedStatement statement, List<String> args) throws SQLException {
//        statement.setString(1 , args.get(0));
//        statement.setString(2 ,args.get(1));
//    }
    @Override
    public String getInformation() {
        return null;
    }

    @Override
    public void create(String[] args) throws SQLException {
//        return null;
    }
    @Override
    public String addRecordInString ( ){
        return "INSERT INTO Faculties_subjects (id_faculties, id_subject ) values ( ? , ?)";
    }

    @Override
    public String deleteRecordInString() {
        return null;
    }

    @Override
    public String addSubjectQuery ( ){
        return  "Insert INTO Faculties_subjects ( id_faculties , id_subject ) values ( ? , ? )";

    }

    @Override
    public Object getByPK(int key) {
        return null;
    }

    @Override
    public Object getObjectByUniqueField(String smth) throws SQLException {
        return null;
    }
}
