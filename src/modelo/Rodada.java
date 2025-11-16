package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Rodada extends UI{
    private Player p1;
    private Player p2;
    private Player jogadorAtual; // jogador atual no round

    private Dealer dealer;
    private Arma escopeta;

    private Scanner scanner;

    // ##### CONSTRUCTOR ##### \\
    public Rodada() {
        this.p1 = new Player();
        this.p2 = new Player();
        this.jogadorAtual = p1; // P1 começa

        this.dealer = new Dealer();
        this.escopeta = new Arma();

        this.scanner = new Scanner(System.in);
    }

    public void iniciar() throws InterruptedException { // inicia a rodada e mantem o loop de gameplay
        /*  Loop principal, enquanto os players
             estiverem vivos, continua o jogo */
        while (p1.getSaude() > 0 && p2.getSaude() > 0) {

            Mochila mochilaP1 = p1.getMochila();
            Mochila mochilaP2 = p2.getMochila();

            // carrega a arma no início da rodada
            if (escopeta.taVazia()) {
                dealer.prepararNovaRodada(escopeta, mochilaP1, mochilaP2);
            };

            // entrega arma para o jogador atual
            jogadorAtual.receberArma(escopeta);

            // Loop do turno (enquanto o jogador tiver a arma)
            executarTurno();
        }

        System.out.println("FIM DE JOGO!"); // se saiu do loop, o jogo acabou
        scanner.close();
    }

    private void executarTurno() throws InterruptedException { // turno do player atual
        // Define quem é o rival
        Player rival = (jogadorAtual == p1) ? p2 : p1;
        /*             |      TERNARY  OPERATOR      |
                                se atual == p1
                                    rival = p2
                                senão
                                    rival = p1
         */
        String nome = (jogadorAtual == p1) ? "Jogador 1" : "Jogador 2"; // mesma logica acima

        System.out.println("--- Turno de " + nome + " ---");

        while (true) {

            if (escopeta.taVazia()) { // se munição vazia
                System.out.println("Arma vazia, recarregando...");
                break; // sai do loop do turno
            };

            System.out.println("Vida atual: " + jogadorAtual.getSaude());
            System.out.println("[ 1 ] Atirar em si \n[ 2 ] Atirar no rival \n[ 3 ] Usar item");

            int op = scanner.nextInt();
            scanner.nextLine();

            boolean foiBalaReal;

            boolean turnoAcabou = false; // Flag para controlar o fim do turno

            switch (op) {
                case 1 -> { // atirar em si
                    msg_mirando();
                    foiBalaReal = jogadorAtual.mirar(jogadorAtual);

                    if (foiBalaReal) { // atirou em si e era real
                        System.out.println("Você levou dano!");
                        trocarTurno(); // passa a vez
                        turnoAcabou = true; // Acaba o turno
                    } else {
                        System.out.println("Era FAKE! Você joga de novo.");
                        // turnoAcabou continua 'false', o loop 'while' continua
                    }
                }
                case 2 -> { // atirar no rival
                    msg_mirando();
                    jogadorAtual.mirar(rival);
                    trocarTurno(); // passa a vez
                    turnoAcabou = true; // Acaba o turno
                }
                case 3 -> {
                    Mochila mochila = jogadorAtual.getMochila();
                    mochila.mostrarItems();

                    System.out.print("Qual item? (ou 0 para voltar): ");
                    int opItens = scanner.nextInt();
                    scanner.nextLine();

                    if (opItens == 0) {
                        // O usuário quer voltar, não faz nada e deixa o loop continuar
                        System.out.println("Voltando...");

                    } else if (opItens > 0 && opItens <= mochila.getQuantidadeItens()) {
                        // O usuário digitou um número de item válido (Ex: 1 ou 2)
                        // Traduz o índice: (usuário digitou 1 -> índice é 0)
                        jogadorAtual.usarItemDaMochila(opItens - 1);

                    } else {
                        // O usuário digitou um número inválido (Ex: 5)
                        System.out.println("Opção de item inválida.");
                    }
                    // turnoAcabou continua 'false', o loop 'while' continua
                }
                default -> System.out.println("Opção inválida.");
            }

            if (turnoAcabou) {
                break; // Sai do loop 'while(true)' e encerra o turno
            }
        }
    }

    private void trocarTurno() {
        System.out.println("Passando o turno...");

        /*  solta a arma na mesa, que é passada pro
            inimigo pelo loop da função iniciar() */
        this.jogadorAtual.soltarArma();

        // alteração do jogador atual
        if (this.jogadorAtual == p1) {
            this.jogadorAtual = p2;
        } else {
            this.jogadorAtual = p1;
        }
    }
}