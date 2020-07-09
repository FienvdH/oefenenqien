/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kermis;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author fien_
 */
class Kermis implements Attracties {

    protected String naam;
    protected double prijs;
    protected int oppervlakte;
    protected Scanner scan = new Scanner(System.in);
    protected String invoer;
    protected boolean GokAttractie = false;

    public static void main(String args[]) {

        Kermis deKermis = new Kermis();
        while (true) {
            deKermis.keuzeMenu();
        }

    }

    void keuzeMenu() {

        Kassa kassa = new Kassa();

        System.out.println("Ben je een bezoeker van de kermis? Kies 1.");
        System.out.println("Wil je weten hoeveel omzet de kermis heeft gedraaid? Kies o.");
        System.out.println("Wil je weten hoeveel kaartjes er zijn verkocht? Kies k.");

        invoer = scan.nextLine();

        switch (invoer) {
            case ("1"):
                this.attractieKiezen();
                break;
            case ("o"):
                this.printOmzet(kassa);
                break;
            case ("k"):
                this.printKaartjes(kassa);
                break;
            default:
                System.out.println("Graag een geldige keuze invoeren.");
        }
        
        kassa.belastingAangifte();

    }

    void attractieKiezen() {

        System.out.println("Kies een attractie 1 tot en met 6");
        invoer = scan.nextLine();

        switch (invoer) {
            case ("1"):
                autootjes.draaien();
                autootjes.setOmzetBotsauto();
                autootjes.setKaartjesBotsauto();
                break;
            case ("2"):
                spinner.draaien();
                spinner.setOmzetSpin();
                spinner.setKaartjesSpin();
                break;
            case ("3"):
                aanDeWand.draaien();
                aanDeWand.setOmzetSpiegelpaleis();
                aanDeWand.setKaartjesSpiegelpaleis();
                break;
            case ("4"):
                spoken.draaien();
                spoken.setOmzetSpookhuis();
                spoken.setKaartjesSpookhuis();
                break;
            case ("5"):
                hamAnanas.draaien();
                hamAnanas.setOmzetHawaii();
                hamAnanas.setKaartjesHawaii();
                break;
            case ("6"):
                laddertje.draaien();
                laddertje.setOmzetLadderklimmen();
                laddertje.setKaartjesLadderklimmen();
                break;
            default:
                System.out.println("Onjuiste keuze, jij mag niet naar de kermis.");

        }
    }

    void draaien() {
        System.out.println("De attractie " + this.naam + " draait.");

    }

    void printOmzet(Kassa kassa) {
        //Kassa kassaOmzet = new Kassa();
        System.out.println("Totale omzet:" + kassa.omzetTotaal);
    }

    void printKaartjes(Kassa kassa) {
        //Kassa kassaKaartjes = new Kassa();
        System.out.println("Totaal aantal kaartjes verkocht: " + kassa.kaartjesTotaal);
    }

}

class Botsauto extends Kermis {

    private double omzetBotsauto = 0;
    private int kaartjesBotsauto = 0;

    Botsauto(String naam) {
        this.naam = naam;
        this.prijs = 2.50;
    }

    void setOmzetBotsauto() {
        omzetBotsauto = omzetBotsauto + this.prijs;
    }

    double getOmzetBotsauto() {
        return omzetBotsauto;
    }

    void setKaartjesBotsauto() {
        kaartjesBotsauto += 1;
    }

    int getKaartjesBotsauto() {
        return kaartjesBotsauto;
    }
}

class Spin extends RisicoVolleAttracties {

    private int kaartjesSpin = 0;
    private double omzetSpin = 0;

    Spin(String naam) {
        this.naam = naam;
        this.prijs = 2.25;
        this.opstellingsKeuring();
    }

    void setOmzetSpin() {
        omzetSpin = omzetSpin + this.prijs;
    }

    double getOmzetSpin() {
        return omzetSpin;
    }

    void setKaartjesSpin() {
        kaartjesSpin += 1;
        if (kaartjesSpin % 3 == 0) {
            draaiBeurten += 1;
            this.onderhoudsBeurt();
        }
    }

    int getKaartjesSpin() {
        return kaartjesSpin;
    }

    void onderhoudsBeurt() {
        if (draaiBeurten >= 5) {
            System.out.println(this.naam + " moet een onderhoudsbeurt krijgen.");
        }
    }
}

class Spiegelpaleis extends Kermis {

    private double omzetSpiegelpaleis = 0;
    private int kaartjesSpiegelpaleis = 0;

    Spiegelpaleis(String naam) {
        this.naam = naam;
        this.prijs = 2.75;
    }

    void setOmzetSpiegelpaleis() {
        omzetSpiegelpaleis = omzetSpiegelpaleis + this.prijs;
    }

    double getOmzetSpiegelpaleis() {
        return omzetSpiegelpaleis;
    }

    void setKaartjesSpiegelpaleis() {
        kaartjesSpiegelpaleis += 1;
    }

    int getKaartjesSpiegelpaleis() {
        return kaartjesSpiegelpaleis;
    }
}

class Spookhuis extends Kermis {

    private double omzetSpookhuis = 0;
    private int kaartjesSpookhuis = 0;

