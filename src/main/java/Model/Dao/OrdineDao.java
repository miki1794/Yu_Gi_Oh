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
             PreparedStatement ps = prepareStatement(connection, "INSERT_ORDER")) {

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
             PreparedStatement ps = prepareStatement(connection, "UPDATE_ORDER")) {

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

    public boolean delete(Ordine ordine) {
        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "DELETE_ORDER")) {

            ps.setString(1, ordine.getId());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Ordine doRetrieveById(String id) throws SQLException {
        Ordine ordine = null;

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ORDER_BY_ID")) {

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

    public ArrayList<Ordine> doRetrieveAll() {
        ArrayList<Ordine> ordiniList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ALL_ORDERS")) {

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

    public ArrayList<Ordine> doRetrievebyUtente(String utente) {
        ArrayList<Ordine> ordiniList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ORDERS_BY_USER")) {

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

    public ArrayList<Ordine> doRetrievebyStato(String stato) {
        ArrayList<Ordine> ordiniList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ORDER_BY_STATO")) {

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

    public boolean updateOrdineStato(int ordineId, String stato) {
        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "UPDATE_ORDER_STATUS")) {

            ps.setString(1, stato);
            ps.setInt(2, ordineId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}