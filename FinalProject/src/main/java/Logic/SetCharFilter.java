package Logic;
import com.mchange.v2.io.FileIterator;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by max on 05.08.16.
 */
//@WebFilter(servletNames = {"InsertFacultyToStudent"})
public class SetCharFilter implements Filter {
//    // кодировка
//    private String encoding;
//
//    public void init(FilterConfig config) throws ServletException {
//        // читаем из конфигурации
//        encoding = config.getInitParameter("requestEncoding");
//
//
//        if (encoding == null)
//            encoding = "UTF-8";
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
//            throws IOException, ServletException {
//        request.setCharacterEncoding(encoding);
//        response.setCharacterEncoding(encoding);
//        next.doFilter(request, response);
//    }
//
//    public void destroy() {
//    }


//
//    private FilterConfig filterConfig = null;
//
//    public void init(FilterConfig config) throws ServletException {
//           this.filterConfig = config;
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
//
//
//        String encoding = request.getCharacterEncoding();
//        System.out.println(encoding);
//
//        if (!"UTF-8".equalsIgnoreCase(encoding)) {
//        }
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        next.doFilter(request, response);
//    }
//    @Override
//    public void destroy() {
//
//    }
private String encoding;
    public void init(FilterConfig config) throws ServletException {
//        encoding = config.getInitParameter("requestEncoding");
        encoding = "utf-8";
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        next.doFilter(request, response);
    }

    public void destroy() {

    }








}
