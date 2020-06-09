package com.mycompany.gooseboard;

import java.util.Random;
import java.util.Scanner;


public class Ganzenbord {

    public static void main(String[] args) {
        
        Spel spel1 = new Spel();

        
    }
}

public class Spel {

    private static List<Speler> spelers;
    

    public Spel() {

        Scanner scan = new Scanner(System.in);

        spelers = new ArrayList<Speler>();
        Speler Speler1 = new Speler("Tinus");
        spelers.add(Speler1);
        Speler Speler2 = new Speler("Donnatella");
        spelers.add(Speler2);
        Speler Speler3 = new Speler("Bruno");
        spelers.add(Speler3);

        while (true) {

            // De spelers spelen hun beurten
            Iterator<Speler> it = spelers.iterator();
            while (it.hasNext()) {
                Speler speler = (Speler) it.next();

                if (speler.getPlaats() < 69) {
                    speler.beurt();
                }
                if (speler.getPlaats() == 131) {
                    speler.beurtWachten();
                }
                if (speler.getPlaats() == 112) {
                    speler.drieBeurtenWachten();
                }
                
                    

            }

        }
    }
}

public class Speler {

    Scanner scan = new Scanner(System.in);
    private int plaats;
    private String naam;
    private int worp;
    private String invoer;
    private int wacht = 0;
    private int wachtGevangenis = 0;
   
    //speler
    public Speler(String naam) {
        this.naam = naam;
        this.plaats = 0;
        
    }

    public void setPlaats(int nieuwePlaats) {
        this.plaats = nieuwePlaats;
    }

    public int getPlaats() {
        return this.plaats;
    }

    public String getNaam() {
        return this.naam;
    }

    //dobbelsteen
    public int dobbelsteen() {
        Random randomGenerator = new Random();        
        worp = randomGenerator.nextInt(6) + 1;            

        System.out.println("Je hebt " + worp + " gegooid.");

        this.plaats = this.plaats + worp;

        return this.plaats;

    }
    
    //nieuwe beurt
    public void beurt() {

        System.out.println(this.getNaam() + " staat op " + this.getPlaats() + ". Gooi met 'g'.");

        invoer = scan.nextLine();

        while (!invoer.equals("g")) {
            System.out.println("Je moet gooien met 'g'. Probeer het nog een keer. ");
            invoer = scan.nextLine();
        }

        if (invoer.equals("g")) {
            this.spelen();
        }

    }
    //verschilende plaatsen
    public void spelen() {

        this.setPlaats(this.dobbelsteen());
        //brug, verder naar 12
        if (this.plaats == 6) {
            this.plaats = 12;
            System.out.println("Brug, je mag 6 stapjes vooruit. Je staat nu op plaats " + this.plaats);

        }
        //herberg, beurt overslaan
        if (this.plaats == 19) {
            //herberg, beurt overslaan

            this.herberg();
        }

        //put, wachten tot andere speler langs komt
        if (this.plaats == 31) {
            //  31, put, Wie hier komt moet er blijven tot een andere speler er komt.
            //Degene die er het eerst was speelt dan verder.
            //nog niet ingesteld
            
        }        
        //doolhof, terug naar 39
        if (this.plaats == 42) {
            this.plaats = 39;
            System.out.println("Je bent verdwaald. Ga terug naar plaats " + this.plaats);
        }
        //52, gevangenis, drie beurten overslaan
        if (this.plaats == 52) {
            this.gevangenis();
        }

        //dood, terug naar start
        if (this.plaats == 58) {
            this.plaats = 0;
            System.out.println("Aan alle goed komt een eind... RIP. Je moet terug naar start. Je staat nu op plaats " + this.plaats);

        }
        //finish
        if (this.plaats == 63) {
            this.finish();

        }
        // te veel gegooid
        if (this.plaats > 63 && this.plaats < 70) {
            int stapTerug = this.plaats - 63;
            System.out.println("Je bent voorbij de finish, je moet " + stapTerug + " stapjes terug.");
            this.plaats = 63 - stapTerug;

        }

        if (this.plaats < 69 && this.plaats != 23) {
            System.out.println(this.getNaam() + " staat nu op " + this.getPlaats() + ".");
            System.out.println("De volgende speler is nu aan de beurt.");
        }

    }

    public void finish() {
        System.out.println("Finish! Je hebt gewonnen!");
        this.plaats = 70;
    }

    public void herberg() {
        System.out.println("Je slaapt een nachtje in de herberg. Sla één beurt over.");
        this.plaats = 131;
    }

    public void beurtWachten() {

        wacht = wacht + 1;
        while (true) {

            if (wacht <= 1) {
                this.plaats = 131;

            }
            if (wacht > 1) {
                this.plaats = 19;
                System.out.println(this.getNaam() + " mag de volgende beurt weer spelen.");
            }
            break;
        }

    }
   

    public void gevangenis() {
        System.out.println("Je zit in de gevangenis. Sla drie beurten over.");
        this.plaats = 112;

    }

    public void drieBeurtenWachten() {

        wachtGevangenis = wachtGevangenis + 1;

        while (true) {
            if (wachtGevangenis < 4) {
                this.plaats = 112;

            }
            if (wachtGevangenis >= 4) {
                this.plaats = 52;
                System.out.println(this.getNaam() + " mag de volgende beurt weer spelen.");
            }
            break;
        }

    }

}