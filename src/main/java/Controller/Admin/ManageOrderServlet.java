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
import Model.Bean.Ordine;


@WebServlet(name="ManageOrder", value="/ManageOrder")
public class ManageOrderServlet  extends HttpServlet{

    private OrdineDao orderDao = new OrdineDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Ordine> orders = orderDao.doRetrieveAll();
        System.out.println("Orders retrieved: " + orders.size());

        request.setAttribute("orders", orders);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/manageorder.jsp");
        dispatcher.forward(request, response); //fare jsp di manageorder
    }

}