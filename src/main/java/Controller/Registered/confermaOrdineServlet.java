package Controller.Registered;
import Model.Bean.Utente;
import Model.Dao.UtenteDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ConfermaOrdine", value = "/ConfermaOrdine")
public class confermaOrdineServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Map map = (session != null) ? (Map) session.getAttribute("map") : null;


        if (map == null || !"true".equals(map.get("isLogged"))) {
            response.sendRedirect(request.getContextPath() + "/Home");
            return;
        }


        Utente utente = (Utente) session.getAttribute("utente");
        if (utente == null) {
            UtenteDao dao = new UtenteDao();
            utente = dao.doRetrievebyUsername((String) map.get("username"));
            session.setAttribute("utente", utente);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/confermaOrdine.jsp");
        dispatcher.forward(request, response);
    }
}