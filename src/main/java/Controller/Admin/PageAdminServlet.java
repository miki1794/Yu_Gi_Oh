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
            Map<String, String> userData = (Map<String, String>) session.getAttribute("UserData");

            if (userData == null) response.sendRedirect("Homepage");
            else{
                String tipo = userData.get("tipo");
                if(!"admin".equals(tipo)) response.sendRedirect("home"); //
                else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/pageAdmin.jsp");//da cambiare
                    dispatcher.forward(request, response);
                }
            }
        }


    }
}