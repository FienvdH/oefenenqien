package com.mycompany.mastermind;

public class MastermindMain {

    public static void main(String[] args) {       
        
        MastermindSpel spel1 = new MastermindSpel();        
            
        spel1.Spel();
        
        
    }
}

package com.mycompany.mastermind;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fien_
 *
 *
 */
public class MastermindSpel {

    char c;
    String letter;
    int aantalPlaatsJuist = 0;
    int aantalLettersJuist = 0;
    String invoer;
    Scanner scan = new Scanner(System.in);
    int ac = 0;
    int bc = 0;
    int cc = 0;
    int dc = 0;
    int ec = 0;
    int fc = 0;
    int aa = 0;
    int ba = 0;
    int ca = 0;
    int da = 0;
    int ea = 0;
    int fa = 0;

    ArrayList<String> code = new ArrayList<>();
    ArrayList<String> antwoord = new ArrayList<>();
    ArrayList<String> dubbel = new ArrayList<>();
    ArrayList<String> basis = new ArrayList<>();

    //constructor
    MastermindSpel() {
    }

    //spel zelf
    public void Spel() {

        //code genereren     
        System.out.println("computer genereert code" + this.maakCode());

        // loop blijft vragen om invoer tot spel is afgelopen
        while (aantalPlaatsJuist <= 4) {
            aantalLettersJuist = 0;
            aantalPlaatsJuist = 0;
            System.out.println("Wat zijn volgens jou de vier letters van de code?");
            System.out.println("De code is gegenereerd door uit het rijtje abcdef vier willekeurige letters te kiezen. Letters kunnen meerdere keren voorkomen.");
            System.out.println("Je kan het spel stoppen door een 'q' te typen.");

            //string invoer
            invoer = scan.nextLine();

            //spel beëindigen
            if (invoer.equals("q")) {
                System.out.println("Je hebt aangegeven het spel te willen stoppen. Tot de volgende keer!");
                break;
            }

            //wanneer te korte of te lange code is ingevoerd
            while (invoer.length() < 4 | invoer.length() > 4) {
                System.out.println("Graag vier letters invoeren :)");
                invoer = scan.nextLine();
            }

            //antwoord omzetten naar arraylist
            this.invoerNaarAntwoord(invoer);

            //antwoorden vergelijken met code
            this.checkLettersOpJuistePlaats(this.getAntwoord(), this.maakCode());
            this.checkLettersOpOnjuistePlaats(this.getAntwoord(), this.maakCode(), this.dubbel);

            //gewonnen
            if (aantalPlaatsJuist >= 4) {
                System.out.println("Gefelicteerd, je hebt gewonnen!");
                break;
            }

            //aantal letters op de juiste plaats 
            if (aantalPlaatsJuist == 1) {
                System.out.println("Van de opgegeven letters staat er " + aantalPlaatsJuist + " op de juiste plaats.");
            } else {
                System.out.println("Van de opgegeven letters staan er " + aantalPlaatsJuist + " op de juiste plaats.");
            }

            //aantal letters in de code, maar niet op juiste plaats
            if (aantalLettersJuist == 1) {
                System.out.println("Van de overige letters zit er " + aantalLettersJuist + " in de code, maar niet op de juiste plaats.");
            } else {
                System.out.println("Van de overige letters zitten er " + aantalLettersJuist + " in de code, maar niet op de juiste plaats.");
            }

            //arraylists leegmaken voor de volgende beurt
            antwoord.clear();
            dubbel.clear();
            basis.clear();

            ac = 0;
            bc = 0;
            cc = 0;
            dc = 0;
            ec = 0;
            fc = 0;
            aa = 0;
            ba = 0;
            ca = 0;
            da = 0;
            ea = 0;
            fa = 0;

        }
    }

    //ArrayList met random code maken
    public ArrayList maakCode() {

        while (code.size() < 4) {
            Random rnd = new Random();
            c = (char) (rnd.nextInt(6) + 'a');
            letter = String.valueOf(c);
            code.add(letter);
        }
        return code;
    }

    //invoer naar Arraylist antwoord veranderen
    public void invoerNaarAntwoord(String invoer) {

        int x = 0;

        while (x <= 3) {

            letter = String.valueOf(invoer.charAt(x));
            antwoord.add(letter);
            x++;
        }

    }

    //return antwoord    
    public ArrayList getAntwoord() {

        return antwoord;
    }

