// Em RodadaRoteiro.java
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class RodadaRoteiro extends UI {
    private Player p1;
    private Player p2;
    private Player jogadorAtual;

    // private Dealer dealer; // REMOVIDO (será local)
    private Arma escopeta;

    // private Scanner scanner; // REMOVIDO

    // ##### CONSTRUCTOR ##### \\
    public RodadaRoteiro(Player p1, Player p2) { // Scanner removido
        this.p1 = p1;
        this.p2 = p2;
        this.jogadorAtual = p1; // P1 começa

        // this.dealer = new Dealer(); // REMOVIDO
        this.escopeta = new Arma();

        // this.scanner = scan; // REMOVIDO
    }

    /**
     * Esta é a "execução reta" (script) da rodada.
     * Ela não usa loops de input e testa todas as funcionalidades.
     */
    public Player iniciar() throws InterruptedException {
        p1.regenerarSaude();
        p2.regenerarSaude();

        // Vamos criar um Dealer local apenas para carregar o roteiro
        Dealer dealerRoteiro = new Dealer();

        // carrega a arma e itens de forma scriptada
        dealerRoteiro.prepararRodadaRoteiro(escopeta, p1.getMochila(), p2.getMochila());

        // Variáveis para o script
        Player rival;
        boolean foiBalaReal;

        System.out.println("\n--- INÍCIO DO ROTEIRO DA RODADA ---");

        // --- TURNO 1 (Jogador 1) ---
        // Carga: [F, R, F, R] | P1 Itens: [Lupa, Cigarro]
        System.out.println("\n--- Turno de Jogador 1 (Roteiro) ---");
        jogadorAtual = p1;
        rival = p2;
        jogadorAtual.receberArma(escopeta);
        escopeta.defDono(jogadorAtual);

        System.out.println("[SCRIPT] Ação: P1 usa Item [Lupa] (índice 0)");
        jogadorAtual.usarItemDaMochila(0); // P1 usa Lupa
        // (A Lupa vai imprimir "Câmara vazia.")

        System.out.println("[SCRIPT] Ação: P1 atira em SI (esperando Falsa)");
        foiBalaReal = jogadorAtual.mirar(jogadorAtual); // Bala 1 (Falsa)
        System.out.println("Bala era real? " + foiBalaReal + " (Esperado: false)");

        // Como a bala foi falsa, P1 joga de novo
        System.out.println("[SCRIPT] P1 joga de novo.");
        // Carga: [R, F, R]

        System.out.println("[SCRIPT] Ação: P1 atira no RIVAL (esperando Real)");
        foiBalaReal = jogadorAtual.mirar(rival); // Bala 2 (Real)
        System.out.println("Bala era real? " + foiBalaReal + " (Esperado: true)");
        System.out.println("Saúde P2: " + rival.getSaude() + " (Esperado: 2)");

        System.out.println("Passando o turno...");
        jogadorAtual.soltarArma();


        // --- TURNO 2 (Jogador 2) ---
        // Carga: [F, R] | P2 Itens: [Serra]
        System.out.println("\n--- Turno de Jogador 2 (Roteiro) ---");
        jogadorAtual = p2;
        rival = p1;
        jogadorAtual.receberArma(escopeta);
        escopeta.defDono(jogadorAtual);

        System.out.println("[SCRIPT] Ação: P2 usa Item [Serra] (índice 0)");
        jogadorAtual.usarItemDaMochila(0); // P2 usa Serra
        // (Serra vai ativar e o dano da arma agora é 2)

        System.out.println("[SCRIPT] Ação: P2 atira no RIVAL (esperando Falsa)");
        foiBalaReal = jogadorAtual.mirar(rival); // Bala 3 (Falsa)
        System.out.println("Bala era real? " + foiBalaReal + " (Esperado: false)");

        System.out.println("Passando o turno...");
        jogadorAtual.soltarArma();


        // --- TURNO 3 (Jogador 1) ---
        // Carga: [R] | P1 Itens: [Cigarro]
        System.out.println("\n--- Turno de Jogador 1 (Roteiro) ---");
        jogadorAtual = p1;
        rival = p2;
        jogadorAtual.receberArma(escopeta);
        escopeta.defDono(jogadorAtual);

        System.out.println("[SCRIPT] Ação: P1 usa Item [Cigarro] (deve falhar, saúde cheia)");
        jogadorAtual.usarItemDaMochila(0); // P1 usa Cigarro (índice 0, Lupa já foi)

        System.out.println("[SCRIPT] Ação: P1 mostra Conquistas (Teste Req. 3)");
        jogadorAtual.mostrarConquistas();; // Testando o requisito de ordenação

        System.out.println("[SCRIPT] Ação: P1 atira em SI (esperando Real)");
        foiBalaReal = jogadorAtual.mirar(jogadorAtual); // Bala 4 (Real)
        System.out.println("Bala era real? " + foiBalaReal + " (Esperado: true)");
        // Dano é 1 (P2 usou serra, mas P1 não)
        System.out.println("Saúde P1: " + jogadorAtual.getSaude() + " (Esperado: 2)");

        System.out.println("Passando o turno...");
        jogadorAtual.soltarArma();

        // --- TURNO 4 (Jogador 2) ---
        // Carga: [] (Vazia)
        System.out.println("\n--- Turno de Jogador 2 (Roteiro) ---");
        jogadorAtual = p2;
        rival = p1;
        jogadorAtual.receberArma(escopeta);
        escopeta.defDono(jogadorAtual);

        System.out.println("[SCRIPT] Ação: P2 tenta atirar (Arma vazia)");
        if (escopeta.taVazia()) {
            msg_reload();
        }

        System.out.println("\n--- FIM DO ROTEIRO DA RODADA ---");

        System.out.println("[ROTEIRO] Forçando P1 como perdedor para testar o loop de vidas.");
        return p1;


    }
}