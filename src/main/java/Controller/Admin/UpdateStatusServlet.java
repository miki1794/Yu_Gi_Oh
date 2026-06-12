package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Dao.OrdineDao;


@WebServlet(name="UpdateStatus", value="/UpdateStatus")
public class UpdateStatusServlet extends HttpServlet{
    private OrdineDao orderDao = new OrdineDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("id"));
        String newStatus = request.getParameter("stato");

        boolean success = orderDao.updateOrdineStato(orderId, newStatus);
        if (success) {
            response.sendRedirect("OrderDetails?id=" + orderId);
        } else {
            response.getWriter().println("Failed to update order status.");
        }
    }
}
