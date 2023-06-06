package it.unitn.prog.lab5;

import java.util.Collections;
import java.util.LinkedList;

public class Mazzo extends LinkedList<Carta> {
    public Mazzo() {
        for (Carta.Seme seme : Carta.Seme.values())
            for (Carta.Valore valore : Carta.Valore.values())
                this.add(new Carta(seme, valore));

        Collections.shuffle(this);
    }

    public void print() {
        for (Carta carta : this)
            System.out.println(carta);
    }
}