package Logic;

import Exc.ScoreException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by max on 08.08.16.
 */
public class AuthFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        response.setContentType("text/html");
        PrintWriter out  = response.getWriter();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login_session");
        System.out.println(login);
//        String uri = req.getRequestURI();
//        this.context.log("Requested Resource::"+uri);


//
//        if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))){
//        if(session == null || login != "max" ){
////            this.context.log("Unauthorized access request");
////            res.sendRedirect("login.html");
//
//            res.sendRedirect("index.jsp");
//        }else{
//            // pass the request along the filter chain
//            chain.doFilter(request, response);
//        }

        try {
    if ( login.equals("max") ) {
        chain.doFilter(request, response);

    } else {
        // pass the request along the filter chain
        RequestDispatcher dispatcher = request.getRequestDispatcher("Faculties.jsp");
        dispatcher.include(request, response);
        out.print("нет прав");
        throw new ScoreException("you don't have enough rules for this page" , 0 );
//        chain.doFilter(request, response);
    }

}catch( ScoreException e){
    e.message();
}





    }

    public void destroy() {
        //close any resources here
    }
}
