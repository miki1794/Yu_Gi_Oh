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
import  Model.Dao.ItemOrdineDao;
import Model.Dao.CartaDao;
import Model.Bean.Ordine;
import Model.Bean.ItemOrdine;
import Model.Bean.Carta;

@WebServlet(name="OrderDetails", value="/OrderDetails")
public class OrderDetailsServlet extends HttpServlet{
    private OrdineDao orderDao = new OrdineDao();
    private ItemOrdineDao orderItemsDao = new ItemOrdineDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        OrdineDao orderDao = new OrdineDao();
        ItemOrdineDao orderItemsDao = new ItemOrdineDao();
        CartaDao productDao = new CartaDao();

        try{
            String orderId = request.getParameter("id");
            Ordine order = orderDao.doRetrieveById(orderId);
            ArrayList<ItemOrdine> orderItems = orderItemsDao.doRetrievebyID(orderId, order.getNome());
            System.out.println("order items retrieved"+orderItems.size());

            ArrayList<Carta> products = new ArrayList<>();
            for (ItemOrdine item : orderItems) {
                Carta product = productDao.doRetrievebyID(Integer.parseInt(item.getNomeCarta()));
                if (product != null) {
                    products.add(product);
                }
            }
            System.out.println("products retrieved"+products.size());



            request.setAttribute("orderItems", orderItems);
            request.setAttribute("products", products);
            request.setAttribute("order", order);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderDetails.jsp");
            dispatcher.forward(request, response);
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

}