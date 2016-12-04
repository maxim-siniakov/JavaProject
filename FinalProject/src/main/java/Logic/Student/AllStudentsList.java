package Logic.Student;

import DAO.MySqlStudentDAO;
import Obj.Actor;

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
 * Created by max on 20.05.16.
 */
public class AllStudentsList extends HttpServlet {

    private List<Actor> list = new ArrayList<>();

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        MySqlStudentDAO<Actor> mySqlStudentsDAO= new MySqlStudentDAO<>();
        try {
             list =  mySqlStudentsDAO.getAll();
            request.setAttribute("list", list);
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
