package esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Esercizio1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il numero di elementi: ");
        int numeroElementi = scanner.nextInt();
        scanner.nextLine();

        Set<String> paroleDistinte = new HashSet<>();
        Set<String> paroleDuplicate = new HashSet<>();

        System.out.println("Inserisci " + numeroElementi + " parole:" );
        for (int i = 0; i < numeroElementi; i++) {
            System.out.println("Parola " + (i+1) + " :");
            String parola = scanner.nextLine();

            if (!paroleDistinte.add(parola)) {
                paroleDuplicate.add(parola);
        }

        }

        paroleDistinte.removeAll(paroleDuplicate);

        System.out.println("\nParole duplicate: ");
        if(paroleDuplicate.isEmpty()) {
            System.out.println("Nessuna parola duplicata.");
        }else{
            for(String parola: paroleDuplicate) {
                System.out.println(parola);
            }
        }
        System.out.println("\nNumero di parole distinte: " + paroleDistinte.size());
        System.out.println("\nElenco delle parole distinte: ");

        for (String parola: paroleDistinte) {
            System.out.println(parola);
        }
        scanner.close();
    }

}
