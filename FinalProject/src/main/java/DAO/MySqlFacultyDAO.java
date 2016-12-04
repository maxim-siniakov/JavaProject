package DAO;
import AbstractPackage.AbstractClass;
import Interfaces.GenericDao;
import Obj.Actor;
import Obj.Facultet;
import Obj.Subject;

import java.sql.PreparedStatement;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by max on 20.05.16.
 */
public class MySqlFacultyDAO <T> extends AbstractClass<Facultet> {



    public String addSubjectQuery ( ){
        return  "Insert INTO Faculties_subjects ( id_faculties , id_subject ) values ( ? , ? )";

    }




    @Override
    public String getSubject() {
        return null;
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Faculties";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Faculties ( name_faculty, min_scores , limit_students) values ( ? , ? , ?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Faculties SET name_faculty = ? , min_scores = ? , limit_students = ?  WHERE name_faculty = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Faculties WHERE name_faculty = ?";
    }

    @Override
    public String getList() {
        return "SELECT  Faculties.idFaculties,Faculties.name_faculty , Faculties.min_scores," +
                 "Faculties.limit_students  FROM Actors, Actors_faculties," +
                " Faculties WHERE Actors.idActors = Actors_faculties.id_actor AND " +
                "Actors_faculties.id_faculty = Faculties.idFaculties AND Actors.login = ? ";
    }

    @Override
    public String getListSub() {
        return null;
    }


    @Override
    public void create(String args[] ) throws SQLException {
//        Facultet g = new Facultet( );
        try {
            persist(   args );
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
@Override
public String addRecordInString ( ){
    return "INSERT INTO Faculties_subjects (id_faculties, id_subject ) values ( ? , ?)";
}

    @Override
    public String deleteRecordInString() {
        return "DELETE FROM Faculties_subjects WHERE   id_faculties = ?  AND id_subject = ? ";
    }

    @Override
    public Facultet getByPK(int key) {
        return null;
    }

    @Override
    public Facultet getObjectByUniqueField(String smth) throws SQLException {
        return null;
    }

    @Override
    protected List<Facultet> parseResultSet(ResultSet rs) throws SQLException {
        LinkedList<Facultet> result = new LinkedList<Facultet>();
        try {
            while (rs.next()) {
                Facultet facultet = new Facultet();
                facultet.setIdFaculties(rs.getInt("idFaculties"));
                facultet.setNameFaculty(rs.getString("name_faculty"));
                facultet.setMinScores(rs.getInt("min_scores"));
                facultet.setLimitScores(rs.getInt("limit_students"));
                result.add(facultet);
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
    protected void prepareStatementForInsert(PreparedStatement statement, String[] args) throws SQLException {
        statement.setString(1 , args[0]);
        statement.setInt(2 , Integer.valueOf(args[1]));
        statement.setInt(3 , Integer.valueOf(args[2]));

    }

       // Для добавляния в связующие таблицы
    @Override
    protected void prepareStatementForInsertBeetween(PreparedStatement statement, List<String> args) throws SQLException {
        statement.setString(1 , args.get(0));
        statement.setString(2 ,args.get(1));
    }

    @Override
    public String getInformation() {
        return "gg";
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, String[] args) throws SQLException {
        statement.setString(1 , args[0]);
        statement.setInt(2 , Integer.valueOf(args[1]));
        statement.setInt(3 , Integer.valueOf(args[2]));
        statement.setString(4 , args[3]);


    }

    @Override
    protected void prepareStatementForShowInformation(PreparedStatement statement, String[] args) throws SQLException {
        statement.setString(1 , args[0]);
    }

}