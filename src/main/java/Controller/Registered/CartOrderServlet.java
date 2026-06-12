package Controller.Registered;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Bean.ItemOrdine;
import Model.Bean.Ordine;
import Model.Bean.Utente;
import Model.Dao.ItemOrdineDao;
import Model.Dao.OrdineDao;
import Model.Dao.UtenteDao;

@WebServlet(name = "CartOrder", value = "/CartOrder")
public class CartOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cartOrder.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("=== CART ORDER START ===");

        HttpSession session = request.getSession();
        System.out.println("Session ID: " + session.getId());

        @SuppressWarnings("unchecked")
        Map<String, String> userData = (Map<String, String>) session.getAttribute("map");

        System.out.println("UserData: " + userData);

        if (userData != null) {

            try {
                System.out.println("UserData username: " + userData.get("username"));

                UtenteDao utenteDao = new UtenteDao();
                Utente utente = utenteDao.doRetrievebyUsername(userData.get("username"));

                System.out.println("Utente trovato: " + utente);
                System.out.println("Utente ID: " + utente.getIdUtente());

                Ordine ordine = new Ordine();

                System.out.println("PARAM nome: " + request.getParameter("nome"));

                ordine.setUtente(utente.getIdUtente());
                ordine.setNome(request.getParameter("nome"));
                ordine.setCognome(request.getParameter("cognome"));
                ordine.setVia(request.getParameter("via"));
                ordine.setCivico(request.getParameter("civico"));
                ordine.setCap(request.getParameter("cap"));
                ordine.setPaese(request.getParameter("paese"));
                ordine.setStato("in attesa");
                ordine.setDataOrdine(Date.valueOf(LocalDate.now()));

                @SuppressWarnings("unchecked")
                List<ItemOrdine> carrello = (List<ItemOrdine>) session.getAttribute("cart");

                if (carrello == null || carrello.isEmpty()) {
                    System.out.println("❌ ERRORE: carrello NULL o vuoto");
                    response.getWriter().println("Carrello vuoto.");
                    return;
                }

                float totale = 0;

                for (ItemOrdine item : carrello) {
                    // Nota: Assicurati che se la quantità è > 1, il prezzo rifletta il totale per quell'item.
                    // Se 'prezzo' è il prezzo unitario, qui dovresti fare: totale += (item.getPrezzo() * item.getQuantita());
                    totale += item.getPrezzo();
                }

                System.out.println("TOTALE CALCOLATO: " + totale);

                ordine.setPrezzoTot(totale);

                OrdineDao ordineDao = new OrdineDao();
                ItemOrdineDao itemOrdineDao = new ItemOrdineDao();

                System.out.println("Salvo ordine...");
                ordineDao.doSave(ordine);
                System.out.println("Ordine salvato");

                ArrayList<Ordine> ordini = ordineDao.doRetrievebyUtente(utente.getIdUtente());

                // Compatibilità: usiamo get(size - 1) invece di getLast() per sicurezza su versioni Java precedenti alla 21
                Ordine ultimoOrdine = ordini.get(ordini.size() - 1);

                // Parsing dell'ID in intero.
                // (Se il tuo Bean Ordine restituisce già un int, puoi togliere il parseInt e fare: int ordineId = ultimoOrdine.getId();)
                int ordineId = Integer.parseInt(String.valueOf(ultimoOrdine.getId()));

                System.out.println("ULTIMO ORDINE ID: " + ordineId);

                for (ItemOrdine item : carrello) {
                    System.out.println("Salvo item: " + item.getNomeCarta());

                    // 🔥 MODIFICHE CRITICHE QUI 🔥
                    // 1. Usiamo setOrdineId (chiave esterna) invece di setId (chiave primaria auto increment)
                    item.setOrdineId(ordineId);

                    // 2. Impostiamo l'utente
                    item.setUtente(Integer.parseInt(utente.getIdUtente()));

                    itemOrdineDao.doSave(item);
                    System.out.println("Item salvato con successo!");
                }

                session.removeAttribute("cart");
                System.out.println("Carrello rimosso dalla sessione");

                System.out.println("Redirect a ConfermaOrdine");
                response.sendRedirect("ConfermaOrdine");

            } catch (Exception e) {
                System.out.println("❌ ERRORE GENERALE:");
                e.printStackTrace();
                response.getWriter().println("Errore nell'inserimento dell'ordine.");
            }

        } else {
            System.out.println("❌ UserData NULL -> redirect login");
            response.sendRedirect("login");
        }

        System.out.println("=== CART ORDER END ===");
    }
}