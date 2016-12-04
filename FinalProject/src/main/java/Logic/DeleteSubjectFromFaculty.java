package Logic;

import DAO.MySqlFacultyDAO;
import DAO.MySqlStudentDAO;
import Obj.Subject;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 02.08.16.
 */
public class DeleteSubjectFromFaculty extends HttpServlet {
    List<String> parametersForQuery = new ArrayList<>();
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String nameSubject =  request.getParameter("nameSubject");
        String idSubject =  request.getParameter("idSubject");
        String idFaculty = request.getParameter("idFaculty");
        System.out.println(idFaculty);
        System.out.println(idSubject);
        int idSubjectInt = Integer.valueOf(idSubject);
        Subject subject = new Subject();
        subject.setIdSubject(idSubjectInt);
        subject.setSubject(nameSubject);
//
        parametersForQuery.add(idFaculty);
        parametersForQuery.add(idSubject);

        MySqlFacultyDAO mySqlFacultyDAO = new MySqlFacultyDAO();
        try {
            mySqlFacultyDAO.deleteRecordIn(parametersForQuery );
            parametersForQuery.clear();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        finally {
            mySqlFacultyDAO.deleteConnection();

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Faculties.jsp");
        dispatcher.include(request, response);
    }
}
//