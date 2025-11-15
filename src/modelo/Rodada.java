package modelo;

import java.util.Scanner;

public class Rodada extends UI{
    private Player p1;
    private Player p2;
    private Player jogadorAtual; // jogador atual no round

    private Arma escopeta;

    private Scanner scanner;

    // ##### CONSTRUCTOR ##### \\
    public Rodada() {
        this.p1 = new Player();
        this.p2 = new Player();
        this.jogadorAtual = p1; // P1 começa

        this.escopeta = new Arma();

        this.scanner = new Scanner(System.in);
    }

    public void iniciar() throws InterruptedException { // inicia a rodada e mantem o loop de gameplay
        /*  Loop principal, enquanto os players
             estiverem vivos, continua o jogo */
        while (p1.getSaude() > 0 && p2.getSaude() > 0) {

            // carrega a arma no início da rodada
            if (escopeta.taVazia()) {escopeta.carregar();};

            // entrega arma para o jogador atual
            jogadorAtual.receberArma(escopeta);

            // Loop do turno (enquanto o jogador tiver a arma)
            executarTurno();
        }

        System.out.println("FIM DE JOGO!"); // se saiu do loop, o jogo acabou
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
            System.out.println("[ 1 ] Atirar em si \n[ 2 ] Atirar no rival");

            int op = scanner.nextInt();
            msg_mirando();

            boolean foiBalaReal;

            if (op == 1) { // atirar em si
                foiBalaReal = jogadorAtual.mirar(jogadorAtual);

                if (foiBalaReal) { // atirou em si e era real
                    System.out.println("Você levou dano!");
                    trocarTurno(); // passa a vez
                    break; // sai do loop do turno
                } else {
                    System.out.println("Era FAKE! Você joga de novo.");
                    // Continua no loop
                }

            } else if (op == 2) { // atirar no rival
                jogadorAtual.mirar(rival);
                trocarTurno(); // passa a vez
                break; // Sai do loop do turno
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