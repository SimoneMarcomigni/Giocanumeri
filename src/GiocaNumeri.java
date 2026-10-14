/**
 * Esegue il gioco creando i partecipanti e gestendo la concorrenza dei thread.
 *
 * @author Simone Marcomigni
 * @version 1.0
 */
import java.util.Scanner;
public class GiocaNumeri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Stampa una scritta per l'inizio del gioco
        System.out.println("START");

        long inizio = System.currentTimeMillis();

        // Istanza del primo giocatore
        System.out.println("Inserisci il tuo numero del primo giocatore: ");
        int n = scanner.nextInt();
        Giocatore g1 = new Giocatore("Simone", n);
        Thread t1 = new Thread(g1);

        // Istanza del secondo giocatore
        System.out.println("Inserisci il tuo numero del secondo giocatore: ");
        int n2 = scanner.nextInt();
        Giocatore g2 = new Giocatore("Paolo", n2);
        Thread t2 = new Thread(g2);

        System.out.println("Nome t1: " + t1.getName());
        System.out.println("ID t1: " + t1.getId());
        System.out.println("Stato t1: " + t1.getState());
        System.out.println("Priorità t1: " + t1.getPriority());
        System.out.println("Stato t1: " + t1.isAlive());

        System.out.println("Nome t2: " + t2.getName());
        System.out.println("ID t2: " + t2.getId());
        System.out.println("Stato t2: " + t2.getState());
        System.out.println("Priorità t2: " + t2.getPriority());
        System.out.println("Stato t2: " + t2.isAlive());

        // Li avvii subito entrambi
        t1.start();
        t2.start();
        System.out.println("Nome t1: " + t1.getName());
        System.out.println("ID t1: " + t1.getId());
        System.out.println("Stato t1: " + t1.getState());
        System.out.println("Priorità t1: " + t1.getPriority());
        System.out.println("Stato t1: " + t1.isAlive());

        // Attendi che entrambi finiscano prima di chiudere il programma
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.err.println("errore interruzione dell'attesa");
        }

        long fine = System.currentTimeMillis();
        long durata = fine - inizio;
        System.out.println("Durata gioco: " + durata + "ms");
        System.out.println("Endgame");
    }
}