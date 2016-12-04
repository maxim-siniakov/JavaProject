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
import java.sql.SQLException;
/**
 * Created by max on 22.05.16.
 */
public class DeleteStudent extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        MySqlStudentDAO<Actor> mySqlStudentsDAO= new MySqlStudentDAO<>();
        String object = request.getParameter("login_student");
        try {
            mySqlStudentsDAO.delete(object);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAllStudents.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mySqlStudentsDAO.deleteConnection();
            out.close();
        }
    }
}

