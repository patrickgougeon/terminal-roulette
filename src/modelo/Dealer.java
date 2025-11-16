package modelo;

import java.util.ArrayList;
import java.util.Random;

public class Dealer {

    private final Random geradorAleatorio = new Random();

    public Item criarItem(TipoItem tipo) {
        return switch (tipo) {
            case LUPA -> new Lupa();
            case CIGARRO -> new Cigarro();
            case SERRA -> new Serra();
        };
    }

    public void prepararNovaRodada(Arma arma, Mochila mochilaP1, Mochila mochilaP2) {
        Esvaziavel[] coisasParaLimpar = { arma, mochilaP1, mochilaP2 };

        System.out.println("Limpando a mesa...");
        for (Esvaziavel obj : coisasParaLimpar) {
            obj.seEsvaziar();
        }

        int qtdItens = geradorAleatorio.nextInt(4) + 1;
        reabastecerMochila(mochilaP1, qtdItens);
        reabastecerMochila(mochilaP2, qtdItens);

        // Reabastece a arma
        reabastecerArma(arma);
    }

    public void prepararRodadaRoteiro(Arma arma, Mochila mochilaP1, Mochila mochilaP2) {

        // 1. Limpa o estado anterior
        Esvaziavel[] coisasParaLimpar = { arma, mochilaP1, mochilaP2 };
        System.out.println("[ROTEIRO] Limpando a mesa para o roteiro...");
        for (Esvaziavel obj : coisasParaLimpar) {
            obj.seEsvaziar();
        }

        // 2. Carrega itens específicos (para testar o uso)
        System.out.println("[ROTEIRO] Carregando itens do roteiro...");
        mochilaP1.adicionarItem(criarItem(TipoItem.LUPA));
        mochilaP1.adicionarItem(criarItem(TipoItem.CIGARRO));
        mochilaP2.adicionarItem(criarItem(TipoItem.SERRA));

        // 3. Carrega uma sequência de balas exata
        System.out.println("[ROTEIRO] Carregando arma do roteiro...");
        arma.adicionarBala(false); // 1ª bala: Falsa (para P1 atirar em si)
        arma.adicionarBala(true);  // 2ª bala: Real (para P1 atirar no rival)
        arma.adicionarBala(false); // 3ª bala: Falsa (para P2 atirar no rival)
        arma.adicionarBala(true);  // 4ª bala: Real (para P1 atirar em si e tomar dano)

        System.out.println("Carga da Arma: [FALSA, REAL, FALSA, REAL]");
    }

    public void reabastecerMochila(Mochila mochila, int qtdItens) {
        TipoItem[] todosOsItens = TipoItem.values();

        for (int i = 0; i < qtdItens; i++) {
            // Pega um item aleatório da lista de tipos
            int idProximoItem = geradorAleatorio.nextInt(todosOsItens.length);
            TipoItem tipoDoProximoItem = todosOsItens[idProximoItem];

            Item proximoItem = this.criarItem(tipoDoProximoItem);
            mochila.adicionarItem(proximoItem);
        }
    }

    public void reabastecerArma(Arma arma) {
        int nReal = 0;
        int nFake = 0;

        while (nReal == 0 || nFake == 0) {
            nReal = 0;
            nFake = 0;

            boolean bala;

            for (int i = 0; i <= geradorAleatorio.nextInt(2, 9); i++) {

                bala = geradorAleatorio.nextBoolean();
                arma.adicionarBala(bala);

                if (bala) {
                    nReal += 1;
                } else {
                    nFake += 1;
                }
            }
        }

        System.out.printf("Número de balas reais: %d \n", nReal);
        System.out.printf("Número de balas falsas: %d \n", nFake);
    }
}
