package modelo;

import java.sql.SQLOutput;

public abstract class UI {

    public void msg_mirando() throws InterruptedException {
        System.out.print("mirando");
        Thread.sleep(800);
        System.out.print('.');
        Thread.sleep(800);
        System.out.print('.');
        Thread.sleep(800);
        System.out.println('.');
        Thread.sleep(800);
    }

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

        System.out.println("Começar jogo? [S|N]");

    }
}
