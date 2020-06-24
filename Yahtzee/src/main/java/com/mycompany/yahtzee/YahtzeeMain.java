/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.yahtzee;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author fien_
 */
public class YahtzeeMain {

    public static void main(String[] args) {

        YahtzeeSpel spel1 = new YahtzeeSpel();
        spel1.spelen();
        spel1.werpen();
        spel1.vasthouden();

    }

}

class YahtzeeSpel {

    Scanner scan = new Scanner(System.in);
    String invoer;
    int dobbelsteen;
    ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
    char[] tussenArray = new char[5];
    int[] vast = {0, 0, 0, 0, 0};
    char vasthouden;

    YahtzeeSpel() {

        for (int i = 0; i < 5; i++) {
            dobbelstenen.add(new Dobbelsteen());
        }

    }

    void spelen() {
        while (true) {
            System.out.println("Gooi met 'enter'");
            invoer = scan.nextLine();

            for (Dobbelsteen stenen : dobbelstenen) {
                //for (int i = 0; i < vast.length; i++) {
                    stenen.waarde = werpen();
                    System.out.println("Aantal ogen " + stenen.waarde);

                
            }
            if (invoer.equals("q")) {
                System.out.println("Je hebt gekozen om te stoppen.");
                break;
            }

            System.out.println("Dit is je worp.");

        }
    }

    int werpen() {

        Random rnd = new Random();
        dobbelsteen = rnd.nextInt(6) + 1;
        //System.out.println("aantal ogen:" + dobbelsteen);
        return dobbelsteen;
    }

    int[] vasthouden() {
        System.out.println("Welke dobbelstenen wil je vasthouden? 1 tot en met 5.");
        invoer = scan.nextLine();
        tussenArray = invoer.toCharArray();

        for (int i = 0; i < tussenArray.length; i++) {
            vast[Character.getNumericValue(tussenArray[i]) - 1] = 1;
        }

        for (int i = 0; i < vast.length; i++) {
            System.out.println(">>" + vast[i]);

        }
        return vast;
    }

}

class Dobbelsteen {

    int waarde;

}

/*int[] vasthouden() {
        int[] vast = {0, 0, 0, 0, 0};
        Scanner two = new Scanner(System.in);
        String input = two.nextLine();
        ArrayList<Integer> lala = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int temp = Character.getNumericValue(ch);
            lala.add(temp);
        }

        for (int i = 0; i < lala.size(); i++)
            if (lala.get(i) != 0)
                vast[lala.get(i)-1] = 1;
                System.out.println(Arrays.toString(vast));
                return vast;
    }*/
