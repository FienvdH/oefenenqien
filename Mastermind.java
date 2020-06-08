import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fien_
 */
public class Mastermind {

    public static void main(String[] args) {

        char c;
        String letter;
        Scanner scan = new Scanner(System.in);
        String invoer;
        char eersteLetter;
        char tweedeLetter;
        char derdeLetter;
        char vierdeLetter;
        String letter1;
        String letter2;
        String letter3;
        String letter4;
        int aantalPlaatsJuist = 0;
        int aantalLettersJuist = 0;

        //letters genereren
        ArrayList<String> code = new ArrayList<>();

        while (code.size() < 4) {
            Random rnd = new Random();
            c = (char) (rnd.nextInt(6) + 'a');
            letter = String.valueOf(c);
            code.add(letter);
        }

        // gekozen letters uitprinten
        for (int i = 0; i < code.size(); i++) {
            System.out.println(code.get(i));
        }

        //arraylist declareren voor het antwoord
        ArrayList<String> antwoord = new ArrayList<>();

        //invoervraag
        while (aantalPlaatsJuist <= 4) {
            aantalLettersJuist = 0;
            aantalPlaatsJuist = 0;
            System.out.println("Wat zijn volgens jou de vier letters?");
            System.out.println("Er wordt alleen naar de eerste vier letters van het antwoord gekeken.");
            System.out.println("Je kan het spel stoppen door een 'q' te typen.");

            //string invoer
            invoer = scan.nextLine();

            if (invoer.equals("q")) {
                System.out.println("Je hebt aangegeven het spel te willen stoppen. Tot de volgende keer!");
                break;
            }

            System.out.println(invoer);

            //invoer omzetten naar losse strings, zodat ze in antwoord kunnen worden opgeslagen. 
            eersteLetter = invoer.charAt(0);
            letter1 = String.valueOf(eersteLetter);
            antwoord.add(letter1);

            System.out.println(antwoord.get(0));

            //vergelijken strings. Methode maken, code is nog veel herhalen. 
            if (code.contains(antwoord.get(0))) {
                aantalLettersJuist = aantalLettersJuist + 1;

            }

            if (code.get(0).equals(antwoord.get(0))) {
                aantalPlaatsJuist = aantalPlaatsJuist + 1;

            }

            tweedeLetter = invoer.charAt(1);
            letter2 = String.valueOf(tweedeLetter);
            antwoord.add(letter2);

            System.out.println(antwoord.get(1));

            if (code.contains(antwoord.get(1))) {
                aantalLettersJuist = aantalLettersJuist + 1;
            }

            if (code.get(1).equals(antwoord.get(1))) {
                aantalPlaatsJuist = aantalPlaatsJuist + 1;
            }

            derdeLetter = invoer.charAt(2);
            letter3 = String.valueOf(derdeLetter);
            antwoord.add(letter3);

            System.out.println(antwoord.get(2));

            if (code.contains(antwoord.get(2))) {
                aantalLettersJuist = aantalLettersJuist + 1;
            }

            if (code.get(2).equals(antwoord.get(2))) {
                aantalPlaatsJuist = aantalPlaatsJuist + 1;
            }

            vierdeLetter = invoer.charAt(3);
            letter4 = String.valueOf(vierdeLetter);
            antwoord.add(letter4);

            System.out.println(antwoord.get(3));

            if (code.contains(antwoord.get(3))) {
                aantalLettersJuist = aantalLettersJuist + 1;
            }

            if (code.get(3).equals(antwoord.get(3))) {
                aantalPlaatsJuist = aantalPlaatsJuist + 1;

            }
            if (aantalPlaatsJuist >= 4) {
                System.out.println("Gefelicteerd, je hebt gewonnen!");
                break;
            }
            if (aantalLettersJuist == 1){
                System.out.println("Van de opgegeven letters zit er " + aantalLettersJuist + " in de code.");
            } else { 
                System.out.println("Van de opgegeven letters zitten er " + aantalLettersJuist + " in de code.");
            }
            
            if (aantalPlaatsJuist == 1){
                System.out.println("Van de opgegeven letters staat er " + aantalPlaatsJuist + " op de juiste plaats.");
            }else {
            System.out.println("Van de opgegeven letters staan er " + aantalPlaatsJuist + " op de juiste plaats.");}
            antwoord.clear();

        }

    }

}