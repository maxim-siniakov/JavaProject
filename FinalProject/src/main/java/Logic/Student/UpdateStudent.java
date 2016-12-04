package Logic.Student;

import DAO.MySqlFacultyDAO;
import DAO.MySqlStudentDAO;
import Obj.Actor;
import Obj.Facultet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by max on 25.05.16.
 */
public class UpdateStudent extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String limit_students = request.getParameter("middlename");
        String dateOfBirth  = request.getParameter("dateOfBirth");
        String login  = request.getParameter("login");
        String pass= request.getParameter("pass");
        String login_new= request.getParameter("login_new");
        String [ ] parameters = {name ,  surname, limit_students , limit_students, dateOfBirth, login,pass , login_new};




        PrintWriter out=response.getWriter();
        MySqlStudentDAO<Actor> mySqlStudentDAO= new MySqlStudentDAO<>();
        try {
            mySqlStudentDAO.update(parameters);
        } finally{
            mySqlStudentDAO.deleteConnection();
            out.close();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllFaculties.jsp");
        dispatcher.forward(request, response);


    }



}
