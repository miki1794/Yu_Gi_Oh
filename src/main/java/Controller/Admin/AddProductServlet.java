package Controller.Admin;
import Model.Bean.Carta;
import Model.Dao.CartaDao;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
@WebServlet(name = "AddProduct", value = "/AddProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/addproducts.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<String, String> userData = (Map<String, String>) session.getAttribute("UserData");

        if (userData == null) {
            response.sendRedirect("Homepage");
            return;
        }

        try {
       
            String nome   = request.getParameter("nome");
            float prezzo  = Float.parseFloat(request.getParameter("prezzo"));


            String imgPath = null;
            Part filePart  = request.getPart("img");

            if (filePart != null && filePart.getSize() > 0) {
                String uploadPath = getServletContext().getRealPath("/assets/product/");
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) uploadDir.mkdirs();

                String originalFileName = filePart.getSubmittedFileName();
                String fileExtension    = originalFileName.substring(originalFileName.lastIndexOf('.'));
                String fileName         = nome + fileExtension;

                filePart.write(uploadPath + File.separator + fileName);
                imgPath = "assets/product/" + fileName;
            }


            Carta carta = new Carta(nome, prezzo, imgPath);


            CartaDao cartaDao = new CartaDao();
            boolean saved = cartaDao.doSave(carta);
            System.out.println("Carta salvata: " + saved);

            response.sendRedirect("ListaProdotti");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/jsp/error.jsp");
        }
    }
}