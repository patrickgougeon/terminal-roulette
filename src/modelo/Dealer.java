package modelo;

import java.util.ArrayList;
import java.util.Random;

public class Dealer {

    private final Random geradorAleatorio = new Random();

    public Item criarItem(int idItem) {
        return switch (idItem) {
            case 0 -> new Lupa();
            case 1 -> new Cigarro();
            case 2 -> new Serra();
            default -> throw new IllegalArgumentException("ID de item inválido: " + idItem);
        };
    }

    public void esvaziarMochila(Mochila mochila) {
        mochila.seEsvaziar();
    }

    public void reabastecerMochila(Mochila mochila, int qtdItens) {

        for (int i = 0; i < qtdItens; i++) {
            int idProximoItem = geradorAleatorio.nextInt(3);
            Item proximoItem = this.criarItem(idProximoItem);

            mochila.adicionarItem(proximoItem);
        }
    }

    public void reabastecerItensDoJogo(Mochila mochilaP1, Mochila mochilaP2) {
        int qtdItensAReabastecer = geradorAleatorio.nextInt(4) + 1;

        esvaziarMochila(mochilaP1);
        esvaziarMochila(mochilaP2);

        reabastecerMochila(mochilaP1, qtdItensAReabastecer);
        reabastecerMochila(mochilaP2, qtdItensAReabastecer);
    }

    public void reabastecerArma(Arma arma) {
        int nReal = 0;
        int nFake = 0;

        while (nReal == 0 || nFake == 0) {
            nReal = 0;
            nFake = 0;

            boolean bala;

            arma.seEsvaziar(); // limpa as balas antigas (se tiver)

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
