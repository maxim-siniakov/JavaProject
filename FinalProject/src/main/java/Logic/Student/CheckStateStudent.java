package Logic.Student;

import DAO.MySqlStudentDAO;
import Obj.Actor;

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
 * Created by max on 19.08.16.
 */
public class CheckStateStudent extends HttpServlet {
    List<Actor> listOfStudentsWhoPassedClaim = new ArrayList<>();
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession();
        MySqlStudentDAO mySqlStudentDAO = new MySqlStudentDAO();
        try {
             listOfStudentsWhoPassedClaim = mySqlStudentDAO.getSelectStudentByRole();
            System.out.println(listOfStudentsWhoPassedClaim);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
