package Controller.Everyone;
import Model.Bean.Carta;
import Model.Dao.CartaDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(name="ListaProdotti", value= "/ListaProdotti")
public class ProductListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        List<Carta> products=null;
        CartaDao CartaDao= new CartaDao();
        products = CartaDao.doRetrieveAll();
        System.out.println("Retrieved products count: " + products.size());

        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/jsp/ProductList.jsp").forward(request, response);

    }

}