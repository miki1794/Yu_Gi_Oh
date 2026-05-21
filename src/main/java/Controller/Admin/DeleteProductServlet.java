package Controller.Admin;
import Model.Bean.Carta;
import Model.Dao.CartaDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name="DeleteProduct",value="/DeleteProduct")
public class DeleteProductServlet  extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
         CartaDao cartaDao = new CartaDao();
            Carta carta = cartaDao.doRetrievebyID(productId);
            boolean success = cartaDao.delete(carta);

            if (success) {
                response.sendRedirect("ListaProdotti");
            } else {
                response.sendRedirect("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Error");
        }
    }
}
