public class MastermindMain {

    public static void main(String[] args) {

        
        MastermindSpel spel1 = new MastermindSpel();
            
        
      
        spel1.Spel();
        
        
    }
}

public class MastermindSpel {

    char c;
    String letter;
    int aantalPlaatsJuist = 0;
    int aantalLettersJuist = 0;
    String invoer;
    Scanner scan = new Scanner(System.in);

    ArrayList<String> code = new ArrayList<>();
    ArrayList<String> antwoord = new ArrayList<>();
    ArrayList<String> dubbel = new ArrayList<>();

    //constructor
    MastermindSpel() {
    }

    //spel zelf
    public void Spel() {

        //code genereren     
        this.maakCode();

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
            while (invoer.length() < 4 | invoer.length() > 4 ){
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

    //Check aantal letters niet op juiste plaats. Werkt nog niet 100%. Voorbeeld fout: Computer genereert code [f, e, b, e].  Antwoord[f, f, f, e]. Uitvoer:
    //Van de opgegeven letters staan er 2 op de juiste plaats.
    //Van de overige letters zit er 1 in de code, maar niet op de juiste plaats.
    //programma kan nog geen rekening houden met meerdere dezelfde letters in de code. 
    public void checkLettersOpOnjuistePlaats(ArrayList antwoord, ArrayList code, ArrayList dubbel) {

        this.antwoord = antwoord;
        this.code = code;
        this.dubbel = dubbel;

        //arraylist aanmaken zonder de dubbele waardes
        for (int i = 0; i < antwoord.size(); i++) {
            if (!dubbel.contains(antwoord.get(i))) {
                dubbel.add(antwoord.get(i));
            }
        }

        //arraylist zonder dubbele waardes vergelijken met de code
        for (int a = 0; a < dubbel.size(); a++) {
            for (int b = 0; b < code.size(); b++) {
                if (dubbel.get(a).equals(code.get(b))) {
                    this.aantalLettersJuist += 1;
                }
            }

        }

        //dubbele telling corrigeren
        this.aantalLettersJuist = this.aantalLettersJuist - this.aantalPlaatsJuist;

    }

}