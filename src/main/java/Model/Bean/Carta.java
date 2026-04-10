package Model.Bean;

public class Carta {
    private int id;
    private String nome;
    private float prezzo;

    public Carta(int id, String nome, float prezzo) {
        this.id = id;
        this.nome = nome;

        this.prezzo=prezzo;
    }
    public Carta( String nome, float prezzo) {

        this.nome = nome;

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


    public float getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
}
