package Logic.Faculty;

import DAO.MySqlSubjectDAO;
import Obj.Actor;
import Obj.Facultet;
import Obj.Subject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
 * Created by max on 26.05.16.
 */
public class ShowFacultyInformation  extends HttpServlet {
    private List<Facultet> listOfInformation = new ArrayList<>();
    private List<Subject> facultySubjectList = new ArrayList<>();

    public void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int id = Integer.valueOf(request.getParameter("idFaculties"));
//        System.out.println(id + " first");
        String name_faculty = request.getParameter("name_faculty");
        int min_scores = Integer.valueOf(request.getParameter("min_scores"));
        int limit_students = Integer.valueOf(request.getParameter("limit_students"));
        Facultet facultet = new Facultet(id, name_faculty, min_scores, limit_students);
//        System.out.println(facultet.getIdFaculties() + " second");

        HttpSession sess = request.getSession();
        sess.setAttribute("facultet", facultet);

        MySqlSubjectDAO<Subject> mySqlSubjectDAO = new MySqlSubjectDAO<>();
        try {
            facultySubjectList = mySqlSubjectDAO.getListOfSomething(name_faculty);

            sess.setAttribute("facultySubjectListSize", facultySubjectList.size());
            sess.setAttribute("facultySubjectList", facultySubjectList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            RequestDispatcher dispatcher = request.getRequestDispatcher("FacultyInfo.jsp");
            dispatcher.forward(request, response);

            mySqlSubjectDAO.deleteConnection();
            out.close();

        }
//        System.out.println(facultySubjectList.size());

//        RequestDispatcher dispatcher = request.getRequestDispatcher("FacultyInfo.jsp");
//        dispatcher.forward(request, response);

        RequestDispatcher dispatcher1 = request.getRequestDispatcher("/Logic.InsertSubjectToStudent");
        dispatcher1.forward(request, response);


//        ServletContext context= getServletContext();
//        RequestDispatcher dispatcher = context.getRequestDispatcher("/Logic.Faculty.Check");
//        dispatcher.forward(request, response);

    }

}