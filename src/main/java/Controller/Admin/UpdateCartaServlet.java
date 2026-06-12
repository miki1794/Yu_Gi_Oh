package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Dao.CartaDao;
import Model.Bean.Carta;

@WebServlet(name="UpdateProduct", value="/UpdateProduct")
public class UpdateCartaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            float prezzo = Float.parseFloat(request.getParameter("prezzo"));
            String link = request.getParameter("link");

            CartaDao productDao = new CartaDao();
            Carta oldProduct = productDao.doRetrievebyID(id);

            if (oldProduct == null) {
                response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
                return;
            }


            oldProduct.setNome(nome);
            oldProduct.setPrezzo(prezzo);
            oldProduct.setLink(link);

            boolean success = productDao.doUpdate(oldProduct);

            if (success) {
                response.sendRedirect(request.getContextPath() + "/jsp/adminProducts.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
            }

        } catch (NumberFormatException e) {
            System.out.println("Errore parsing parametri: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
        } catch (Exception e) {
            System.out.println("Errore generico: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
        }
    }
}

