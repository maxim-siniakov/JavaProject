package Logic;

import DAO.MySqlFacultyDAO;
import DAO.MySqlStudentDAO;
import DAO.MySqlSubjectDAO;
import Exc.ScoreException;
import Obj.Actor;
import Obj.Subject;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by max on 18.07.16.
 */
public class InsertSubjectToStudent  extends HttpServlet {
    private List<Actor> listOfAllStudents = null;
    private List<Subject> listOfSubjectsAll = null;
    private List<Subject> listOfSubjectsForStudent = null;
    private List<Float> listOfscores = null;
    private List<String> parametersForQuery = new ArrayList<>();

//    PrintWriter out=response.getWriter();

    public static double checkScores(String score) throws ScoreException {
        double scoreDouble = Integer.valueOf(score);
        try {
            if (scoreDouble <= 100 && scoreDouble >= 0) {
                return scoreDouble;
            } else
                throw new ScoreException("you have entered illegal data", scoreDouble);
        } catch (ScoreException e) {
            throw new ScoreException("you have entered illegal data", scoreDouble);
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String login_session = (String) session.getAttribute("login_session");
        String idActor = String.valueOf(session.getAttribute("idActor"));
        System.out.println(idActor);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id = Integer.valueOf(request.getParameter("addIdSubject"));
        String addSubject = request.getParameter("addSubject");
        String score = request.getParameter("score");
//        double scoreDouble = Double.valueOf(score);
        String idSubject = request.getParameter("addIdSubject");

        try {
            double scoreDouble = Double.valueOf(score);
            checkScores(score);
            Subject subject = new Subject();
            subject.setIdSubject(id);
            subject.setSubject(addSubject);

            listOfSubjectsForStudent = (List<Subject>) session.getAttribute("listOfSubjectsForStudent");
            listOfscores = (List<Float>) session.getAttribute("scores");
            listOfSubjectsAll = (List<Subject>) session.getAttribute("listOfSubjectsAll");

            MySqlStudentDAO mySqlStudentDAO = new MySqlStudentDAO();
            mySqlStudentDAO.getInformation();

            if (!listOfSubjectsForStudent.contains(subject)) {
                MySqlSubjectDAO mySqlSubjectDAO = new MySqlSubjectDAO();
                mySqlStudentDAO.getInformation();
                parametersForQuery.add(idActor);
                parametersForQuery.add(idSubject);
                parametersForQuery.add(score);
                System.out.println(parametersForQuery);
                try {
                    mySqlSubjectDAO.addRecordIn(parametersForQuery);
                } catch (NamingException | SQLException e) {
                    e.printStackTrace();
                }
                finally {
                    mySqlStudentDAO.deleteConnection();
                    mySqlSubjectDAO.deleteConnection();
                    out.close();
                }
            }

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/StudentInfo.jsp");
//        dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("StudentInfo.jsp");
            dispatcher.include(request, response);
            out.print("вы не ввели баллы");
//            out.print("You didn't enter the scores");
        } catch (ScoreException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("StudentInfo.jsp");
            dispatcher.include(request, response);
            out.print(e.message());
        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentInfo.jsp");
//        dispatcher.forward(requesu

    }
}
