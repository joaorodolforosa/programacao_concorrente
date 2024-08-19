package threads;

/**
 *
 * @author Prof Rodolfo
 *
 * Objetos de MyThread podem ser executados em suas próprias threads porque
 * MyThread implementa Runnable
 *
 */
public class MyThread implements Runnable {

    Thread thrd;

    // Constrói uma nova thread
    public MyThread(String name) {
        thrd = new Thread(this, name);
        thrd.start();
    }

    // Ponto de entrada da thread
    @Override
    public void run() {
        System.out.println(thrd.getName() + " inicializando.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("Em " + thrd.getName() + ",contador é " + count);

            }
        } catch (InterruptedException exc) {
            System.out.println(thrd.getName() + "interrompida.");
        }
        System.out.println(thrd.getName() + " terminando.");
    }

}
