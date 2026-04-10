package Controller.Everyone;

import Model.Bean.Carta;

import Model.Dao.CartaDao;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Prodotto", value = "/Prodotto")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("id");
        Carta carta =null;
        if(ids!=null){
            try{
                int id=Integer.parseInt(ids);
                CartaDao service= new CartaDao();
                carta=service.doRetrievebyID(id);
                if(carta!=null){
                    request.setAttribute("carta",carta);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/product.jsp");
                    dispatcher.forward(request, response);
                }
                else{
                    System.out.println("product not found");
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());


            }




        }
        else{ System.out.println("id not found in the request");}
    }
}












