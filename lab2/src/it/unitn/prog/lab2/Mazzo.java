package it.unitn.prog.lab2;

import it.unitn.prog.lab2.Carta.Numero;
import it.unitn.prog.lab2.Carta.Seme;

import java.util.LinkedList;
import java.util.Collections;

public class Mazzo extends LinkedList<Carta> {
    public Mazzo() {
        for (Seme seme : Seme.values()) {
            for (Numero numero : Numero.values()) {
                this.add(new Carta(seme, numero));
                this.add(new Carta(seme, numero));
            }
        }
        Collections.shuffle(this);
    }

    /**
     * Stampa le carte formattate
     * @param n numero di carte da stampare
     */
    public void stampa(int n) {
        for (int i=0; i < n; i++) {
            System.out.printf("Carta numero %d: %s\n", i+1, this.get(i));
        }
        for (int i=0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (this.get(i).equals(this.get(j))) {
                    System.out.printf("Hai vinto! %s\n", this.get(i));
                    return;
                }
            }
        }
        System.out.println("Hai perso!");
    }

    public void stampa() {
        stampa(10);
    }
}
