import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "Average")
public class Average extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> reqParams = request.getParameterNames();
        double sum = 0;
        int count = 0;
        while (reqParams.hasMoreElements()) {
            sum += Double.parseDouble(request.getParameter(reqParams.nextElement()));
            count++;
        }
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<h2>The average is " + sum/count + "</h2>");
        out.println("</html>");
        out.close();
    }
}
