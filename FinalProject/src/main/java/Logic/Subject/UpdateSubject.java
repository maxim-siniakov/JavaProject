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

/**
 * Created by max on 25.05.16.
 */
public class UpdateSubject extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String name_subject = request.getParameter("name_subject");
        String name_subject_old = request.getParameter("name_subject_old");
        String [ ] parameters = {name_subject, name_subject_old};
        PrintWriter out=response.getWriter();
        MySqlSubjectDAO<Subject> mySqlSubjectDAO= new MySqlSubjectDAO<>();
        try {
            mySqlSubjectDAO.update(parameters);
        } finally{
            mySqlSubjectDAO.deleteConnection();
            out.close();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Faculties.jsp");
        dispatcher.forward(request, response);


    }
}
