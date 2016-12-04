package Logic.Faculty;

import DAO.MySqlSubjectDAO;
import Logic.Subject.AllSubjects;
import Obj.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by max on 29.05.16.
 */
public class AddSubjectToFaculty extends HttpServlet {
    List<Subject> list = null;
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        List<Subject > list = (List<Subject>) request.getAttribute("list");
        String addSubject = request.getParameter("addSubject");
        MySqlSubjectDAO<Subject> mySqlSubjectDAO = new MySqlSubjectDAO<>();
        try {
            list = mySqlSubjectDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllFaculties.jsp");
        dispatcher.forward(request, response);
    }
}
