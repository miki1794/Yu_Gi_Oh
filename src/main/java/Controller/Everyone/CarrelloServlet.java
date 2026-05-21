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
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<ItemOrdine> carrello= (List<ItemOrdine>) session.getAttribute("carrello");
        if(carrello==null){
            carrello=new ArrayList<>();
            session.setAttribute("carrello",carrello);
        }
        String action=req.getParameter("action");
        String cartaId=req.getParameter("cartaId");
        if (cartaId==null){
            response.sendRedirect("/Cart");
            return;
        }
        CartaDao cartaDao=new CartaDao();
        Carta carta=cartaDao.doRetrievebyID(Integer.parseInt(cartaId));

    }
}
