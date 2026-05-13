package Controller.Everyone;

import Model.Bean.Carta;
import Model.Dao.CartaDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="Search", value="/Search")
public class searchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        try{
            if(keyword==null||keyword.equals("")){
                response.sendRedirect("ListaProdotti");
                return;
            }
            CartaDao service=new CartaDao();
            ArrayList<Carta> result=service.search(keyword);
            request.setAttribute("result",result);
            request.setAttribute("keyword",keyword);
            request.getRequestDispatcher("/WEB-INF/jsp/results.jsp").forward(request,response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
