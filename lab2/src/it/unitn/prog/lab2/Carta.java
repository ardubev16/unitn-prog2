package it.unitn.prog.lab2;

import java.util.Objects;

import static java.lang.String.format;

public class Carta {
    enum Numero {
        A("Asso"),
        _2("2"),
        _3("3"),
        _4("4"),
        _5("5"),
        _6("6"),
        _7("7"),
        _8("8"),
        _9("9"),
        _10("10"),
        J("Jack"),
        Q("Queen"),
        K("King");

        final private String numero;

        private Numero(String numero) { this.numero = numero; }

        @Override
        public String toString() {
            return this.numero;
        }
    }

    enum Seme {
        C("Cuori"),
        Q("Quadri"),
        F("Fiori"),
        P("Picche");

        final private String seme;

        private Seme(String seme) { this.seme = seme; }

        @Override
        public String toString() {
            return this.seme;
        }
    }

    final private Seme seme;
    final private Numero numero;

    public Carta(Seme seme, Numero numero) {
        this.seme = seme;
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return seme == carta.seme && numero == carta.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seme, numero);
    }

    @Override
    public String toString() {
        return format("%s di %s", this.numero, this.seme);
    }
}
