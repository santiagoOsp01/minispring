package org.example;

import java.lang.reflect.*;


public class reflexion {

    public static void main(String[] args) {
        printMembers("hola".getClass().getConstructors(), "constructores");
        printMembers("hola".getClass().getDeclaredFields(), "campos");
        printMembers("hola".getClass().getDeclaredMethods(), "metodos");
    }
    private static void printMembers(Member[] mbrs, String s) {
        System.out.format("%s:%n", s);
        for (Member mbr : mbrs) {
            if (mbr instanceof Field)
                System.out.format(" %s%n", ((Field)mbr).toGenericString());
            else if (mbr instanceof Constructor)
                System.out.format(" %s%n", ((Constructor)mbr).toGenericString());
            else if (mbr instanceof Method)
                System.out.format(" %s%n", ((Method)mbr).toGenericString());
        }
        if (mbrs.length == 0){
            System.out.format(" -- No %s --%n", s);
        }
        System.out.format("%n");
    }

}
