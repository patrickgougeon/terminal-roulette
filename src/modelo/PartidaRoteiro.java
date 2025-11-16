package modelo;

import java.util.Scanner;

public class PartidaRoteiro extends UI {
    private Player p1;
    private Player p2;
    private Scanner scanner;

    public PartidaRoteiro() {
        this.p1 = new Player();
        this.p2 = new Player();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() throws InterruptedException {
        System.out.println("### BEM-VINDO AO JOGO COMPLETO ###");

        // Loop principal do JOGO: continua enquanto ambos tiverem VIDA
        while (p1.getVida() > 0 && p2.getVida() > 0) {

            // 1. Informa o placar de vidas
            msg_placar(p1.getVida(), p2.getVida());

            // 2. Cria e joga uma nova PARTIDA
            RodadaRoteiro novaRodada = new RodadaRoteiro(p1, p2, scanner);

            Player perdedorDaPartida = novaRodada.iniciar();


            // 3. Aplica a penalidade (perder vida)
            System.out.println("O perdedor da partida perde 1 vida.");
            perdedorDaPartida.perderVida();
        }

        // 4. Fim do Jogo (Loop principal quebrou)
        System.out.println("### FIM DE JOGO! ###");
        if (p1.getVida() <= 0) {
            System.out.println("O Jogador 2 é o grande vencedor!");
        } else {
            System.out.println("O Jogador 1 é o grande vencedor!");
        }
    }


}
