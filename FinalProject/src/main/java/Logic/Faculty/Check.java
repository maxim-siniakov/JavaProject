package Logic.Faculty;

import Obj.Actor;
import Obj.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by max on 08.07.16.
 */
@WebServlet(name="Check",urlPatterns={"/Check"})
public class Check extends HttpServlet {
    private List<Subject> facultySubjectList = new ArrayList<>();
    public void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
    public void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String login =  request.getParameter("login");
        String pass =  request.getParameter("pass");
        System.out.println(login);
        System.out.println(pass);
        HttpSession session = request.getSession();
session.setAttribute(login , "login");
        RequestDispatcher dispatcher = request.getRequestDispatcher("charsetCheck.jsp");
        dispatcher.forward(request, response);
//        facultySubjectList =  (List<Subject>) request.getAttribute("facultySubjectList");
//        String count = request.getParameter("facultySubjectListSize");
//        String facultySubjectList1 =  request.getParameter("facultySubjectList");
//        System.out.println(facultySubjectList);
//
//        out.print(count);

//        System.out.println(facultySubjectList1);
    }
}
