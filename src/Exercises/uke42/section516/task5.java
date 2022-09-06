package Exercises.uke42.section516;

import eksempelklasser.BinTre;

import java.util.StringJoiner;

public class task5 {
    public static void main(String[] args) {
        BinTre<Character> tre = new BinTre<>();

        int[] p = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner i nivåorden
        String v = "EIBGAHKLODNMCJF";                       // verdier i nivåorden
        for (int i = 0; i < p.length; i++) tre.leggInn(p[i],v.charAt(i));

        StringJoiner s = new StringJoiner(",", "[","]");

        tre.nivåorden(c -> { if(c > 'D') s.add(c.toString());});

        String verdier = s.toString();
        System.out.println(verdier);
    }
}
