/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.yahtzee;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author fien_
 */
public class YahtzeeMain {

    public static void main(String[] args) {

        YahtzeeSpel spel1 = new YahtzeeSpel();
        spel1.spelen();


    }

}

class YahtzeeSpel {

    Scanner scan = new Scanner(System.in);
    String invoer;
    int dobbelsteen;
    ArrayList<Dobbelsteen> dobbelstenen = new ArrayList();
    char[] tussenArray = new char[5];
    int[] vast = {0, 0, 0, 0, 0};
    char vasthouden;
    Worp worpResultaat = new Worp();
    ArrayList<Speler> spelers = new ArrayList();

    YahtzeeSpel() {

        //aanmaken 5 dobbelstenen    
        for (int i = 0; i < 5; i++) {
            dobbelstenen.add(new Dobbelsteen());
        }

    }

    void spelen() {

        //spelers aanmaken
        spelers.add(new Speler("Jut"));
        spelers.add(new Speler("Jul"));
        spelers.add(new Speler("Theo"));
        spelers.add(new Speler("Thea"));

        while (true) {

            Iterator<Speler> it = spelers.iterator();
            while (it.hasNext()) {
                Speler speler = (Speler) it.next();
                 
                System.out.println(speler.getNaam() + " is aan de beurt.");
                System.out.println("Gooi met Enter (eerste beurt)");
                invoer = scan.nextLine();
                // er wordt alleen gegooid als op enter wordt gedrukt    
                if (invoer.isEmpty()) {
                    this.eersteWorp();
                    //print uitslagArray
                    worpResultaat.worpPrinten();
                    //vraagt welke posities moeten worden vastgehouden
                    this.vasthouden();
                    //tweede worp
                    this.tweedeWorp();
                    worpResultaat.worpPrinten();
                    //voegt resultaat toe aan arraylist
                    this.geschiedenisSchrijven(speler);
                    System.out.println("Dit was de beurt van " + speler.getNaam());
                    System.out.println("De volgende speler is aan de beurt");
                }

                // q stopt het spel
                if (invoer.equals("q")) {
                    System.out.println("Je hebt gekozen om te stoppen.");
                    break;
                }
                //er wordt opnieuw om invoer gevraagd bij ongeldige invoer
                if (!invoer.isEmpty() && !invoer.equals("q")) {
                    System.out.println("Ongeldige invoer, gooi met Enter of stop met 'q'");
                }

            }

        }
    }
//gooit de dobbelsteen

    int werpen() {

        Random rnd = new Random();
        dobbelsteen = rnd.nextInt(6) + 1;
        return dobbelsteen;
    }

//eerste worp
    void eersteWorp() {
        //zorgt ervoor dat elke dobbelsteen een waarde krijgt
        for (Dobbelsteen stenen : dobbelstenen) {
            stenen.waarde = werpen();
        }
        //voegt de worpuitslag toe aan de array die uitgeprint wordt. 
        this.toevoegenArray();

    }

    //zorgt ervoor dat de niet-vastgezette dobbelstenen nogmaals gegooid worden
    void tweedeWorp() {
        //zet de resultaat Array weer terug naar 0;
        for (int i = 0; i < worpResultaat.uitslagArray.length; i++) {
            worpResultaat.uitslagArray[i] = 0;
        }

        System.out.println("Gooi met Enter (tweede beurt)");
        invoer = scan.nextLine();
        // er wordt alleen gegooid als op enter wordt gedrukt    
        if (invoer.isEmpty()) {
            for (int i = 0; i < vast.length; i++) {
                //alleen als de waarde niet is vastgehouden, wordt er gegooid
                if (vast[i] == 0) {
                    dobbelstenen.get(i).waarde = werpen();

                }
            }
            this.toevoegenArray();
        }
        if (!invoer.isEmpty()) {
            System.out.println("Je kan alleen gooien met Enter");
        }

        for (int i = 0; i < vast.length; i++) {
            vast[i] = 0;
        }

    }

    //bepaald welke dobbelstenen worden vastgehouden
    int[] vasthouden() {
        System.out.println("");
        System.out.println("Welke dobbelstenen wil je vasthouden? Kies 1 tot en met 5.");
        //invoer van string wordt omgezet naar char[]
        invoer = scan.nextLine();
        System.out.println("Je wil de dobbelstenen op de volgende posities vasthouden: " + invoer);
        tussenArray = invoer.toCharArray();

        //haalt de nummers uit de char array en vertaalt dit naar de juiste indexpositie in de vast[]
        for (int i = 0; i < tussenArray.length; i++) {
            vast[Character.getNumericValue(tussenArray[i]) - 1] = 1;
        }

        //veranderd de 0 naar 1 wanneer de dobbelsteen moet worden vastgezet, blokkeerarray
        for (int i = 0; i < vast.length; i++) {

        }
        return vast;
    }

    void toevoegenArray() {

        //voegt de dobbelsteen toe aan de uitslagArray.
        for (int i = 0; i < dobbelstenen.size(); i++) {
            //System.out.println("<<" + dobbelstenen.get(i).waarde);
            worpResultaat.uitslagArray[i] = dobbelstenen.get(i).waarde;
        }

    }

    void geschiedenisSchrijven(Speler speler
    ) {
        worpResultaat.uitslagArray = worpResultaat.getResultaat();
        speler.worpgeschiedenis.add(worpResultaat);
        System.out.println(">>" + speler.worpgeschiedenis.size());

    }

}

class Dobbelsteen {

    //dobbelsteen heeft een waarde
    int waarde;

}

class Worp {

    int[] uitslagArray = new int[5];

    Worp() {
        int[] uitslagArray;

    }

    //print de worpuitslag
    void worpPrinten() {
        System.out.println("Je dobbelstenen zijn: ");
        for (int i = 0; i < uitslagArray.length; i++) {
            System.out.print(uitslagArray[i] + " ");
        }
        System.out.println("");

    }

    int[] getResultaat() {
        return uitslagArray;
    }

}

class Speler {

    ArrayList<Worp> worpgeschiedenis = new ArrayList();
    String naam;

    Speler(String spelernaam) {
        ArrayList<Worp> worpgeschiedenis;
        naam = spelernaam;
    }

    String getNaam() {
        return naam;
    }

}
