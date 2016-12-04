package Logic.Faculty;
import DAO.MySqlFacultyDAO;
import DAO.MySqlSubjectDAO;
import Obj.Facultet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by max on 23.05.16.
 */
public class InsertFaculty  extends HttpServlet{
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String name_faculty = request.getParameter("name_faculty");
        String mis_scores = request.getParameter("mis_scores");
        String limit_students = request.getParameter("limit_students");
        String [ ] parameters = {name_faculty ,  mis_scores  , limit_students};
        PrintWriter out=response.getWriter();
        MySqlFacultyDAO<Facultet> mySqlFacultyDAO= new MySqlFacultyDAO();
        try {
            mySqlFacultyDAO.create(parameters);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            mySqlFacultyDAO.deleteConnection();
            out.close();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllFaculties.jsp");
        dispatcher.forward(request, response);

    }
}
