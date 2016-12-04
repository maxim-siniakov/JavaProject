package Logic.Student;
import DAO.MySqlFacultyDAO;
import DAO.MySqlStuSubDAO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by max on 26.05.16.
 */
public class ShowStudentInformation extends HttpServlet {
    private List<Actor> listOfStudents= new ArrayList<>();
    private List<Facultet> listOfFacultiesSt= new ArrayList<>();
    private List<Subject> listOfSubjectsForStudent= new ArrayList<>();
    private List<Subject> listOfSubjectsAll= new ArrayList<>();
    private List<Facultet> listOfFacultiesAll= new ArrayList<>();
    private List<Float> scores = new ArrayList<>();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession();


        String login_session = String.valueOf(session.getAttribute("login_session"));
        String [ ] log = { login_session};

        MySqlSubjectDAO<Subject> mySqlSubjectDAO = new MySqlSubjectDAO();
        MySqlStudentDAO<Actor> mySqlStudentsDAO= new MySqlStudentDAO<>();
        MySqlFacultyDAO<Facultet> mySqlFacultyDAO= new MySqlFacultyDAO<>();
//        MySqlStuSubDAO mySqlStuSubDAO = new MySqlStuSubDAO() ;
        try{
            listOfFacultiesAll = mySqlFacultyDAO.getAll();
//            System.out.println(listOfFacultiesAll);

            listOfSubjectsAll =  mySqlSubjectDAO.getAll();
            listOfSubjectsForStudent = mySqlStudentsDAO.getSubjectForStudent(login_session);
            listOfStudents = mySqlStudentsDAO.showInformation(log );
            listOfFacultiesSt = mySqlFacultyDAO.getListOfSomething(login_session);
            scores =  mySqlStudentsDAO.getScoresSubjects(login_session);

            HttpSession sess = request.getSession();

            sess.setAttribute("idActor" , listOfStudents.get(0).getId());
            sess.setAttribute("login_session", login_session);
            sess.setAttribute("listOfStudents", listOfStudents.get(0));
            sess.setAttribute("listOfFacultiesSt", listOfFacultiesSt );
            sess.setAttribute("listOfSubjectsForStudent", listOfSubjectsForStudent);
            sess.setAttribute("listOfSubjectsAll", listOfSubjectsAll);
            sess.setAttribute("listOfFacultiesAll" , listOfFacultiesAll);
            sess.setAttribute("scores", scores);

//            sess.setAttribute("listOfSubjectsAndScores ", listOfSubjectsAndScores );
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mySqlFacultyDAO.deleteConnection();
            mySqlStudentsDAO.deleteConnection();
            mySqlSubjectDAO.deleteConnection();
            RequestDispatcher dispatcher = request.getRequestDispatcher("StudentInfo.jsp");
            dispatcher.forward(request, response);
            out.close();

        }

//
//        RequestDispatcher dispatcher1 = request.getRequestDispatcher("/Logic.SetCharFilter");
//        dispatcher.forward(request, response);
//        RequestDispatcher dispatcher2 = request.getRequestDispatcher("/Logic.InsertFacultyToStudent");
//        dispatcher.forward(request, response);


    }
}
