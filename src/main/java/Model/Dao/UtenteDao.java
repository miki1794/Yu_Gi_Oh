package Model.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Bean.Utente;
import Model.Util.DBManager;


public class UtenteDao extends AbstractDAO {

    // Salva un nuovo utente nel DB
    public boolean doSave(Utente utente) {
       try{

           Connection connection = getConnection();
           PreparedStatement ps=prepareStatement(connection,"save_utente");
           ps.setString(1, utente.getNomeUtente());
           ps.setString(2, utente.getEmail());
           ps.setString(3, utente.getPassword());
           ps.setDate(4, utente.getDataNascita());
           ps.setString(5, utente.getNumeroTelefono());
           ps.setString(6, utente.getRuolo());
           int rowsAffected = ps.executeUpdate();
           return rowsAffected > 0;
       } catch (SQLException e) {
           System.out.println(e.getMessage());
        return false;
       }

    }

    // Aggiorna i dati di un utente esistente
    public boolean doUpdate(Utente utente) {
        try{
            Connection connection=getConnection();
            PreparedStatement ps=prepareStatement(connection,"Update_utenti");
            ps.setString(1, utente.getNomeUtente());
            ps.setString(2, utente.getEmail());
            ps.setString(3, utente.getPassword());
            ps.setDate(4, utente.getDataNascita());
            ps.setString(5, utente.getNumeroTelefono());
            ps.setString(6, utente.getRuolo());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
           return false;
        }
    }

    // Elimina un utente dal DB
    public boolean delete(Utente utente) {
        try{
            Connection connection=getConnection();
            PreparedStatement ps=prepareStatement(connection,"Delete_utenti");
            ps.setString(1, utente.getNomeUtente());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }


    }

    // Recupera un utente tramite ID
    public Utente doRetrieveById(String id) {

            Utente utente = null;

            try (Connection connection = getConnection();
                 PreparedStatement ps = prepareStatement(connection, "GET_USER_BY_ID")) {

                ps.setString(1, id);
                ResultSet result = ps.executeQuery();

                if (result.next()) {
                    utente= new Utente();
                    utente.setNomeUtente(result.getString("username"));
                    utente.setEmail(result.getString("email"));
                    utente.setPassword(result.getString("password"));
                    utente.setDataNascita(result.getDate("DataDiNascita"));
                    utente.setNumeroTelefono(result.getString("NumeroDiTelefono"));
                    utente.setRuolo(result.getString("tipo"));
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return utente;


        }

    // Recupera tutti gli utenti
    public List<Utente> doRetrieveAll() {
        List<Utente> utenteList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ALL_USERS")) {

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Utente utente = new Utente();
                result.getString("username");
                result.getString("password");
                result.getString("email");
                result.getDate("DataDiNascita");
                result.getString("NumeroDiTelefono");
                result.getString("tipo");
                utenteList.add(utente);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return utenteList;
    }


    // Recupera un utente tramite email
    public Utente doRetrievebyEmail(String email) {

        Utente utente = null;

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_USER_BY_ID")) {

            ps.setString(1, email);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                utente= new Utente();
                utente.setNomeUtente(result.getString("username"));
                utente.setEmail(result.getString("email"));
                utente.setPassword(result.getString("password"));
                utente.setDataNascita(result.getDate("DataDiNascita"));
                utente.setNumeroTelefono(result.getString("NumeroDiTelefono"));
                utente.setRuolo(result.getString("tipo"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return utente;


    }



    // Recupera un utente tramite username
    public Utente doRetrievebyUsername(String username) {
        Utente utente = null;

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_USER_BY_USERNAME")) {

            ps.setString(1, username);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                utente= new Utente();
                utente.setNomeUtente(result.getString("username"));
                utente.setEmail(result.getString("email"));
                utente.setPassword(result.getString("password"));
                utente.setDataNascita(result.getDate("DataDiNascita"));
                utente.setNumeroTelefono(result.getString("NumeroDiTelefono"));
                utente.setRuolo(result.getString("tipo"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return utente;

    }
}