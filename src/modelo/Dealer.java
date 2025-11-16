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

        System.out.println("Limpando a mesa para a próxima rodada...");
        for (Esvaziavel obj : coisasParaLimpar) {
            obj.seEsvaziar(); // Polimorfismo!
        }

        int qtdItens = geradorAleatorio.nextInt(4) + 1;
        reabastecerMochila(mochilaP1, qtdItens);
        reabastecerMochila(mochilaP2, qtdItens);

        // Reabastece a arma
        reabastecerArma(arma);
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
    }
}
