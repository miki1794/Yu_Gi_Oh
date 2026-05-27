package Controller.Admin;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name="PageAdmin", value="/PageAdmin")
public class PageAdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session!=null){
            Map<String, String> userData = (Map<String, String>) session.getAttribute("map");

            if (userData == null) response.sendRedirect("home");
            else{
                String tipo = userData.get("ruolo");
                if(!"admin".equals(tipo)) response.sendRedirect("home"); //
                else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/PageAdmin.jsp");//da cambiare
                    dispatcher.forward(request, response);
                }
            }
        }


    }
}