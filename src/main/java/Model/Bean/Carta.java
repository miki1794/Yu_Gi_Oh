package Model.Bean;

public class Carta {
    private int id;
    private String nome;
    private float prezzo;
    private String link;

    public Carta(int id, String nome, float prezzo,String link) {
        this.id = id;
        this.nome = nome;
        this.link=link;
        this.prezzo=prezzo;
    }
    public Carta( String nome, float prezzo,String link) {

        this.nome = nome;
        this.link=link;
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
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
