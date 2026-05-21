package Model.Bean;

public class ItemOrdine {
    private String id;
    private String Utente;
    private String nomeCarta;
    private int quantita;
    private float prezzo;

    public ItemOrdine(String id, String utente, String nomeCarta, int quantita, float prezzo) {
        this.id = id;
        Utente = utente;
        this.nomeCarta = nomeCarta;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    public ItemOrdine() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUtente() {
        return Utente;
    }

    public void setUtente(String utente) {
        Utente = utente;
    }

    public String getNomeCarta() {
        return nomeCarta;
    }

    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
}
