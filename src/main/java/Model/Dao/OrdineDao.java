package Model.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Bean.Ordine;

public class OrdineDao extends AbstractDAO {


    public boolean doSave(Ordine ordine) {

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "INSERT_ORDINE")) {

            ps.setString(1, ordine.getUtente());
            ps.setString(2, ordine.getStato());
            ps.setDate(3, ordine.getDataOrdine());
            ps.setFloat(4, ordine.getPrezzoTot());
            ps.setString(5, ordine.getNome());
            ps.setString(6, ordine.getCognome());
            ps.setString(7, ordine.getVia());
            ps.setString(8, ordine.getCivico());
            ps.setString(9, ordine.getCap());
            ps.setString(10, ordine.getPaese());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean doUpdate(Ordine ordine) {

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "UPDATE_ORDINE")) {

            ps.setString(1, ordine.getStato());
            ps.setFloat(2, ordine.getPrezzoTot());
            ps.setString(3, ordine.getNome());
            ps.setString(4, ordine.getCognome());
            ps.setString(5, ordine.getVia());
            ps.setString(6, ordine.getCivico());
            ps.setString(7, ordine.getCap());
            ps.setString(8, ordine.getPaese());
            ps.setString(9, ordine.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean updateStato(String id, String stato) {

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "UPDATE_ORDINE_STATO")) {

            ps.setString(1, stato);
            ps.setString(2, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean delete(Ordine ordine) {

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "DELETE_ORDINE")) {

            ps.setString(1, ordine.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public Ordine doRetrieveById(String id) {

        Ordine ordine = null;

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ORDINE_BY_ID")) {

            ps.setString(1, id);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                ordine = new Ordine();
                ordine.setId(result.getString("id"));
                ordine.setUtente(result.getString("utente"));
                ordine.setStato(result.getString("stato"));
                ordine.setDataOrdine(result.getDate("dataOrdine"));
                ordine.setPrezzoTot(result.getFloat("prezzoTot"));
                ordine.setNome(result.getString("nome"));
                ordine.setCognome(result.getString("cognome"));
                ordine.setVia(result.getString("via"));
                ordine.setCivico(result.getString("civico"));
                ordine.setCap(result.getString("cap"));
                ordine.setPaese(result.getString("paese"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ordine;
    }


    public ArrayList<Ordine> doRetrieveByUtente(String utente) {

        ArrayList<Ordine> ordiniList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ORDINI_BY_UTENTE")) {

            ps.setString(1, utente);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Ordine ordine = new Ordine();
                ordine.setId(result.getString("id"));
                ordine.setUtente(result.getString("utente"));
                ordine.setStato(result.getString("stato"));
                ordine.setDataOrdine(result.getDate("dataOrdine"));
                ordine.setPrezzoTot(result.getFloat("prezzoTot"));
                ordine.setNome(result.getString("nome"));
                ordine.setCognome(result.getString("cognome"));
                ordine.setVia(result.getString("via"));
                ordine.setCivico(result.getString("civico"));
                ordine.setCap(result.getString("cap"));
                ordine.setPaese(result.getString("paese"));
                ordiniList.add(ordine);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ordiniList;
    }



    public ArrayList<Ordine> doRetrieveByStato(String stato) {

        ArrayList<Ordine> ordiniList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ORDINI_BY_STATO")) {

            ps.setString(1, stato);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Ordine ordine = new Ordine();
                ordine.setId(result.getString("id"));
                ordine.setUtente(result.getString("utente"));
                ordine.setStato(result.getString("stato"));
                ordine.setDataOrdine(result.getDate("dataOrdine"));
                ordine.setPrezzoTot(result.getFloat("prezzoTot"));
                ordine.setNome(result.getString("nome"));
                ordine.setCognome(result.getString("cognome"));
                ordine.setVia(result.getString("via"));
                ordine.setCivico(result.getString("civico"));
                ordine.setCap(result.getString("cap"));
                ordine.setPaese(result.getString("paese"));
                ordiniList.add(ordine);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ordiniList;
    }


    public ArrayList<Ordine> doRetrieveAll() {

        ArrayList<Ordine> ordiniList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ALL_ORDINI")) {

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Ordine ordine = new Ordine();
                ordine.setId(result.getString("id"));
                ordine.setUtente(result.getString("utente"));
                ordine.setStato(result.getString("stato"));
                ordine.setDataOrdine(result.getDate("dataOrdine"));
                ordine.setPrezzoTot(result.getFloat("prezzoTot"));
                ordine.setNome(result.getString("nome"));
                ordine.setCognome(result.getString("cognome"));
                ordine.setVia(result.getString("via"));
                ordine.setCivico(result.getString("civico"));
                ordine.setCap(result.getString("cap"));
                ordine.setPaese(result.getString("paese"));
                ordiniList.add(ordine);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ordiniList;
    }
}
