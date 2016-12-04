package Logic.Faculty;

import DAO.MySqlFacultyDAO;
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
 * Created by max on 25.05.16.
 */
public class UpdateFaculty extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String name_faculty = request.getParameter("name_faculty");
        String mis_scores = request.getParameter("mis_scores");
        String limit_students = request.getParameter("limit_students");
        String name_faculty_old  = request.getParameter("name_faculty_old");

        String [ ] parameters = {name_faculty ,  mis_scores  , limit_students , name_faculty_old  };
        PrintWriter out=response.getWriter();
        MySqlFacultyDAO<Facultet> mySqlFacultyDAO= new MySqlFacultyDAO();
        try {
            mySqlFacultyDAO.update(parameters);
        } finally{
            mySqlFacultyDAO.deleteConnection();
            out.close();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllFaculties.jsp");
        dispatcher.forward(request, response);


    }





}
