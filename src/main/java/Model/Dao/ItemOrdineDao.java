package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Bean.ItemOrdine;

public class ItemOrdineDao  extends AbstractDAO {

    public boolean doSave(ItemOrdine orderItems) {

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "INSERT_ORDERITEMS")) {

            ps.setInt(1,Integer.parseInt(orderItems.getId()));
            ps.setInt(2, Integer.parseInt(orderItems.getUtente()));
            ps.setInt(3, Integer.parseInt(orderItems.getNomeCarta()));
            ps.setInt(4, orderItems.getQuantita());
            ps.setFloat(5, orderItems.getPrezzo());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }

    }

    public boolean doUpdate(ItemOrdine orderItems) {

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "UPDATE_ORDERITEMS")) {

            ps.setInt(4, orderItems.getQuantita());
            ps.setFloat(5, orderItems.getPrezzo());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(ItemOrdine orderItems) {

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "DELETE_ORDERITEMS")) {

            ps.setInt(1, Integer.parseInt(orderItems.getId()));
            ps.setInt(2, Integer.parseInt(orderItems.getUtente()));

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public ArrayList<ItemOrdine> doRetrievebyID(String id, String orderId) {
        ArrayList<ItemOrdine> ordini = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ITEM_BY_ID")) {

            ps.setString(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {  // while invece di if
                ItemOrdine ordine = new ItemOrdine();
                ordine.setId(result.getString("id"));
                ordine.setUtente(result.getString("utente"));
                ordine.setNomeCarta(result.getString("nomeCarta"));
                ordine.setQuantita(result.getInt("quantita"));
                ordine.setPrezzo(result.getFloat("prezzo"));
                ordini.add(ordine);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ordini;
    }

}