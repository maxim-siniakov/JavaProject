package Logic.Faculty;
import DAO.MySqlFacultyDAO;
import DAO.MySqlStudentDAO;
import DAO.MySqlSubjectDAO;
import Obj.Actor;
import Obj.Facultet;
import Obj.Subject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 20.05.16.
 */
public class AllFaculties  extends HttpServlet{
    private List<Facultet> listOfFaculties = new ArrayList<>();
    private List<Subject> listOfSubjects = new ArrayList<>();
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        MySqlFacultyDAO<Facultet> mySqlFacultyDAO= new MySqlFacultyDAO();
        MySqlSubjectDAO<Subject> mySqlSubjectDAO= new MySqlSubjectDAO<>();
        try {
            listOfFaculties=  mySqlFacultyDAO.getAll();
            listOfSubjects =mySqlSubjectDAO.getAll();
            HttpSession sess = request.getSession();
            sess.setAttribute("listOfFaculties", listOfFaculties);

            sess.setAttribute("listOfSubjects", listOfSubjects);
//            request.setAttribute("list", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllFaculties.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mySqlFacultyDAO.deleteConnection();
            mySqlFacultyDAO.deleteConnection();
            out.close();
        }
    }
}
