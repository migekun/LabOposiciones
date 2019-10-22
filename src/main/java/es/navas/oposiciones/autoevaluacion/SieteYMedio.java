package es.navas.oposiciones.autoevaluacion;

import java.util.ArrayList;
import java.util.List;

public class SieteYMedio {
/**
https://stackoverflow.com/questions/4632322/finding-all-possible-combinations-of-numbers-to-reach-a-given-sum

https://es.wikipedia.org/wiki/Problema_de_la_suma_de_subconjuntos
*/
public void sieteYMedio() {


        List<Carta> baraja = new ArrayList<Carta>(){
            {
                add(new Carta("1", 1f, Palo.ORO));
                add(new Carta("1", 1f, Palo.BASTO));
                add(new Carta("1", 1f, Palo.ESPADAS));
                add(new Carta("1", 1f, Palo.PALO));
                add(new Carta("2", 2f, Palo.ORO));
                add(new Carta("2", 2f, Palo.BASTO));
                add(new Carta("2", 2f, Palo.ESPADAS));
                add(new Carta("2", 2f, Palo.PALO));
                add(new Carta("3", 3f, Palo.ORO));
                add(new Carta("3", 3f, Palo.BASTO));
                add(new Carta("3", 3f, Palo.ESPADAS));
                add(new Carta("3", 3f, Palo.PALO));
                add(new Carta("4", 4f, Palo.ORO));
                add(new Carta("4", 4f, Palo.BASTO));
                add(new Carta("4", 4f, Palo.ESPADAS));
                add(new Carta("4", 4f, Palo.PALO));
                add(new Carta("5", 5f, Palo.ORO));
                add(new Carta("5", 5f, Palo.BASTO));
                add(new Carta("5", 5f, Palo.ESPADAS));
                add(new Carta("5", 5f, Palo.PALO));
                add(new Carta("6", 6f, Palo.ORO));
                add(new Carta("6", 6f, Palo.BASTO));
                add(new Carta("6", 6f, Palo.ESPADAS));
                add(new Carta("6", 6f, Palo.PALO));
                add(new Carta("7", 7f, Palo.ORO));
                add(new Carta("7", 7f, Palo.BASTO));
                add(new Carta("7", 7f, Palo.ESPADAS));
                add(new Carta("7", 7f, Palo.PALO));
                add(new Carta("S", 0.5f, Palo.ORO)); //10
                add(new Carta("S", 0.5f, Palo.BASTO));
                add(new Carta("S", 0.5f, Palo.ESPADAS));
                add(new Carta("S", 0.5f, Palo.PALO));
                add(new Carta("C", 0.5f, Palo.ORO));//11
                add(new Carta("C", 0.5f, Palo.BASTO));
                add(new Carta("C", 0.5f, Palo.ESPADAS));
                add(new Carta("C", 0.5f, Palo.PALO));
                add(new Carta("R", 0.5f, Palo.ORO));//12
                add(new Carta("R", 0.5f, Palo.BASTO));
                add(new Carta("R", 0.5f, Palo.ESPADAS));
                add(new Carta("R", 0.5f, Palo.PALO));
            }
        };

        suma(baraja, 7.5f);
    }

    private static void suma(List<Carta> baraja, float target) {
        sumaRecursiva(baraja, target, new ArrayList<>());
    }

    private static void sumaRecursiva(List<Carta> baraja, float objetivo, List<Carta> barajaParcial) {
        float totalParcial = 0;

        for (Carta carta: barajaParcial) {
            totalParcial += carta.getValor();
        }
        if (objetivo == totalParcial) {
            for (Carta carta: barajaParcial) {
                System.out.print(carta.toString(true)+" ");
            }
            System.out.println("");
        } else if(totalParcial >= objetivo) {
            return;
        }
        for (int i = 0; i < baraja.size(); i++) {
            List<Carta> remaining = new ArrayList<>();
            Carta carta = baraja.get(i);
            for (int j = i + 1; j < baraja.size(); j++) {
                remaining.add(baraja.get(j));
            }

            List<Carta> partial_rec = new ArrayList<>(barajaParcial);
            partial_rec.add(carta);
            sumaRecursiva(remaining, objetivo, partial_rec);
        }
    }

    enum Palo {
        PALO,
        ORO,
        BASTO,
        ESPADAS
    }

    public class Carta {
        private String nombre;
        private float valor;
        private Palo palo;

        public Carta(String nombre, float valor, Palo palo) {
            this.nombre = nombre;
            this.valor = valor;
            this.palo = palo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public float getValor() {
            return valor;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }

        public Palo getPalo() {
            return palo;
        }

        public void setPalo(Palo palo) {
            this.palo = palo;
        }

        public String toString(boolean simple) {
            return simple ? nombre + "-" + palo.name().substring(0, 1) : "Carta{" +
                    "nombre='" + nombre + '\'' +
                    ", valor=" + valor +
                    ", palo=" + palo +
                    '}';
        }
    }

}
