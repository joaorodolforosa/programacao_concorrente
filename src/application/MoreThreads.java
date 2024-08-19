package application;

import threads.MyThread;

/**
 *
 * @author Prof Rodolfo
 */
public class MoreThreads {

    public static void main(String[] args) {
        System.out.println("Thread principal inicializando");

        // Cria e começa a executar 3 threads
        MyThread mt1 = new MyThread("Thread Filha #1");
        MyThread mt2 = new MyThread("Thread Filha #2");
        MyThread mt3 = new MyThread("Thread Filha #3");

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Thread principal interrompida");
            }
        }

        System.out.println("Thread principal encerrando");
    }
}
