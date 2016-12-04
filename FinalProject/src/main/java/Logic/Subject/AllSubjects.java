package Logic.Subject;

import DAO.MySqlStudentDAO;
import DAO.MySqlSubjectDAO;
import Obj.Actor;
import Obj.Subject;

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
 * Created by max on 22.05.16.
 */
public class AllSubjects extends HttpServlet {
    private List<Subject> list = new ArrayList<>();
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        MySqlSubjectDAO <Subject> mySqlSubjectDAO = new MySqlSubjectDAO<>();
        try {
            list =  mySqlSubjectDAO.getAll();
            request.setAttribute("list", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllSubjects.jsp");
            dispatcher.include(request, response);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mySqlSubjectDAO.deleteConnection();
            out.close();
        }
    }


    }