    //aantal letters op juiste plaats
    public void checkLettersOpJuistePlaats(ArrayList antwoord, ArrayList code) {

        this.code = code;
        this.antwoord = antwoord;

        for (int i = 0; i < code.size(); i++) {
            if (antwoord.get(i).equals(code.get(i))) {
                this.aantalPlaatsJuist += 1;
            }
        }

    }

    //niet de mooiste manier maar volgens mij heb ik zo het probleem van de dubbele waardes getackeld. 
    public void checkLettersOpOnjuistePlaats(ArrayList antwoord, ArrayList code, ArrayList dubbel) {

        //letters toevoegen aan basisArray
        basis.add("a");
        basis.add("b");
        basis.add("c");
        basis.add("d");
        basis.add("e");
        basis.add("f");

        //per letter tellen in code    
        for (int g = 0; g < code.size(); g++) {

            for (int h = 0; h < basis.size(); h++) {
                if (code.get(g).equals(basis.get(h))) {

                    if (code.get(g).equals(basis.get(0))) {
                        ac++;
                    }
                    if (code.get(g).equals(basis.get(1))) {
                        bc++;
                    }
                    if (code.get(g).equals(basis.get(2))) {
                        cc++;
                    }
                    if (code.get(g).equals(basis.get(3))) {
                        dc++;
                    }
                    if (code.get(g).equals(basis.get(4))) {
                        ec++;
                    }
                    if (code.get(g).equals(basis.get(5))) {
                        fc++;
                    }
                }

            }
        }

        for (int g = 0; g < antwoord.size(); g++) {

            for (int h = 0; h < basis.size(); h++) {
                if (antwoord.get(g).equals(basis.get(h))) {

                    if (antwoord.get(g).equals(basis.get(0))) {
                        aa++;
                    }
                    if (antwoord.get(g).equals(basis.get(1))) {
                        ba++;
                    }
                    if (antwoord.get(g).equals(basis.get(2))) {
                        ca++;
                    }
                    if (antwoord.get(g).equals(basis.get(3))) {
                        da++;
                    }
                    if (antwoord.get(g).equals(basis.get(4))) {
                        ea++;
                    }
                    if (antwoord.get(g).equals(basis.get(5))) {
                        fa++;
                    }
                }

            }
        }

        //letter komt even vaak voor in code als in antwoord
        if (aa != 0 && (aa == ac)) {
            this.aantalLettersJuist = this.aantalLettersJuist + aa;
        }
        if (ba != 0 && (ba == bc)) {
            this.aantalLettersJuist = this.aantalLettersJuist + ba;
        }
        if (ca != 0 && (ca == cc)) {
            this.aantalLettersJuist = this.aantalLettersJuist + ca;
        }
        if (da != 0 && (da == dc)) {
            this.aantalLettersJuist = this.aantalLettersJuist + da;
        }
        if (ea != 0 && (ea == ec)) {
            this.aantalLettersJuist = this.aantalLettersJuist + ea;
        }
        if (fa != 0 && (fa == fc)) {
            this.aantalLettersJuist = this.aantalLettersJuist + fa;
        }

        //wanneer letter in antwoord vaker voorkomt dan code
        if (aa > ac) {
            this.aantalLettersJuist = this.aantalLettersJuist + ac;
        }
        if (ba > bc) {
            this.aantalLettersJuist = this.aantalLettersJuist + bc;
        }
        if (ca > cc) {
            this.aantalLettersJuist = this.aantalLettersJuist + cc;
        }
        if (da > dc) {
            this.aantalLettersJuist = this.aantalLettersJuist + dc;
        }
        if (ea > ec) {
            this.aantalLettersJuist = this.aantalLettersJuist + ec;
        }
        if (fa > fc) {
            this.aantalLettersJuist = this.aantalLettersJuist + fc;
        }

        //wanneer letter in code vaker voorkomt dan antwoord
        if (aa < ac) {
            this.aantalLettersJuist = this.aantalLettersJuist + aa;
        }
        if (ba < bc) {
            this.aantalLettersJuist = this.aantalLettersJuist + ba;
        }
        if (ca < cc) {
            this.aantalLettersJuist = this.aantalLettersJuist + ca;
        }
        if (da < dc) {
            this.aantalLettersJuist = this.aantalLettersJuist + da;
        }
        if (ea < ec) {
            this.aantalLettersJuist = this.aantalLettersJuist + ea;
        }
        if (fa < fc) {
            this.aantalLettersJuist = this.aantalLettersJuist + fa;
        }

        System.out.println("totaal aantal letters die voorkomen in code en antwoord: " + this.aantalLettersJuist);

        aantalLettersJuist = aantalLettersJuist - aantalPlaatsJuist;

    }

}