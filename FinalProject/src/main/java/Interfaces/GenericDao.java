package Interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by max on 20.05.16.
 */
public interface GenericDao<T> {
    void create(String args []) throws SQLException;
    void delete(String stuff) throws SQLException;
    T getByPK(int key);
    T getObjectByUniqueField( String smth) throws SQLException;
    List <T> getAll() throws SQLException;
//    List <T> getById(String login)  throws SQLException;
    void update( String [ ] args);

}
