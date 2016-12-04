package Logic.Subject;
import DAO.MySqlFacultyDAO;
import DAO.MySqlSubjectDAO;
import Obj.Facultet;
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
 * Created by max on 24.05.16.
 */
public class InsertSubject  extends HttpServlet{
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String  name_subject = request.getParameter("name_subject");
        String [ ] parameters = {name_subject };
        PrintWriter out=response.getWriter();
        MySqlSubjectDAO<Subject> mySqlSubjectDAO= new MySqlSubjectDAO<>();
        try {
            mySqlSubjectDAO.create(parameters);
        } finally{
            mySqlSubjectDAO.deleteConnection();
            out.close();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllSubjects.jsp");
        dispatcher.include(request, response);

    }





}
