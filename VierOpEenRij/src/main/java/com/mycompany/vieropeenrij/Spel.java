/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vieropeenrij;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fien_
 */
public class Spel {

    Scanner invoer = new Scanner(System.in);
    String antwoord;
    int invoerKolom;
    Speler speler;
    char hetBord[][] = new char[7][7];
    boolean kolomVol;
    private int beginner;

    public void beurt(Speler speler) {
        this.speler = speler;
        System.out.println("De speler die met " + speler.getKleur() + " speelt, is aan de beurt");
        this.setAntwoord();
        omzetInvoer(antwoord);
        this.inworpSpeler();

    }

    //random bepalen wie begint 
    int kiesBeginSpeler() {
        Random rnd = new Random();
        beginner = rnd.nextInt(2);
        return beginner;        

    }

    //de speler wordt om een antwoord gevraagd, bij onjuiste invoer moet er opnieuw worden ingevoerd. 
    void setAntwoord() {

        while (true) {
            antwoord = invoer.nextLine().toLowerCase();
            if (antwoord.equals("a") || antwoord.equals("b") || antwoord.equals("c") || antwoord.equals("d") || antwoord.equals("e") || antwoord.equals("f") || antwoord.equals("g")) {
                break;
            }
            if (!antwoord.equals("a") || !antwoord.equals("b") || !antwoord.equals("c") || !antwoord.equals("d") || !antwoord.equals("e") || !antwoord.equals("f") || !antwoord.equals("g")) {
                System.out.println("Voer een letter in A t/m G.");
            }

        }
    }

    //startbord, de hetBord[][] krijgt waarden
    void beginBord() {

        //rijen toevoegen aan het bord
        for (int rij = 0; rij < hetBord.length; rij++) {
            for (int kolom = 0; kolom < hetBord.length; kolom++) {
                hetBord[rij][kolom] = ' ';
            }
        }
        this.printBord();

    }

    //aanpassing op bord na invoer
    void inworpSpeler() {
        //wanneer kolom al vol is. Nog aan passen zodat de speler opnieuw moet invoeren. 
        if (hetBord[1][invoerKolom] != ' ') {
            System.out.println("Deze kolom is al vol! Kies een andere kolom");
            this.volleKolom();
        }
        //'steen' wordt aan het bord toegevoegd.     
        for (int rij = hetBord.length - 1; rij >= 0; rij--) {
            if (hetBord[rij][invoerKolom] == ' ') {
                hetBord[rij][invoerKolom] = speler.getKleur();
                break;
            }
        }

        this.printBord();
    }

    void printBord() {
        //bord wordt uitgeprint
        //eerste rij letters
        for (int rij = 0; rij < 1; rij++) {
            for (int kolom = 0; kolom < hetBord.length; kolom++) {
                System.out.print((char) ('A' + kolom));
                System.out.print(" ");
            }
        }
        //het 'rek'             
        for (int rij = 1; rij < hetBord.length; rij++) {
            System.out.println("");
            for (int kolom = 0; kolom < hetBord.length; kolom++) {
                System.out.print(hetBord[rij][kolom] + "|");
            }
            //de nummers in de laatste kolom
            System.out.print((hetBord.length) - rij);
        }

        //de onderste rand
        System.out.println("");
        System.out.print("- - - - - - -");
        System.out.println("");
    }

    public void omzetInvoer(String antwoord) {

        //invoer van de speler omzetten naar de rij waar het aan toegevoegd moet worden
        switch (antwoord) {
            case "a":
                invoerKolom = 0;
                break;
            case "b":
                invoerKolom = 1;
                break;
            case "c":
                invoerKolom = 2;
                break;
            case "d":
                invoerKolom = 3;
                break;
            case "e":
                invoerKolom = 4;
                break;
            case "f":
                invoerKolom = 5;
                break;
            case "g":
                invoerKolom = 6;
                break;
            default:
                break;
        }
        //System.out.println("invoerrij is " + invoerKolom);

    }

    void volleKolom() {
        this.setAntwoord();
        omzetInvoer(antwoord);
        this.inworpSpeler();
    }

    /*public int getRijInvoer() {
        System.out.println("invoerrij is " + rijInvoer);
        return rijInvoer;
    }*/
}

/*void inworpGeel() {
        System.out.println("De speler die met geel speelt, mag nu gooien.");
        this.bord();
        kleur = 'G';
        antwoord = invoer.nextLine();
        omzetInvoer(antwoord);
    }

    void inworpRood() {
        System.out.println("De speler die met rood speelt, mag nu gooien.");
        this.bord();
        kleur = 'R';
        antwoord = invoer.nextLine();
        omzetInvoer(antwoord);
    }*/

 /*bord[0][0]= ' ' ;
       bord[0][1]= 'a';
       bord[0][2]= ' ';
       bord[0][3]= 'b';
       bord[0][4]= ' ';
       bord[0][5]= 'c';
       bord[0][6]= ' ';
       bord[0][7]= 'd';
       bord[0][8]= ' ';
       bord[0][9]= 'e';
       bord[0][10]= ' ';
       bord[0][11]= 'f';
       bord[0][12]= ' ';
       bord[0][13]= 'g';
       bord[0][14]= ' ';*/

 /*for (int i = 0; i < bord.length; i++){
           System.out.println(">>" + bord[0][i]);
       }*/
//multidimensionale array wordt het bord
/**/
//eerste rij van links naar rechts

/*StringBuilder bord[];
        bord = new StringBuilder[8]; */

 /*StringBuilder sb1 = new StringBuilder(" a b c d e f g ");               
        StringBuilder sb2 = new StringBuilder("| | | | | | | | 6");
        StringBuilder sb3 = new StringBuilder("| | | | | | | | 5");
        StringBuilder sb4 = new StringBuilder("| | | | | | | | 4");
        StringBuilder sb5 = new StringBuilder("| | | | | | | | 3"); 
        StringBuilder sb6 = new StringBuilder("| | | | | | | | 2");
        StringBuilder sb7 = new StringBuilder("| | | | | | | | 1");
        StringBuilder sb8 = new StringBuilder("---------------");*/

 /*bord[0] = sb1;
        bord[1] = sb2;
        bord[2] = sb3;
        bord[3] = sb4;
        bord[4] = sb5;
        bord[5] = sb6;
        bord[6] = sb7;
        bord[7] = sb8;*/

 /*for (int i = 0; i < bord.length; i++){
           System.out.println(bord[i]);}*/

 /*char bord[][] = new char[7][7];
        
        for(int rij = 0; rij < bord.length; rij++){
            for (int kolom = 0; kolom < bord.length; kolom++){
                bord[rij][kolom]=' ';
            }
        }
        
         for(int rij = 0; rij < bord.length; rij++){
            for (int kolom = 0; kolom < bord.length; kolom++){
                System.out.println("|" + bord[rij][kolom]);
            }
        }*/
//public void invoerVraag() {
//this.inworpGeel();
//this.inworpRood();

    //}
