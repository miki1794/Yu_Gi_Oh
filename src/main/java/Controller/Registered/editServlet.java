package Controller.Registered;

import Model.Bean.Utente;
import Model.Dao.UtenteDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;

@WebServlet(name = "EditServlet", value = "/editprofile")
public class editServlet extends HttpServlet {

    @Override
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

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/modificaprofilo.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Map map = (session != null) ? (Map) session.getAttribute("map") : null;

        if (map == null || !"true".equals(map.get("isLogged"))) {
            response.sendRedirect(request.getContextPath() + "/Home");
            return;
        }

        Utente utenteCorrente = (Utente) session.getAttribute("utente");

        String nomeUtente     = request.getParameter("username");
        String email          = request.getParameter("email");
        String password       = request.getParameter("password");
        String conferma       = request.getParameter("conferma-password");
        String dataNascitaStr = request.getParameter("DataDiNascita");
        String telefono       = request.getParameter("NumeroDiTelefono");

        // Validazione password
        if (password != null && !password.isEmpty()) {
            if (!password.equals(conferma)) {
                request.setAttribute("errore", "Le password non coincidono.");
                request.getRequestDispatcher("/WEB-INF/jsp/modificaprofilo.jsp").forward(request, response);
                return;
            }
            utenteCorrente.setPassword(password);
        }

        if (nomeUtente != null && !nomeUtente.isEmpty()) utenteCorrente.setNomeUtente(nomeUtente);
        if (email != null && !email.isEmpty()) utenteCorrente.setEmail(email);
        if (dataNascitaStr != null && !dataNascitaStr.isEmpty()) utenteCorrente.setDataNascita(Date.valueOf(dataNascitaStr));
        if (telefono != null && !telefono.isEmpty()) utenteCorrente.setNumeroTelefono(telefono);

        UtenteDao dao = new UtenteDao();
        boolean success = dao.doUpdate(utenteCorrente);

        if (success) {
            session.setAttribute("utente", utenteCorrente);
            request.setAttribute("messaggio", "Profilo aggiornato con successo!");
        } else {
            request.setAttribute("errore", "Errore durante l'aggiornamento.");
        }

        request.getRequestDispatcher("/WEB-INF/jsp/modificaprofilo.jsp").forward(request, response);
    }
}