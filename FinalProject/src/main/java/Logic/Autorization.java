package Logic;

import com.sun.deploy.net.HttpRequest;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static jdk.internal.org.objectweb.asm.commons.GeneratorAdapter.AND;
/**
 * Created by max on 19.05.16.
 */
public class Autorization  extends HttpServlet{
    private static final long serialVersionUID = 1L;
    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;
    private ResultSet rs = null ;
    private Statement statement = null;
    private Connection conn= null;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out=response.getWriter();
        String login=request.getParameter("login");
        String pass=request.getParameter("pass");

    try{
            String sqlcheck = "SELECT login , pass FROM Actors WHERE  login ='" + login + "'";
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/TestDB");
            conn = dataSource.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(sqlcheck);
            rs.next();
            if (login.equals(rs.getString("login")) && pass.equals(rs.getString("pass"))) {
                out.print("welcome " + login + ", you are in ");
                HttpSession session = request.getSession();
                session.setAttribute("login_session", login);
                request.getRequestDispatcher("Faculties.jsp").include(request, response);
            } else {
                out.println("you have no account, please get registration");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
    } catch (SQLException e) {
       e.printStackTrace();
        out.print("you input are wrong password or login or you didn't registrate");
        request.getRequestDispatcher("index.jsp").include(request, response);
    } catch (NamingException e) {
        e.printStackTrace();
    }
        finally {
        try { if(null!=rs)rs.close();} catch (SQLException e)
        {e.printStackTrace();}
        try { if(null!=statement)statement.close();} catch (SQLException e)
        {e.printStackTrace();}
        try { if(null!=conn)conn.close();} catch (SQLException e)
        {e.printStackTrace();}
    }
    }
}
