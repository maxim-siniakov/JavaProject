package Logic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by max on 19.05.16.
 */
public class Logout  extends HttpServlet{

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
//        request.getSession().invalidate();
//        request.getRequestDispatcher("index.jsp").forward(request, response);
    doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String login = String.valueOf(session.getAttribute("login_session"));

        System.out.println(login);
        if (  login != null ){
            session.invalidate();
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.include(request, response);
        }

//        System.out.println(request.getSession().getAttribute("login"));
//        request.getSession().invalidate();
//        System.out.println(request.getSession().getAttribute("login"));


    }
}
