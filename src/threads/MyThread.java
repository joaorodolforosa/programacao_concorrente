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

    String thrdName;

    public MyThread(String name) {
        thrdName = name;
    }

    // Ponto de entrada da thread
    @Override
    public void run() {
        System.out.println(thrdName + " inicializando.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("Em " + thrdName + ",contador é " + count);

            }
        } catch (InterruptedException exc) {
            System.out.println(thrdName + "interrompida.");
        }
        System.out.println(thrdName + " terminando.");
    }

}
