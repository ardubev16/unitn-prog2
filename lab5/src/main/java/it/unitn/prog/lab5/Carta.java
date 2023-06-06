package it.unitn.prog.lab5;

import java.util.Comparator;
import java.util.Objects;

public class Carta implements Comparable {
    static class ComparatorByValore implements Comparator<Carta> {
        @Override
        public int compare(Carta c1, Carta c2) {
//            if (c1.seme.equals(c2.seme))
//                return c1.valore.getPos() - c2.valore.getPos();
//            else
//                return c1.seme.getPos() - c2.seme.getPos();
            return c1.valore.getPos() - c2.valore.getPos();
        }

        @Override
        public String toString() {
            return "ordinamento per Valore";
        }
    }

    static class ComparatorBySeme implements Comparator<Carta> {
        @Override
        public int compare(Carta c1, Carta c2) {
//            if (c1.valore.equals(c2.valore))
//                return c1.seme.getPos() - c2.seme.getPos();
//            else
//                return c1.valore.getPos() - c2.valore.getPos();
            return c1.seme.getPos() - c2.seme.getPos();
        }

        @Override
        public String toString() {
            return "ordinamento per Seme";
        }
    }

    public enum Seme {
        Cuori("C", 1),
        Quadri("Q", 2),
        Fiori("F", 3),
        Picche("P", 4);

        private String seme;
        private int n;

        Seme(String seme, int n) {
            this.seme = seme;
            this.n = n;
        }

        public int getPos() {
            return this.n;
        }

        @Override
        public String toString() {
                return this.seme;
            }
    }

    public enum Valore {
        Asso("A", 1),
        Due("2", 2),
        Tre("3", 3),
        Quattro("4", 4),
        Cinque("5", 5),
        Sei("6", 6),
        Sette("7", 7),
        Otto("8", 8),
        Nove("9", 9),
        Dieci("10", 10),
        Jeck("J", 11),
        Queen("Q", 12),
        King("K", 13);

        private final String valore;
        private final int n;

        Valore(String valore, int n) {
            this.valore = valore;
            this.n = n;
        }

        public int getPos() {
            return this.n;
        }

        @Override
        public String toString() {
            return this.valore;
        }
    }

    private final Seme seme;
    private final Valore valore;

    public Carta(Seme seme, Valore valore) {
        this.seme = seme;
        this.valore = valore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return seme == carta.seme && valore == carta.valore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seme, valore);
    }

    @Override
    public int compareTo(Object o) {
        Carta c = (Carta) o;
        if (this.seme.equals(c.seme))
            return this.valore.getPos() - c.valore.getPos();
        else
            return this.seme.getPos() - c.seme.getPos();
    }

    @Override
    public String toString() {
        return String.format("[%s %s]", this.valore, this.seme);
    }
}