//Main method

package com.mycompany.gooseboard;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fien_
 */
public class Ganzenbord {

    public static void main(String[] args) {
        
        Spel spel1 = new Spel();

        
    }
}

//Spel class

package com.mycompany.gooseboard;

import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fien_
 */
public class Spel {

    private static List<Speler> spelers;
    private static List<Speler> inPut;

    public Spel() {

        Scanner scan = new Scanner(System.in);

        inPut = new ArrayList<Speler>();
        spelers = new ArrayList<Speler>();
        
        //spelers aanmaken
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
                
                //als speler niet op bijzondere plek staat
                if (speler.getPlaats() < 69 && speler.zitInDePut() == false) {
                    speler.beurt();
                }
                //in de herberg
                if (speler.getPlaats() == 131) {
                    speler.beurtWachten();
                }
                //in de gevangenis
                if (speler.getPlaats() == 112) {
                    speler.drieBeurtenWachten();
                }
                //in de put
                if (speler.getPlaats() == 31) {
                    
                    inPut.add(speler);
                    speler.valtInDePut(true);
                    //eerste in de put
                    if (inPut.size() < 2) {
                        System.out.println("Je bent in de put gevallen! Wacht tot er iemand langskomt om je te bevrijden");

                    }
                    //tweede in de put, eerste speler is vrij
                    if (inPut.size() > 1 && speler.getBeurtInPut() == 0) {
                        inPut.get(0).valtInDePut(false);
                        inPut.set(0, inPut.get(1));
                        inPut.remove(1);
                        System.out.println("Je bent in de put gevallen!  Wacht tot er iemand langskomt om je te bevrijden");
                        speler.setBeurtInPut(1);

                    }
                    //speler zit in de put, moet wachten
                    if (inPut.size() > 1 && speler.getBeurtInPut() > 0){
                        speler.setBeurtInPut(1);
                        System.out.println(inPut.get(0).getNaam() + " moet nog wachten tot er iemand langskomt.");
                    }

                }

                
            }

        }

    }

}

//Speler class

package com.mycompany.gooseboard;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fien_
 */
public class Speler {

    Scanner scan = new Scanner(System.in);
    private int plaats;
    private String naam;
    private int worp;
    private String invoer;
    private int wacht = 0;
    private int wachtGevangenis = 0;
    private boolean inDePut;
    private int beurtInPut;
   
    //speler
    public Speler(String naam) {
        this.naam = naam;
        this.plaats = 0;
        this.inDePut = false;
        this.beurtInPut = 0;
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
        //Random randomGenerator = new Random();        
        //worp = randomGenerator.nextInt(6) + 1; 
        
        worp = 4;

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

        //put, wachten tot andere speler langs komt, verder uitgewerkt in spel()
        //if (this.plaats == 31) 
            
            
              
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
        //output als beurt voorbij is
        if (this.plaats < 69 && this.plaats != 31) {
            System.out.println(this.getNaam() + " staat nu op " + this.getPlaats() + ".");
            System.out.println("De volgende speler is nu aan de beurt.");
        }

    }
    //finish, uit loop halen
    public void finish() {
        System.out.println("Finish! Je hebt gewonnen!");
        this.plaats = 70;
    }
    //herberg, uit loop halen
    public void herberg() {
        System.out.println("Je slaapt een nachtje in de herberg. Sla één beurt over.");
        this.plaats = 131;
    }
    //speler moet één beurt wachten
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
    //speler valt in de put
    public boolean valtInDePut(boolean gevallen){
        this.inDePut = gevallen;
        return this.inDePut;
    }
    //speler zit in de put
    public boolean zitInDePut(){
        return this.inDePut;
    }
    //teller #beurten in put
    public void setBeurtInPut(int aantalBeurtenInPut){
        this.beurtInPut += aantalBeurtenInPut;
        
    }
    //#beurten in put
    public int getBeurtInPut(){
        return this.beurtInPut;
    }
   
    //gevangenis
    public void gevangenis() {
        System.out.println("Je zit in de gevangenis. Sla drie beurten over.");
        this.plaats = 112;

    }
    //speler moet drie beurten wachten
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