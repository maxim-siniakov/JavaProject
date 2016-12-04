package Logic.Subject;

import DAO.MySqlStudentDAO;
import DAO.MySqlSubjectDAO;
import Obj.Actor;
import Obj.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by max on 22.05.16.
 */
public class DeleteSubject  extends HttpServlet{
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        MySqlSubjectDAO<Subject> mySqlSubjectDAO= new MySqlSubjectDAO<>();
        String object = request.getParameter("subject");
        try {
            mySqlSubjectDAO.delete(object);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllSubjects.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            mySqlSubjectDAO.deleteConnection();
            out.close();
        }
    }
}
