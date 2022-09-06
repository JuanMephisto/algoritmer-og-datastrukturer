package Exercises.uke34;

import java.util.Random;

public class oppgaver {
    public static void main(String args[]){

        System.out.println("Hei AlgDat!\n");

        int[] a = {97,96};

        int[] b = minmaks(a);

        long sum = fakultet(6);

        int[] x ={3,4};

        int c = maks(x);
        System.out.println("--"+c+"--");

        System.out.println("\nMinste tall: "+b[0] + "\nStørste tall: " +b[1]+"\n\nSum Fakultet: " + sum);
    }


    public static int[] minmaks(int[] a){

        int m1, m2;


        if (a[1] > a[0]) {
            m1 = a[0];
            m2 = a[1];

        } else{
            m1 = a[1];
            m2 = a[0];
        }

        int[] b = {m1, m2};

        return b;
    }


    public static long fakultet(int number){
        if(number >= 1){
            return number*fakultet(number-1);
        }else{
            return 1;
        }
    }

    public static int maks(int[] a) // versjon 3 av maks-metoden
    {
        int sist = a.length - 1; // siste posisjon i tabellen
        int m = 0; // indeks til største verdi
        int maksverdi = a[0]; // største verdi
        int temp = a[sist]; // tar vare på siste verdi
        a[sist] = 0x7fffffff; // legger tallet 2147483647 sist
        for (int i = 0; ; i++) // i starter med 0
            if (a[i] >= maksverdi) // denne blir sann til slutt
            {
                if (i == sist) // sjekker om vi er ferdige
                {
                    a[sist] = temp; // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m; // er siste størst?
                }
                else
                {
                    maksverdi = a[i]; // maksverdi oppdateres
                    m = i; // m oppdateres
                }
            }
    } // maks




}
class Program{
    public static void main(String args[]){


        // main-metoden i class Exercises.uke34.Program skal nå inneholde:
        int n = 1_000_000, antall = 20_000; // tabellstørrelse og gjentagelser
        long tid = 0;                    // for tidsmåling
        int a[] = randPerm(n);           // en permutasjon av 1, . .  n

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) kostnader(a);
        tid = System.currentTimeMillis() - tid;    // medgått tid
        System.out.println("Faste kostnader: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks1(a);  // Programkode 1.1.2
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks1-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks2(a);  // Programkode 1.1.4
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks2-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks3(a);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks3-metoden: " + tid + " millisek");
    }

    public static int kostnader(int[] a)  // legges i class Exercises.uke34.Program
    {
        int m = 0;
        for (int i = 1; i < a.length; i++) {}  // en tom blokk
        return m;
    }

    public static int maks1(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi (m for maks)

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] > a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    } // maks

    public static int maks2(int[] a)   // versjon 2 av maks-metoden
    {
        int m = 0;               // indeks til største verdi
        int maksverdi = a[0];    // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdateres
        }
        return m;   // returnerer indeks/posisjonen til største verdi

    } // maks

    public static int maks3(int[] a)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks

    public static int[] randPerm(int n)  // en versjon som ikke virker
    {
        Random r = new Random();      // en randomgenerator
        int[] a = new int[n];         // en tabell med plass til n tall

        for (int i = 0; i < n; i++)
            a[i] = r.nextInt(n) + 1;    // tabellen fylles med tall

        return a;                     // tabellen returneres
    }
}


