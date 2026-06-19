package Controller.Admin;
import Model.Bean.Carta;
import Model.Dao.CartaDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddProduct", value = "/AddProduct")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AddProduct.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<String, String> userData = (Map<String, String>) session.getAttribute("map");

        if (userData == null || !"true".equals(userData.get("isLogged"))) {
            response.sendRedirect("Home");
            return;
        }

        try {
            String nome = request.getParameter("nome");
            float prezzo = Float.parseFloat(request.getParameter("prezzo"));

            // 🔽 FILE UPLOAD (drag & drop)
            Part filePart = request.getPart("link"); // input type="file" name="link"

            String linkPath = null;

            if (filePart != null && filePart.getSize() > 0) {

                String uploadPath = getServletContext().getRealPath("/assets");
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) uploadDir.mkdirs();

                String originalFile = filePart.getSubmittedFileName();
                String extension = originalFile.substring(originalFile.lastIndexOf("."));

                String fileName = nome + "_" + System.currentTimeMillis() + extension;

                String fileFullPath = uploadPath + File.separator + fileName;
                filePart.write(fileFullPath);

                linkPath = "assets/" + fileName;
            }
                System.out.println(linkPath);
            Carta carta = new Carta(nome, prezzo, linkPath);

            CartaDao cartaDao = new CartaDao();
            boolean saved = cartaDao.doSave(carta);

            System.out.println("Carta salvata: " + saved);

            response.sendRedirect("ListaProdotti");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Errore durante il salvataggio del prodotto.");
            request.getRequestDispatcher("/WEB-INF/jsp/AddProduct.jsp").forward(request, response);
        }
    }
}