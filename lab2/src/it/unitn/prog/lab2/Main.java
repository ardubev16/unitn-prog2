package it.unitn.prog.lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mazzo mazzo = new Mazzo();
        System.out.print("Inserire il numero di carte da stampare: ");
        try {
            int n = Integer.parseInt(scanner.nextLine());
            mazzo.stampa(n);
        } catch (NumberFormatException ex) {
            mazzo.stampa();
        }
    }
}
