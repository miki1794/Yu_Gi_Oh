package Controller.Everyone;


import Model.Bean.Utente;
import Model.Dao.UtenteDao;
import Model.Util.Utils;
import eccezioni.ValidException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


@WebServlet(name = "registrazione", value = "/registrazione")
public class RegistrazioneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/registrazione.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         String nomeUtente=request.getParameter("username");
         String numeroTelefono=request.getParameter("NumeroDiTelefono");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String confirmPassword=request.getParameter("conferma-password");
        String dataNascita=request.getParameter("DataDiNascita");
        String nazione=request.getParameter("Nazione");//TODO risolvere per il numero di telefono
        Date formattedDate = null;


        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dataNascita, formatter);

            formattedDate = Date.valueOf(date);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format: " +dataNascita);

        }
        Utente utente=new Utente(nomeUtente,numeroTelefono,email,password,formattedDate);
        UtenteDao service=new UtenteDao();
        try{
            Sicurezza(utente,confirmPassword,service);
            utente.setPassword(Utils.toHash(utente.getPassword()));
        } catch (Exception e) {

            RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/registrazione.jsp");
            dispatcher.forward(request,response);
            return;
        }
boolean success=service.doSave(utente);
        if(success){
            response.sendRedirect("/Yu_Gi_OH/login");

        }

    }
    private void Sicurezza(Utente utente, String conferma, UtenteDao service){
        ArrayList<String> errori=new ArrayList<>();
        if(!Utils.isValidEmail(utente.getEmail())||utente.getEmail()==null||utente.getEmail().isEmpty()){

            errori.add("Email invalido");
        }
if(!Utils.isValidPassword(utente.getPassword())||utente.getPassword()==null||utente.getPassword().isEmpty()||!utente.getPassword().equals(conferma)){
    errori.add("Password invalido");
}
if(!Utils.isValidUsername(utente.getNomeUtente())||utente.getNomeUtente()==null||utente.getNomeUtente().isEmpty()){
    errori.add("Nome utente invalido");
}
if(Usernameinuso(utente.getNomeUtente(),service)){
    errori.add("Nome in uso");
}
if(emailinuso(utente.getEmail(),service)){
    errori.add("Email in uso");
}
if (!errori.isEmpty()) {
    throw new ValidException(errori);
}



    }
    private boolean Usernameinuso(String username, UtenteDao service){
        return service.doRetrievebyUsername(username)!=null;
    }
    private boolean emailinuso(String email, UtenteDao service){
        return service.doRetrievebyEmail(email)!=null;
    }
}