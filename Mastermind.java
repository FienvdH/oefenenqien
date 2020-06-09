import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fien_
 */
public class MastermindMain {

    public static void main(String[] args) {

        char c;
        String letter;
        int aantalPlaatsJuist = 0;
        int aantalLettersJuist = 0;
        String invoer;
        Scanner scan = new Scanner(System.in);
        char eersteLetter;
        char tweedeLetter;
        char derdeLetter;
        char vierdeLetter;
        String letter1;
        String letter2;
        String letter3;
        String letter4;
        int dubbeleLetters = 0;

        //letters genereren
        ArrayList<String> code = new ArrayList<>();
        ArrayList<String> dubbel = new ArrayList<>();

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

            eersteLetter = invoer.charAt(0);
            letter1 = String.valueOf(eersteLetter);
            antwoord.add(letter1);

            tweedeLetter = invoer.charAt(1);
            letter2 = String.valueOf(tweedeLetter);
            antwoord.add(letter2);

            derdeLetter = invoer.charAt(2);
            letter3 = String.valueOf(derdeLetter);
            antwoord.add(letter3);

            vierdeLetter = invoer.charAt(3);
            letter4 = String.valueOf(vierdeLetter);
            antwoord.add(letter4);
            
            //tellen letters die op de juiste plaats staan
            for (int i = 0; i < code.size(); i++) {
                if (antwoord.get(i).equals(code.get(i))) {
                    aantalPlaatsJuist += 1;
                    
                }
            }
            
            //arraylist aanmaken zonder de dubbele waardes
            for (String element : antwoord) {
                if (!dubbel.contains(element)) {
                    dubbel.add(element);
                }
            }
            
            //arraylist zonder dubbele waardes vergelijken met de code
            for (int a = 0; a < dubbel.size(); a++) {
                for (int b = 0; b < code.size(); b++) {
                    if (dubbel.get(a).equals(code.get(b))) {
                        aantalLettersJuist += 1;
                    }
                }

                
            }
            
            //dubbele telling corrigeren
            aantalLettersJuist = aantalLettersJuist - aantalPlaatsJuist;

            if (aantalPlaatsJuist >= 4) {
                System.out.println("Gefelicteerd, je hebt gewonnen!");
                break;
            }
            
            if (aantalPlaatsJuist == 1) {
                System.out.println("Van de opgegeven letters staat er " + aantalPlaatsJuist + " op de juiste plaats.");
            } else {
                System.out.println("Van de opgegeven letters staan er " + aantalPlaatsJuist + " op de juiste plaats.");
            }
            
            if (aantalLettersJuist == 1) {
                System.out.println("Van de overige letters zit er " + aantalLettersJuist + " in de code, maar niet op de juiste plaats.");
            } else {
                System.out.println("Van de overige letters zitten er " + aantalLettersJuist + " in de code, maar niet op de juiste plaats.");
            }
            antwoord.clear();
            dubbel.clear();

        }
    }
}