// Em PartidaRoteiro.java
package modelo;

import java.util.Scanner;

public class PartidaRoteiro extends UI {
    private Player p1;
    private Player p2;
    // private Scanner scanner; // REMOVIDO

    public PartidaRoteiro() {
        this.p1 = new Player();
        this.p2 = new Player();
        // this.scanner = new Scanner(System.in); // REMOVIDO
    }

    public void iniciar() throws InterruptedException {
        msg_iniciar();

        // Este loop (das VIDAS) continua, pois queremos testar uma partida inteira
        while (p1.getVida() > 0 && p2.getVida() > 0) {

            msg_placar(p1.getVida(), p2.getVida());

            // Cria a rodada sem o scanner
            RodadaRoteiro novaRodada = new RodadaRoteiro(p1, p2);

            // Inicia o roteiro da rodada
            Player perdedorDaPartida = novaRodada.iniciar();

            System.out.println("O perdedor da partida perde 1 vida.");
            perdedorDaPartida.perderVida();
        }

        System.out.println("### FIM DE JOGO! ###");
        // ... (lógica do vencedor)
    }
}