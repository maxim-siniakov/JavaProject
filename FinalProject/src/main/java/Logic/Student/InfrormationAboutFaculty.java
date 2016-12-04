package Logic.Student;

import DAO.MySqlStudentDAO;
import DAO.MySqlSubjectDAO;
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
 * Created by max on 14.08.16.
 */
public class InfrormationAboutFaculty extends HttpServlet {
    List<Facultet> listOfFacultiesAll = new ArrayList<>();
    List<Subject> facultySubjectLis  = new ArrayList<>();
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession();
        int idFaculty = Integer.valueOf(request.getParameter("addIdFaculty"));
        String idFacultyString =  request.getParameter("addIdFaculty");
        String idActor =  String.valueOf(session.getAttribute("idActor")) ;
        String addNameFaculty = request.getParameter("addNameFaculty");
        int addLimitStudent = Integer.valueOf(request.getParameter("addLimitStudent")) ;
        int addMinScores = Integer.valueOf(request.getParameter("addMinScores"));
        Facultet facultet = new Facultet( );
        facultet.setIdFaculties(idFaculty);
        facultet.setNameFaculty(addNameFaculty);
        facultet.setLimitScores(addLimitStudent);
        facultet.setMinScores(addMinScores);
        MySqlSubjectDAO mySqlSubjectDAO = new MySqlSubjectDAO();
        String string = "что-то пошлоь не так черт возьми";
        System.out.println(string);

        session.setAttribute("string", string);
        session.setAttribute("facultet", facultet);
        try {
            facultySubjectLis =  mySqlSubjectDAO.getListOfSomething(addNameFaculty);
            session.setAttribute("facultySubjectLis", facultySubjectLis);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            mySqlSubjectDAO.deleteConnection();
            RequestDispatcher dispatcher = request.getRequestDispatcher("StudentInfoFaculties.jsp");
            dispatcher.include(request, response);
            out.close();
        }
    }
}
