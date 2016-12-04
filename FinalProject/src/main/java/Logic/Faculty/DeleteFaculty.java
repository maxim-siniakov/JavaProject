package Logic.Faculty;
import DAO.MySqlFacultyDAO;
import DAO.MySqlStudentDAO;
import Obj.Actor;
import Obj.Facultet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by max on 21.05.16.
 */
public class DeleteFaculty  extends HttpServlet
{
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        MySqlFacultyDAO<Facultet> mySqlFacultyDAO = new MySqlFacultyDAO();
        String faculty = request.getParameter("name_faculty");
        try {
            mySqlFacultyDAO.delete(faculty);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllFaculties.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mySqlFacultyDAO.deleteConnection();
            out.close();
        }
    }
}
