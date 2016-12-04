package Logic;

import DAO.MySqlStudentDAO;
import Obj.Facultet;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 03.08.16.
 */
public class DeleteFacultyFromStudent extends HttpServlet {
    List<String> parametersForQuery = new ArrayList<>();
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        MySqlStudentDAO mySqlStudentDAO = new MySqlStudentDAO();

        String idActor = String.valueOf(session.getAttribute("idActor")) ;
        String idFaculty = request.getParameter("idFaculty");
        System.out.println(idActor);
        System.out.println(idFaculty);
        parametersForQuery.add(idActor);
        parametersForQuery.add(idFaculty);
        try {
            mySqlStudentDAO.deleteRecordIn(parametersForQuery);
            parametersForQuery.clear();

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        finally {
            mySqlStudentDAO.deleteConnection();

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Faculties.jsp");
        dispatcher.include(request, response);
    }
}
