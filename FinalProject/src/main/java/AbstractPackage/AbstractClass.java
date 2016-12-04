package AbstractPackage;
import Interfaces.GenericDao;
import Obj.Subject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by max on 20.05.16.
 */
public abstract class AbstractClass<T> implements GenericDao<T> {
    protected DataSource dataSource;
    protected Connection conn = null;
    protected Statement statement = null;
    protected ResultSet rs = null;


    protected java.sql.PreparedStatement pmst = null;

    public Connection createConnection() throws NamingException, SQLException {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:comp/env");
        dataSource = (DataSource) envContext.lookup("jdbc/TestDB");
        return dataSource.getConnection();
    }
    public void deleteConnection() {

        try {
            if (null != rs) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (null != statement) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (null != pmst) pmst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (null != conn) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public abstract String getSubject();

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    public abstract String getList();

    public abstract String getListSub();


    protected abstract List<T> parseResultSet(ResultSet rs) throws SQLException;

    protected abstract void prepareStatementForShowList(PreparedStatement statement, String  args) throws SQLException;
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, String[] args) throws SQLException;

    protected abstract void prepareStatementForShowInformation(PreparedStatement statement, String[] args) throws SQLException;

    protected abstract void prepareStatementForInsert(java.sql.PreparedStatement statement, String[] args) throws SQLException;
    protected abstract void prepareStatementForInsertBeetween(java.sql.PreparedStatement statement,List<String> list ) throws SQLException;

    /*
getListOfSomething needs to get information like ( list subjects on faculty)
 */
    public List<T> getListOfSomething(String nameOfSomething)throws SQLException{
        List<T> list  = null;
        String sql = getList();
        try { conn = createConnection();
            pmst = conn.prepareStatement( sql);
            prepareStatementForShowList(pmst , nameOfSomething);
            rs = pmst.executeQuery();
            list = parseResultSet(rs);
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            deleteConnection();
        }
        return list;
    }

    public List<T> getListOfSubForSt(String [] nameOfSomething)throws SQLException{
        List<T> list  = null;
        String sql = getSubject();
        try { conn = createConnection();
            pmst = conn.prepareStatement( sql);
            pmst.setString(1 , nameOfSomething[0]);
//            prepareStatementForShowList(pmst , nameOfSomething);
            rs = pmst.executeQuery();
            System.out.println(rs.next());
            list = parseResultSet(rs);
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            deleteConnection();
        }
        return list;
    }

abstract public String addRecordInString ();

abstract public String deleteRecordInString();
protected abstract String addSubjectQuery();

//добавляет записи в связующие таблицы
    public void addRecordIn( List<String> listOfSmth)throws  SQLException , NamingException {
        String sql = addRecordInString();
//        String sql = addSubjectQuery();
        conn = createConnection();
        pmst = conn.prepareStatement(sql);
        prepareStatementForInsertBeetween(pmst , listOfSmth);
        pmst.executeUpdate();
        deleteConnection();
    }

    // удаляют записи из связующих таблиц
    public void deleteRecordIn( List<String> listOfSmth) throws  SQLException , NamingException {
        String sql = deleteRecordInString();
//        String sql = addSubjectQuery();
        conn = createConnection();
        pmst = conn.prepareStatement(sql);
        prepareStatementForInsertBeetween(pmst , listOfSmth);
        pmst.executeUpdate();

    }


    public void persist(/*T object , */ String[] args) throws SQLException, NamingException {
        String sql = getCreateQuery();
        conn = createConnection();
        pmst = conn.prepareStatement(sql);
        prepareStatementForInsert(pmst, args);
        pmst.executeUpdate();
        deleteConnection();
    }

    // Для добавляния в связующие таблицы
// protected abstract void prepareStatementForInsertBeetween(PreparedStatement statement, String[] args) throws SQLException;

    public abstract String getInformation();

    public List<T> showInformation(String [] args) {
        List<T> list = null ;
        String sql = getInformation();
        System.out.println(sql);
        try {
            conn = createConnection();
            pmst = conn.prepareStatement(sql);
            prepareStatementForShowInformation(pmst , args);
            rs = pmst.executeQuery();
            list = parseResultSet(rs);
            System.out.println(list.size());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        finally {
            deleteConnection();
        }
        return list;
    }

    @Override
    public void update ( String [ ] args){
        String sql = getUpdateQuery();
        try{
            conn = createConnection();
            pmst = conn.prepareStatement( sql);
            prepareStatementForUpdate(pmst , args);
            pmst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        finally {
            deleteConnection();
        }
    }
    @Override
    public void delete(String object) throws SQLException {
        String sql  = getDeleteQuery();
        try {
            conn = createConnection();
            pmst = conn.prepareStatement("DELETE FROM Faculties WHERE name_faculty = ?");
            pmst.setString(1 , object);
            pmst.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        }finally {
            deleteConnection();
        }
    }


    @Override
    public List<T> getAll() throws SQLException {
        List<T> list = null;
        String sql = getSelectQuery();
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
}






