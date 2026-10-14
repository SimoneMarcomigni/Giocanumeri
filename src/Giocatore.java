import static java.lang.Thread.sleep;

/**
 * @see UdA n. 1: Esercitazione n. 1 - Giocanumeri
 * @author monica ciuchetti
 */
import java.util.Scanner;
public class Giocatore implements Runnable {
    String nome;
    private String parola;
    private int punteggio;
    private int numero;

    /**
     *
     * @param nome nome del Giocatore
     */
    public Giocatore(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;

    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    /**
     * gioca, metodo che implementa la logica del gioco e calcola il punteggio
     */
    public void gioca() {
        long inizio = System.currentTimeMillis();
        int contatore = 19;
        String parola = "staccionata";
        setParola(parola);

        for (int i = 0; i < contatore; i++) {
            System.out.println("Giocatore : " + nome + " i: " + i);
            try{
                Thread.sleep(1);
            } catch (InterruptedException e){
                System.err.println("Errore nella transizione running-sleeping");
            }


        }

        int lunghezza = parola.length();
        punteggio = numero/lunghezza;
        setPunteggio(punteggio);
        long fine = System.currentTimeMillis();
        long durata = fine - inizio;
        System.out.println("Giocatore : " + nome + " parola: " + getParola() + " punteggio: " + punteggio + " durata " + nome + ": " + durata + "ms");
    }

    public void comunica() {
    }

    @Override
    public void run() {
        gioca();
    }
}