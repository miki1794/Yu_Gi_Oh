package Model.Bean;

public class Carta {
    private int id;
    private String nome;
    private String effetto;
    private String tipo;
    private int attacco;
    private int difesa;
    private float prezzo;

    public Carta(int id, String nome, String effetto, String tipo, int attacco, int difesa,float prezzo) {
        this.id = id;
        this.nome = nome;
        this.effetto = effetto;
        this.tipo =tipo;
        this.attacco = attacco;
        this.difesa = difesa;
        this.prezzo=prezzo;
    }
    public Carta( String nome, String effetto, String tipo, int attacco, int difesa,float prezzo) {

        this.nome = nome;
        this.effetto = effetto;
        this.tipo = tipo;
        this.attacco = attacco;
        this.difesa = difesa;
        this.prezzo=prezzo;
    }


    public Carta() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEffetto() {
        return effetto;
    }

    public void setEffetto(String effetto) {
        this.effetto = effetto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public int getDifesa() {
        return difesa;
    }

    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
}
