package Logic;

import DAO.MySqlFacultyDAO;
import DAO.MySqlStudentDAO;
import DAO.MySqlSubjectDAO;
import Exc.ScoreException;
import Obj.Actor;
import Obj.Facultet;
import Obj.Subject;

import javax.naming.NamingException;
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
 * Created by max on 18.07.16.
 */
    public class InsertFacultyToStudent  extends HttpServlet{
    private List<Facultet> listOfFacultiesSt= new ArrayList<>();
    private List<String> parametersForQuery = new ArrayList<>();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

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

        listOfFacultiesSt = (List<Facultet>) session.getAttribute("listOfFacultiesSt");

        List<Subject> listOfSubjectsForStudent = (List<Subject>) session.getAttribute("listOfSubjectsForStudent");
        List<Subject> facultySubjectList = (List<Subject>) session.getAttribute("facultySubjectList");

        if ( !listOfFacultiesSt.contains(facultet) ){
            parametersForQuery.add(idActor);
            parametersForQuery.add(idFacultyString);
            try {
            MySqlSubjectDAO mySqlSubjectDAO = new MySqlSubjectDAO();
            MySqlStudentDAO mySqlStudentDAO = new MySqlStudentDAO();
            facultySubjectList = mySqlSubjectDAO.getListOfSomething(addNameFaculty);
                if ( listOfSubjectsForStudent .containsAll(facultySubjectList )) {
                    mySqlStudentDAO.addRecordIn(parametersForQuery);
                    mySqlStudentDAO.deleteConnection();
                    mySqlStudentDAO.deleteConnection();
                    RequestDispatcher dispatcher = request.getRequestDispatcher("StudentInfo.jsp");
                    dispatcher.include(request, response);
//                    out.print("you have added the faculty to your list");
                    out.print("Вы добавили этот предмет в ваш список ");
                } else{
//                    out.print(text);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("StudentInfo.jsp");
                    dispatcher.include(request, response);
//                    out.print("you don't have require subjects");
                    out.print("У вас неполный список предметов");
                    throw new ScoreException("you don't have require subjects" , 0);

//                    request.getRequestDispatcher("StudentInfo.jsp").include(request, response);
//                    out.print(text);
                }
            } catch (Exception e) {

//                    e.printStackTrace();
                    out.close();
            }
        }
    }
}
