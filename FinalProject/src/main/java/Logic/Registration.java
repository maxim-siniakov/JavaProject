package Logic;

import com.mysql.jdbc.PreparedStatement;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;
/**
 * Created by max on 16.05.16.
 */
public class Registration  extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resource(name = "jdbc/TestDB")
//    private DataSource dataSource;
    private ResultSet rs = null ;
    private Statement statement = null;
    private Connection conn= null;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String middlename =request.getParameter("middlename");
        String age=request.getParameter("age");
        String dateOfBirth=request.getParameter("dateOfBirth");
        String login=request.getParameter("login");
        String pass=request.getParameter("pass");
        String repeatpass=request.getParameter("repeatPass");
        int role = 2;
        try{
//            String sql = "SELECT login , Studentscol FROM Students  WHERE login = ? AND Studentscol = ?";
//            String sqlcheck = "SELECT login , Studentscol FROM Students WHERE  login ='"+login+"'  AND Studentscol = '"+pass+"'    ";
            String sqlcheck = "SELECT login , pass FROM Actors WHERE  login ='"+login+"'";
            String sqlinsert = "INSERT INTO Actors (name , surname, middlename ,age , dateOfBirth ,login , " +
                                "pass, role ) values('"+name+"','"+surname+"', '"+middlename+"', '"+age+"' ," +
                                "'"+dateOfBirth+"' , '"+login+"' ,  '"+pass+"' , '"+role+"' )";
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/TestDB");
            Connection conn = dataSource.getConnection();
            Statement statement = conn.createStatement();
            statement.executeQuery(sqlcheck);
            boolean check = statement.getResultSet().first();
        if ( !pass.equals(repeatpass )){
            out.print(" pass and repeatpass are not equal equal");
            request.getRequestDispatcher("Logic.Registration.jsp").include(request, response);
//            throw new Exc("pass and repeatpass are not equal");
        }
        else  if (check){
                out.print("the login already exist");
//                request.getRequestDispatcher("Logic.Registration.jsp").include(request, response);
            }
        else{
                statement.executeUpdate(sqlinsert);
                out.print("user has been added");
            request.getRequestDispatcher("index.jsp").include(request, response);
            }

//            PreparedStatement ps= (PreparedStatement) conn.prepareStatement("insert into registeruser values(?,?,?,?)");
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("login already exist, please create a new one");
            request.getRequestDispatcher("Logic.Registration.jsp").include(request, response);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if(null!=rs)rs.close();} catch (SQLException e)
            {e.printStackTrace();}
            try { if(null!=statement)statement.close();} catch (SQLException e)
            {e.printStackTrace();}
            try { if(null!=conn)conn.close();} catch (SQLException e)
            {e.printStackTrace();}
        }
    }
}
