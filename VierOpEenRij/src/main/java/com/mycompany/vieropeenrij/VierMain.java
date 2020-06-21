/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vieropeenrij;

import java.util.Random;

/**
 *
 * @author fien_
 */
public class VierMain {

    public static void main(String[] args) {

        int beginner;
        Spel spel1 = new Spel();
        Speler rood = new Speler('R');
        Speler geel = new Speler('G');

        //print beginwaardes bord
        spel1.beginBord();

        beginner = spel1.kiesBeginSpeler();

        if (beginner == 0) {
            while (true) {
                spel1.beurt(rood);
                spel1.beurt(geel);
            }
        }

        if (beginner == 1) {
            while (true) {
                spel1.beurt(geel);
                spel1.beurt(rood);
            }
        }

    }
}
