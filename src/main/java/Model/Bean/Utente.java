
package Model.Bean;


import java.math.BigDecimal;
import java.sql.Date;

public class Utente {
    private int idUtente;
   private String nomeUtente;
   private String numeroTelefono;
    private String email;
    private String password;
    private Date dataNascita;
    private String ruolo;


    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }




    // Costruttori
    public Utente() {

    }

    public Utente( String nomeUtente, String numeroTelefono, String email, String password, Date dataNascita) {

        this.nomeUtente = nomeUtente;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.password = password;
        this.dataNascita = dataNascita;
        this.ruolo = "base";
    }

    public Utente(int idUtente, String nomeUtente, String numeroTelefono, String email, String password, Date dataNascita) {
        this.idUtente = idUtente;
        this.nomeUtente = nomeUtente;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.password = password;
        this.dataNascita = dataNascita;
        this.ruolo = "base";
    }

}
