package Controller.Everyone;

import Model.Bean.Utente;
import Model.Dao.UtenteDao;
import Model.Util.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import eccezioni.ValidException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "login", value = "/login")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Username=request.getParameter("Username");
        String Password=request.getParameter("Password");
        String hashedPassword= Utils.toHash(Password);
        try {

            List<String> errorMessages = new ArrayList<>();

            if (!Utils.isValidPassword(Password)) {
                errorMessages.add("Invalid password");
            }
            if (!Utils.isValidUsername(Username)) {
                errorMessages.add("Invalid username");
            }

            if (!errorMessages.isEmpty()) {
                throw new ValidException(errorMessages);
            }

        } catch (ValidException e) {
            System.err.println(e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
            return;

        }
        UtenteDao service= new UtenteDao();
        Utente utente=service.doRetrievebyUsername(Username);
        if(utente!=null&&utente.getPassword().equals(hashedPassword)){
            HttpSession session = request.getSession(true); //accedo alla sessione , permette di creare ogetto sessione
            Map<String,String> map=new HashMap<>();
            String isLogged="true";
            map.put("isLogged",isLogged);
            map.put("username", utente.getNomeUtente());
            map.put("idUtente", utente.getIdUtente());
            map.put("email", utente.getEmail());
            map.put("dataNascita", utente.getDataNascita().toString());
            map.put("ruolo", utente.getRuolo());
            session.setAttribute("map",map);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            dispatcher.forward(request, response);
            return;
        } else {
            JsonObject errorMessages = new JsonObject();
            errorMessages.addProperty("error", "Login Fallito");
            String errorMessagesJson = new Gson().toJson(errorMessages);
            request.setAttribute("errorMessagesJson", errorMessagesJson);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);

        }

    }
}


