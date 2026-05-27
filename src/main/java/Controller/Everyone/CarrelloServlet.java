package Controller.Everyone;

import Model.Bean.Carta;
import Model.Bean.ItemOrdine;
import Model.Dao.CartaDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Cart", value = "/Cart")
public class CarrelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Cart.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        List<ItemOrdine> cart = (List<ItemOrdine>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        String action  = req.getParameter("action");
        String cartaId = req.getParameter("cartaId");
        if (cartaId == null) {
            response.sendRedirect(req.getContextPath() + "/Cart");
            return;
        }


        CartaDao cartaDao = new CartaDao();
        Carta carta = cartaDao.doRetrievebyID(Integer.parseInt(cartaId));


        if (carta == null) {
            response.sendRedirect(req.getContextPath() + "/Cart");
            return;
        }


        if ("update".equalsIgnoreCase(action)) {
            int newQuantity = Integer.parseInt(req.getParameter("quantity"));
            for (ItemOrdine item : cart) {
                if (item.getNomeCarta().equals(String.valueOf(carta.getId()))) {
                    item.setQuantita(newQuantity);
                    item.setPrezzo(carta.getPrezzo() * newQuantity);
                    break;
                }
            }

        } else if ("remove".equalsIgnoreCase(action)) {
            cart.removeIf(item -> item.getNomeCarta().equals(String.valueOf(carta.getId())));

        } else {

            int quantita = Integer.parseInt(req.getParameter("quantity"));
            boolean found = false;

            for (ItemOrdine item : cart) {
                if (item.getNomeCarta().equals(String.valueOf(carta.getId()))) {
                    int quantitaTot = item.getQuantita() + quantita;
                    item.setQuantita(quantitaTot);
                    item.setPrezzo(carta.getPrezzo() * quantitaTot);
                    found = true;
                    break;
                }
            }

            if (!found) {
                ItemOrdine itemOrdine = new ItemOrdine();
                itemOrdine.setNomeCarta(String.valueOf(carta.getId()));
                itemOrdine.setQuantita(quantita);
                itemOrdine.setPrezzo(carta.getPrezzo() * quantita);
                cart.add(itemOrdine);
            }
        }

        session.setAttribute("cart", cart);
        response.sendRedirect(req.getContextPath() + "/Cart");
    }
}