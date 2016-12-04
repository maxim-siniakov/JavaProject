package Logic;
import DAO.MySqlFacultyDAO;
import DAO.MySqlSubjectDAO;
import Obj.Facultet;
import Obj.Subject;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 27.05.16.
 */
public class InsertSubjectToFaculty extends HttpServlet {
    private   List<Integer> subjectNames = new ArrayList<>();
    private List<Subject> facultySubjectList = new ArrayList<>();
    private List<String> idFacAndSub = new ArrayList<>();
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {


        String addSubject = request.getParameter("addSubject");
        String facultetName = request.getParameter("facultetName");
        String idFaculty = request.getParameter("idFaculty");
        String idSubject=  request.getParameter("idSubject");
        Integer idSubjectInt=Integer.valueOf(request.getParameter("idSubject")) ;

//        String facultySubjectList = request.getParameter("facultySubjectList");
        MySqlFacultyDAO<Facultet> mySqlFacultyDAO = new MySqlFacultyDAO<>();
        MySqlSubjectDAO<Subject> mySqlSubjectDAO = new MySqlSubjectDAO<>();
         try {
            facultySubjectList = mySqlSubjectDAO.getListOfSomething(facultetName);
            for ( Subject subject : facultySubjectList){
                subjectNames.add(subject.getIdSubject());
            }
//            mySqlFacultyDAO.addRecordInString(idFaculty,)
//             boolean a = !subjectNames.contains(idSubjectInt);
           if ( !subjectNames.contains(idSubjectInt)){
                idFacAndSub.add(idFaculty);
                idFacAndSub.add(idSubject);
               mySqlFacultyDAO.addRecordIn(idFacAndSub);
               idFacAndSub.clear();
               RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllFaculties.jsp");
               dispatcher.forward(request, response);
           }
             else {
               RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllFaculties.jsp");
               dispatcher.forward(request, response);
           }

        } catch (SQLException  | NamingException e) {
//        } catch (SQLException  e) {
            e.printStackTrace();
        }
        finally {
             mySqlFacultyDAO.deleteConnection();
             mySqlSubjectDAO.deleteConnection();
         }
        subjectNames.clear();
    }
}