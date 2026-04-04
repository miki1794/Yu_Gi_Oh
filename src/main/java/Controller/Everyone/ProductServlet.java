package Controller.Everyone;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;



@WebServlet(name = "registrazione", value = "/registrazione")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/product.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeUtente = request.getParameter("username");
        String numeroTelefono = request.getParameter("NumeroDiTelefono");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("conferma-password");
        String dataNascita = request.getParameter("DataDiNascita");
        String nazione = request.getParameter("Nazione");//TODO risolvere per il numero di telefono
        Date formattedDate = null;
    }
}