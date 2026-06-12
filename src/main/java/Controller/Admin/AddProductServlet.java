package Controller.Admin;

import Model.Bean.Carta;
import Model.Dao.CartaDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddProduct", value = "/AddProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AddProduct.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<String, String> userData = (Map<String, String>) session.getAttribute("map");

        if (userData == null || !"true".equals(userData.get("isLogged"))) {
            response.sendRedirect("Home");
            return;
        }

        try {
            String nome = request.getParameter("nome");
            float prezzo = Float.parseFloat(request.getParameter("prezzo"));
            String link = request.getParameter("link");

            Carta carta = new Carta(nome, prezzo, link);

            CartaDao cartaDao = new CartaDao();
            boolean saved = cartaDao.doSave(carta);
            System.out.println("Carta salvata: " + saved);

            response.sendRedirect("ListaProdotti");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Errore durante il salvataggio del prodotto.");
            request.getRequestDispatcher("/WEB-INF/jsp/AddProduct.jsp").forward(request, response);
        }
    }
}
