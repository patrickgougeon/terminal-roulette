package modelo;

import java.sql.SQLOutput;

public abstract class UI {

    public void msg_iniciar() throws InterruptedException{
        System.out.print("Bem vindo a ");
        Thread.sleep(600);
        System.out.print(Cor.VERM.pin("ROLETA "));
        System.out.print(Cor.BRNC.pin("RU", true));
        System.out.print(Cor.AZUL.pin("SS", true));
        System.out.println(Cor.VERM.pin("A", true));
        Thread.sleep(1000);

        System.out.print("    da prova da professora ");
        Thread.sleep(1000);
        System.out.println(Cor.VERM.pin("THALITA"));
        Thread.sleep(1500);

        System.out.println("ai que medooooooh");
        Thread.sleep(600);

    }

    public void msg_mirando() throws InterruptedException {
        System.out.print("mirando");
        Thread.sleep(800);
        System.out.print('.');
        Thread.sleep(800);
        System.out.print('.');
        Thread.sleep(800);
        System.out.println('.');
    }

    public void msg_tiroReal() throws InterruptedException {
        System.out.print(Cor.VERM.pin("BAAAAAAAANG"));
        Thread.sleep(800);
        System.out.println(Cor.VERM.pin("... ") + "bala REAL");
    }

    public void msg_tiroFake() throws InterruptedException {
        System.out.print(Cor.AZUL.pin("CLICK... "));
        Thread.sleep(800);
        System.out.println("bala FALSA");
    }

    public void msg_reload() throws InterruptedException {
        System.out.println("arma SEM MUNIÇÃO");

        System.out.print("recarregando");
        Thread.sleep(600);
        System.out.print('.');
        Thread.sleep(600);
        System.out.print('.');
        Thread.sleep(600);
        System.out.println('.');
    }

    public void msg_placar(int p1, int p2) {
        System.out.println(Cor.AMRL.pin("====================================="));
        System.out.println("PLACAR ATUAL (VIDAS):");
        System.out.println("Jogador 1: " + Integer.toString(p1));
        System.out.println("Jogador 2: " + Integer.toString(p2));
        System.out.println(Cor.AMRL.pin("====================================="));
    }
}
