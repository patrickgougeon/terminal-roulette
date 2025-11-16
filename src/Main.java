import modelo.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Partida p = new Partida();
        PartidaRoteiro pRoteiro = new PartidaRoteiro();
        Scanner scanner = new Scanner(System.in);

        System.out.println("[ 1 ] App interativo");
        System.out.println("[ 2 ] App roteiro");

        while (true) {
            String entrada = scanner.nextLine();

            try {
                int op = Integer.parseInt(entrada); // Tenta converter

                if (op == 1) {
                    p.iniciar(); // Inicia o modo interativo
                    break;       // <--- SUCESSO! Sai do loop.
                } else if (op == 2) {
                    pRoteiro.iniciar(); // Inicia o modo roteiro
                    break;          // <--- SUCESSO! Sai do loop.
                } else {
                    // O usuário digitou um número, mas não é 1 nem 2
                    System.out.println(Cor.VERM.pin("Erro: Opção inválida. Digite 1 ou 2."));
                    System.out.print("Tente novamente: ");
                }

            } catch (NumberFormatException e) {
                // O usuário não digitou um número
                System.out.println(Cor.VERM.pin("Erro: Por favor, digite um número válido."));
                System.out.print("Tente novamente: ");
            }
        }

        // fechando o scanner
        scanner.close();
    }
}
