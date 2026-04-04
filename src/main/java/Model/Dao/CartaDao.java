package Model.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import Model.Bean.Carta;
import Model.Bean.Utente;


public class CartaDao extends AbstractDAO {
    public boolean doSave(Carta carta) {
        try{

            Connection connection = getConnection();
            PreparedStatement ps=prepareStatement(connection,"save_carta");
            ps.setString(1, carta.getNome());
            ps.setString(2, carta.getEffetto());
            ps.setString(3, carta.getTipo());
            ps.setInt(4, carta.getAttacco());
            ps.setInt(5, carta.getDifesa());
            ps.setFloat(6, carta.getPrezzo());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    // Aggiorna i dati di un utente esistente
    public boolean doUpdate(Carta carta) {
        try{
            Connection connection=getConnection();
            PreparedStatement ps=prepareStatement(connection,"Update_carta");
            ps.setString(1, carta.getNome());
            ps.setString(2, carta.getEffetto());
            ps.setString(3, carta.getTipo());
            ps.setInt(4, carta.getAttacco());
            ps.setInt(5, carta.getDifesa());
            ps.setFloat(6, carta.getPrezzo());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Elimina una carta dal DB
    public boolean delete(Carta carta) {
        try{
            Connection connection=getConnection();
            PreparedStatement ps=prepareStatement(connection,"Delete_carta");
            ps.setString(1, carta.getNome());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }


    }


    // Recupera tutte le carte
    public List<Carta> doRetrieveAll() {
        List<Carta> CarteList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_ALL_CARTE")) {

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Carta carta = new Carta();
                carta.setNome(result.getString("nome"));
                carta.setEffetto(result.getString("effetto"));
                carta.setTipo(result.getString("tipo"));
              carta.setAttacco(result.getInt("attacco"));
                carta.setDifesa(result.getInt("difesa"));
                carta.setPrezzo(result.getFloat("prezzo"));
                CarteList.add(carta);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return CarteList;
    }

    // Recupera carta tramite nome
    public Carta doRetrievebyName(String nome) {
        Carta carta = null;

        try (Connection connection = getConnection();
             PreparedStatement ps = prepareStatement(connection, "GET_CARTE_BY_NAME")) {

            ps.setString(1, nome);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
               carta= new Carta();
                carta.setNome(result.getString("nome"));
                carta.setEffetto(result.getString("effetto"));
                carta.setTipo(result.getString("tipo"));
                carta.setAttacco(result.getInt("attacco"));
                carta.setDifesa(result.getInt("difesa"));
                carta.setPrezzo(result.getFloat("prezzo"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return carta;

    }

}