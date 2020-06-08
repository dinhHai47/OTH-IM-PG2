package uebung_3_07;

import java.util.Scanner;

public class Primfaktorzerlegung {
    public static void main(String[] args) {
        // user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Geben Sie eine Zahl ein: ");
        long n = sc.nextLong();
        sc.nextLine();
        sc.close();

        // calculate primeFactors
        long[] prime = primeFactors(n);

        // print prime factors
        System.out.print("Die Primfaktorzerlegung von " + n + " ist:");
        // set first number to temp
        long temp = prime[0];
        long potenz = 1;
        for (int i = 1; i < prime.length; i++) {
            if (temp != prime[i]) {
                System.out.print(" " + temp + "^" + potenz + " *");
                temp = prime[i];
                potenz = 1;
            } else {
                potenz++;
            }
        }
        System.out.println(" " + temp + "^" + potenz);
    }

    /**
     * Berechnet die Primfaktoren, aus denen sich die Zahl n zusammensetzt.
     * Multipliziert man diese, ergibt sich die Zahl. Zurueckgegeben werden die
     * Zahlen in einem Array, das soviele Elemente hat wie n Primfaktoren. Sie
     * sind aufsteigend sortiert.
     */
    public static long[] primeFactors(long n) {
		/*
		 * Die Vorgehensweise ist folgende: Aufgrund der Vorgabe, dass das
		 * zur�ckgegebene Array maximal soviele Elemente haben darf wie die Zahl
		 * n Primfaktoren hat, erzeugen wir zunaechst ein "temporaeres" Array tmp,
		 * dessen Laenge durch maxFactors angegeben wird. Dies geschieht aus
		 * einer Ueberlegung zum Speicherverbrauch: Man koennte tmp auch mit der
		 * Laenge n initialisieren, allerdings ist dies aus
		 * Effizienzgesichtspunkten eher suboptimal, da jede Zahl maximal eine
		 * gewisse Anzahl an Primfaktoren haben kann. Da 2 der kleinstmoegliche
		 * Primfaktor ist, ist die Anzahl der Primfaktoren immer kleiner gleich
		 * dem Exponenten der naechst- hoeheren Zweierpotenz. Daraus folgt: n <=
		 * 2^x log(n) <= log (2^x) x >= log (n) / log(2) Mit x als maximaler
		 * Anzahl der Primfaktoren der Zahl n.
		 */

        // Maximale Faktoranzahl ermitteln
        int maxFactors = (int) Math.ceil(Math.log10(n) / Math.log10(2));

        // Temporäres Array erzeugen
        long[] tmp = new long[maxFactors];

        // Zähler der tatsächlichen Faktoranzahl initialisieren
        int anzahlFaktoren = 0;

		/*
		 * Jetzt kommt der Trick der Zerlegung: In einer Zaehlschleife wird
		 * wiederholt von 2 (kleinster Primfaktor) bis n (Zahl) gezaehlt, wobei
		 * bei jedem Durchlauf Ueberprueft wird, ob die Zaehlvariable ganzzahliger
		 * Teiler der Zahl ist. Ist dies der Fall, ist ein neuer Primfaktor
		 * gefunden. Dieser wird in tmp gesichert, und die ganze Schleife wird
		 * "zurueckgesetzt", indem der Zaehler erneut bei 2 (1++) beginnt und n
		 * durch n/Primfaktor ersetzt wird.
		 */
        for (long j = 2; j <= n; j++) {
            // Ist j Primfaktor?
            if (n % j == 0) {
                // Primfaktor sichern und Anzahl der Primfaktoren erhoehen
                tmp[anzahlFaktoren++] = j;
                // n ändern
                n = n / j;
                // j erneut auf den vorherigen Wert setzten (wegen j++)
                j--;
            }
        }
        // Rueckgabearray erzeugen, mit Laenge der tatsaechlichen Anzahl
        // von Primfaktoren
        long[] prf = new long[anzahlFaktoren];
        // Ueberfuehren der Werte des temporaeren Arrays in das
        // Rueckgabearray
        for (int i = 0; i < anzahlFaktoren; i++) {
            prf[i] = tmp[i];
        }
        // Rueckgabe
        return prf;
    }
}