package esercizio2;

import java.util.*;

public class Esercizio2 {

    public static List<Integer> generaListaCasuale(int n) {
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lista.add(random.nextInt(1001));
        }
        Collections.sort(lista);
        return lista;
    }

    public static List<Integer> raddoppiaLista(List<Integer> lista) {
        List<Integer> nuovaLista = new ArrayList<>(lista);
        List<Integer> nuovaListaInvertita = new ArrayList<>(lista);
        Collections.reverse(nuovaListaInvertita);
        nuovaLista.addAll(nuovaListaInvertita);
        return nuovaLista;
    }

    public static void stampaPosizioni(List<Integer> lista, boolean pari) {
        System.out.println(pari ? "Valore in posizione pari" : "Valore in posizione dispari");

        for (int i = 0; i < lista.size(); i++) {
            if (pari && i %2==0){
                System.out.println(lista.get(i));
            } else if (!pari && i %2 !=0) {
                System.out.println(lista.get(i));
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero intero: ");
        int numero = scanner.nextInt();

        //funzione 1
        List<Integer> listaCasuale = generaListaCasuale(numero);
        System.out.println("Lista ordinata di numeri casuali: " + listaCasuale);

        //funzione2
        List<Integer> listaRaddoppiata = raddoppiaLista(listaCasuale);
        System.out.println("Lista raddoppiata e invertita: " + listaRaddoppiata);

        //funzione 3
        System.out.println("Vuoi vedere i valori in posizione pari? (true/false): ");
        boolean pari = scanner.nextBoolean();
        stampaPosizioni(listaRaddoppiata, pari);
    }
}
