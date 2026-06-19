package Controller.Admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dao.OrdineDao;
import Model.Dao.ItemOrdineDao;
import Model.Dao.CartaDao;
import Model.Bean.Ordine;
import Model.Bean.ItemOrdine;
import Model.Bean.Carta;

@WebServlet(name = "OrderDetails", value = "/OrderDetails")
public class OrderDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        OrdineDao orderDao = new OrdineDao();
        ItemOrdineDao itemDao = new ItemOrdineDao();
        CartaDao cartaDao = new CartaDao();

        try {

            String orderId = request.getParameter("id");

            System.out.println("========== ORDER DETAILS ==========");
            System.out.println("Order ID: " + orderId);

            if (orderId == null || orderId.isEmpty()) {
                System.out.println("ERRORE: id ordine nullo");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID ordine mancante");
                return;
            }

            Ordine order = orderDao.doRetrieveById(orderId);

            if (order == null) {
                System.out.println("ERRORE: ordine non trovato");
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Ordine non trovato");
                return;
            }

            System.out.println("========== ORDINE ==========");
            System.out.println("ID: " + order.getId());
            System.out.println("Utente: " + order.getUtente());
            System.out.println("Stato: " + order.getStato());
            System.out.println("Data: " + order.getDataOrdine());
            System.out.println("Totale: " + order.getPrezzoTot());
            System.out.println("Nome: " + order.getNome());
            System.out.println("Cognome: " + order.getCognome());

            ArrayList<ItemOrdine> orderItems =
                    itemDao.doRetrieveByID(orderId, order.getNome());

            System.out.println("========== ITEM ORDINE ==========");
            System.out.println("Totale item: " + orderItems.size());

            for (ItemOrdine item : orderItems) {
                System.out.println("-----");
                System.out.println("ID: " + item.getId());
                System.out.println("Ordine ID: " + item.getOrdineId());
                System.out.println("Utente: " + item.getUtente());
                System.out.println("Nome carta: " + item.getNomeCarta());
                System.out.println("Quantità: " + item.getQuantita());
                System.out.println("Prezzo: " + item.getPrezzo());
            }

            ArrayList<Carta> products = new ArrayList<>();

            System.out.println("========== PRODOTTI ==========");

            for (ItemOrdine item : orderItems) {

                int cartaId = Integer.parseInt(item.getNomeCarta());

                Carta carta = cartaDao.doRetrievebyID(cartaId);

                if (carta != null) {
                    products.add(carta);

                    System.out.println("Prodotto trovato ID: " + carta.getId());
                } else {
                    System.out.println("Prodotto NON trovato ID: " + cartaId);
                }
            }

            System.out.println("========== RIEPILOGO ==========");
            System.out.println("Items: " + orderItems.size());
            System.out.println("Prodotti: " + products.size());
            System.out.println("================================");

            request.setAttribute("order", order);
            request.setAttribute("orderItems", orderItems);
            request.setAttribute("products", products);

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/jsp/OrderDetails.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println("========== ERRORE SERVLET ==========");
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}