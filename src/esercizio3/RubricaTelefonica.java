package esercizio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RubricaTelefonica {
    private static Map<String, String> rubrica;

    public RubricaTelefonica() {
        rubrica = new HashMap<>();
    }

    public void inserisciContatto(String nome, String telefono) {
        rubrica.put(nome, telefono);
        System.out.println("Contato aggiunto: " + nome + " " + telefono);
    }

    public void eleiminaContatto(String nome) {
        if (rubrica.containsKey(nome)) {
            rubrica.remove(nome);
            System.out.println(nome + " Rimosso!!");
        } else {
            System.out.println("Nome inesistente bro!");

        }
    }

    public String cercaNomeDaTelefono(String telefono) {
        for (Map.Entry<String, String> entry : rubrica.entrySet()){
        if (entry.getValue().equals(telefono)){
            return entry.getKey();
        }
        }
        return null;
    }
    public String cercaTelefonodaNome(String nome) {
        return rubrica.get(nome);
    }
    public void StampaContatti() {
        if(rubrica.isEmpty())  {
            System.out.println("Rubrica vuota.");
        } else {
            System.out.println("Elenco contatti: ");
            for (Map.Entry<String, String> entry : rubrica.entrySet()){
                System.out.println("Nome: " + entry.getKey() + ", Telefono" + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        RubricaTelefonica rubrica = new RubricaTelefonica();
        Scanner scanner = new Scanner(System.in);
        boolean esci = false;

        while(!esci) {
            System.out.println("\n--- Rubrica Telefonica ---");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Rimuovi contatto");
            System.out.println("3. Cerca nome per telefono");
            System.out.println("4. Cerca telefono per nome");
            System.out.println("5. Stampa tutti i contatti");
            System.out.println("6. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1: //aggiungi contatto
                    System.out.println("inserisci nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("inserisci telefono: ");
                    String telefono = scanner.nextLine();
                    rubrica.inserisciContatto(nome, telefono);
                    break;
                case 2: //rimuovi contatto
                    System.out.println("inserisci il nome del contatto da rimuovere: ");
                    String nomeEliminabile = scanner.nextLine();
                    rubrica.eleiminaContatto(nomeEliminabile);
                    break;
                case 3: // cerca nome
                    System.out.println("inserisci un numero di telefono: ");
                    telefono = scanner.nextLine();
                    String nomeAssociato = rubrica.cercaNomeDaTelefono(telefono);
                    if (nomeAssociato != null) {
                        System.out.println("il numero " + telefono + " appartiene a: " + nomeAssociato);
                    } else {
                        System.out.println("non è tra i tuoi contatti, occhio ai call center!");
                    }
                    break;
                case 4: // cerca telefono
                    System.out.println("inserisci il nome: ");
                    nome = scanner.nextLine();
                    String numeroAssociato = rubrica.cercaTelefonodaNome(nome);
                    if (numeroAssociato != null) {
                        System.out.println("il numero di " + nome + " è " + numeroAssociato);
                    }
                    break;
                case 5:
                    rubrica.StampaContatti();
                    break;
                case 6:
                    esci = true;
                    System.out.println("USCITA DALLA RUBRICA!?");
                default:
                    System.out.println("OOOOPSSS");
                    }
            }
           scanner.close();
        }
    }
