package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Dao.CartaDao;
import Model.Bean.Carta;


@WebServlet(name="ModifyProduct", value="/ModifyProduct")
public class ModifyProductServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{




        String productId = request.getParameter("id");
        int id= Integer.parseInt(productId);

        CartaDao productDao = new CartaDao();
        Carta product = productDao.doRetrievebyID(id);


        request.setAttribute("product", product);


        request.getRequestDispatcher("/jsp/modifyproduct.jsp").forward(request, response);
        //fare jsp
    }

}