    Spookhuis(String naam) {
        this.naam = naam;
        this.prijs = 3.20;
    }

    void setOmzetSpookhuis() {
        omzetSpookhuis = omzetSpookhuis + this.prijs;
    }

    double getOmzetSpookhuis() {
        return omzetSpookhuis;
    }

    void setKaartjesSpookhuis() {
        kaartjesSpookhuis += 1;
    }

    int getKaartjesSpookhuis() {
        return kaartjesSpookhuis;
    }

}

class Hawaii extends RisicoVolleAttracties {

    private double omzetHawaii = 0;
    private int kaartjesHawaii = 0;

    Hawaii(String naam) {
        this.naam = naam;
        this.prijs = 2.90;
        this.opstellingsKeuring();

    }

    void setOmzetHawaii() {
        omzetHawaii = omzetHawaii + this.prijs;
    }

    double getOmzetHawaii() {
        return omzetHawaii;
    }

    void setKaartjesHawaii() {
        kaartjesHawaii += 1;
        if (kaartjesHawaii % 5 == 0){
        draaiBeurten += 1;
        this.onderhoudsBeurt();
        }
    }

    int getKaartjesHawaii() {
        return kaartjesHawaii;
    }

    void onderhoudsBeurt() {
        if (draaiBeurten >= 10) {
            System.out.println(this.naam + "moet een onderhoudsbeurt krijgen.");
        }
    }
}

class Ladderklimmen extends Kermis implements GokAttractie{

    private double omzetLadderklimmen = 0;
    private int kaartjesLadderklimmen = 0;
    private double kansSpelBelasting;

    Ladderklimmen(String naam) {
        this.naam = naam;
        this.prijs = 5.00;
    }

    void setOmzetLadderklimmen() {
        omzetLadderklimmen = omzetLadderklimmen + this.prijs;
        this.kansSpelBelastingBetalen();
    }

    double getOmzetLadderklimmen() {
        return omzetLadderklimmen;
    }

    void setKaartjesLadderklimmen() {
        kaartjesLadderklimmen += 1;
    }

    int getKaartjesLadderklimmen() {
        return kaartjesLadderklimmen;
    }
    
    public double kansSpelBelastingBetalen(){
        
        kansSpelBelasting = omzetLadderklimmen * .3;
        System.out.println("belasting:" + kansSpelBelasting);    
        return kansSpelBelasting;        
    }
}

class Kassa implements Attracties {

    static double omzetTotaal = autootjes.getOmzetBotsauto() + spinner.getOmzetSpin() + aanDeWand.getOmzetSpiegelpaleis()
            + spoken.getOmzetSpookhuis() + hamAnanas.getOmzetHawaii() + laddertje.getOmzetLadderklimmen();

    static int kaartjesTotaal = autootjes.getKaartjesBotsauto() + spinner.getKaartjesSpin() + aanDeWand.getKaartjesSpiegelpaleis()
            + spoken.getKaartjesSpookhuis() + hamAnanas.getKaartjesHawaii() + laddertje.getKaartjesLadderklimmen();
    
    static double belasting = laddertje.kansSpelBelastingBetalen();
    
    void belastingAangifte(){
        if (kaartjesTotaal % 15  == 0){
            BelastingInspecteur bi = new BelastingInspecteur();
            bi.opBezoekKomen();
        }
    }
    
   

}

abstract class RisicoVolleAttracties extends Kermis {

    int draaiBeurten;

    void opstellingsKeuring() {
        System.out.println("Deze attractie is gekeurd.");
    }

    ;
    abstract void onderhoudsBeurt();
}

class BelastingInspecteur implements Attracties{
    
    void opBezoekKomen(){
        System.out.println("De belastinginspecteur komt op bezoek.");
    }
    
    void attractieChecken(){
    
        ArrayList<Kermis> inspectielijst = new ArrayList<>();
        
        inspectielijst.add(autootjes);
        inspectielijst.add(spinner);
        inspectielijst.add(aanDeWand);
        inspectielijst.add(spoken);
        inspectielijst.add(hamAnanas);
        inspectielijst.add(laddertje);
        
       for(Kermis attr : inspectielijst){
           if (attr.GokAttractie == true){
           this.belastingOphalen(new Kassa());}
       }         
                 
        
        
    }
    
    void belastingOphalen(Kassa kassa){
        
        System.out.println("Totale omzet: " + kassa.omzetTotaal);
        System.out.println("Kansspelbelasting: " + kassa.belasting);
        kassa.omzetTotaal = kassa.omzetTotaal - kassa.belasting;
        System.out.println("Geld in kas na bezoek inspecteur: " + kassa.omzetTotaal);
    }
        
    
}


interface Attracties {

    Botsauto autootjes = new Botsauto("Autootjes");
    Spin spinner = new Spin("Spinner");
    Spiegelpaleis aanDeWand = new Spiegelpaleis("Aan de Wand");
    Spookhuis spoken = new Spookhuis("Spoken");
    Hawaii hamAnanas = new Hawaii("Ham en Ananas");
    Ladderklimmen laddertje = new Ladderklimmen("Laddertje");
}

interface GokAttractie{

    double kansSpelBelastingBetalen();
    boolean GokAttractie = true; 
    
    
}
