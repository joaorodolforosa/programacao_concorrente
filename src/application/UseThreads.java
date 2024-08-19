package application;

import threads.MyThread;

/**
 *
 * @author Prof Rodolfo
 */
public class UseThreads {

    public static void main(String[] args) {
        System.out.println("Thread principal inicializando");

        // Primeiro constrói um objeto MyThread
        MyThread mt = new MyThread("Thread Filha #1");

        // Em seguida, constrói uma thread a partir desse objeto
        Thread newThrd = new Thread(mt);

        // Para concluir, começa a execução da thread
        newThrd.start();

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
