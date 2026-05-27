package Model.Dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Bean.Ordine;

public class OrdineDao extends AbstractDAO {

    public Ordine doRetrievebyID(String id) {
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
    }}