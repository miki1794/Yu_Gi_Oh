package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Bean.ItemOrdine;

public class ItemOrdineDao extends AbstractDAO {

    public boolean doSave(ItemOrdine item) {

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "INSERT_ORDERITEMS")) {

            // 🔥 ORDINE ID (OBBLIGATORIO)
            ps.setInt(1, item.getOrdineId());

            ps.setInt(2, item.getUtente());

            ps.setString(3, item.getNomeCarta());

            ps.setInt(4, item.getQuantita());

            ps.setFloat(5, item.getPrezzo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("doSave ERROR: " + e.getMessage());
            return false;
        }
    }

    public boolean doUpdate(ItemOrdine item) {

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "UPDATE_ORDERITEMS")) {

            ps.setInt(1, item.getQuantita());
            ps.setFloat(2, item.getPrezzo());
            ps.setInt(3, item.getOrdineId());
            ps.setInt(4, item.getUtente());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("doUpdate ERROR: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(ItemOrdine item) {

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "DELETE_ORDERITEMS")) {

            ps.setInt(1, item.getOrdineId());
            ps.setInt(2, item.getUtente());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("delete ERROR: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<ItemOrdine> doRetrieveByID(String id, String orderId) {
        ArrayList<ItemOrdine> ordini = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ITEM_BY_ID")) {

            // Imposta l'id come stringa, esattamente come richiesto
            ps.setString(1, id);

            // Faccio notare che "orderId" è tra i parametri del metodo ma non viene
            // passato al PreparedStatement. Se la tua query in XML lo richiede,
            // dovrai aggiungere: ps.setString(2, orderId);

            ResultSet result = ps.executeQuery();

            while (result.next()) {  // while invece di if, come richiesto
                ItemOrdine ordine = new ItemOrdine();

                // I setter usano String come da tuo snippet
                ordine.setId(Integer.parseInt(result.getString("ordine_id")));
                ordine.setUtente(Integer.parseInt(result.getString("utente")));
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

    public ArrayList<ItemOrdine> doRetrieveByOrdineId(int ordineId) {

        ArrayList<ItemOrdine> items = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ITEM_BY_ORDINE")) {

            ps.setInt(1, ordineId);

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                ItemOrdine item = new ItemOrdine();

                item.setId(result.getInt("id"));
                item.setOrdineId(result.getInt("ordine_id"));
                item.setUtente(result.getInt("utente"));
                item.setNomeCarta(result.getString("nomeCarta"));
                item.setQuantita(result.getInt("quantita"));
                item.setPrezzo(result.getFloat("prezzo"));

                items.add(item);
            }

        } catch (SQLException e) {
            System.out.println("retrieve ERROR: " + e.getMessage());
        }

        return items;
    }
}