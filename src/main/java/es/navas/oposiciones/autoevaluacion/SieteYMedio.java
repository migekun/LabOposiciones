public class SieteYMedio {

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
        sumaRecursiva(baraja, target, new ArrayList<Carta>());
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

}
