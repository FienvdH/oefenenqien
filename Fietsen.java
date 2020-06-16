package com.mycompany.fiets;

/**
 *
 * @author fien_
 */
public class FietsMain {

    public static void main(String[] args) {

        Fiets sparta = new Fiets("Sparta", "rood", "damesfiets");
        Fietser Tina = new Fietser("Tina", 60, 30);
        
        Tina.fietsen(10);
        sparta.bandLek(true);
        Tina.bandLatenPlakken(sparta);
        Tina.eetMars();
        
        Fietstocht rondjeom = new Fietstocht();
        rondjeom.tochtjeMaken(20, 6, Tina, sparta);

    }

}

public class Fiets {

    private String merk;
    private String kleur;
    private String model;
    boolean lekkeBand;
    
    Fiets(){
    this("Union", "beige", "dames");
            }

    Fiets(String merknaam, String fietsKleur, String modelsoort) {
        merk = merknaam;
        kleur = fietsKleur;
        model = modelsoort;
    }

    boolean bandLek(boolean bandLek) {
        lekkeBand = bandLek;
        System.out.println("Je hebt een lekke band! Je kan niet verder fietsen.");
        return lekkeBand;
    }
    
    boolean bandGePlakt(boolean bandLek) {
        lekkeBand = bandLek;
        return lekkeBand;
    }
}

package com.mycompany.fiets;

/**
 *
 * @author fien_
 */
public class Fietser {

    private String naam;
    private double conditie;
    private double portomonnee;
    

    Fietser(String voornaam, double fitheid, int geld) {
        naam = voornaam;
        conditie = fitheid;
        portomonnee = geld;
    }

    void fietsen(double km) {

        conditie = conditie - ((km / 100) * conditie);

        if (conditie < 5) {
            //System.out.println("Je bent te moe om door te gaan, je valt om.");            
        }

        System.out.println("Je hebt " + km + " km gefietst. Je conditie is " + conditie);

    }

    void zelfBandPlakken(Fiets nieuweFiets) {
        nieuweFiets.bandGePlakt(true);
        conditie = conditie * 0.8;
        System.out.println("Je band is geplakt! Je kan weer verder. Je conditie is " + conditie);

    }

    void bandLatenPlakken(Fiets nieuweFiets) {
        nieuweFiets.bandGePlakt(true);
        portomonnee = portomonnee - 10;
        System.out.println("Je band is geplakt! Je kan weer verder. Je hebt nog " + portomonnee + " euro.");

    }

    void eetMars() {
        conditie = conditie * 1.20;
        portomonnee = portomonnee - 1.20;

        System.out.println("De chocolade doet wonderen, jij kan er weer tegenaan. Je conditie is " + conditie);
        System.out.println("Je hebt nog " + portomonnee + " euro");
    }

}

public class Fietstocht {

    private int lengte;
    private int kwaliteitWegdek;

    Fietstocht() {
    }

    void tochtjeMaken(int afstand, int soortWegdek, Fietser fietser, Fiets fiets) {
        lengte = afstand;
        soortWegdek = kwaliteitWegdek;

        if (afstand < 10) {
            System.out.println("Fietze!");
        }
        if (afstand > 10 && soortWegdek < 5) {
            fiets.bandLek(true);
        }
        if (afstand > 20 && soortWegdek < 10) {
            fiets.bandLek(true);
        }
        if (afstand > 40 && soortWegdek < 15) {
            fiets.bandLek(true);
        }
        if (afstand > 60 && soortWegdek < 20) {
            fiets.bandLek(true);
        }
        if (afstand > 60 && soortWegdek < 20) {
            fiets.bandLek(true);
        }

    }

}
