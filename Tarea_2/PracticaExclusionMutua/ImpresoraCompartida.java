import java.util.concurrent.Semaphore;

public class ImpresoraCompartida {
    private Semaphore semaphore;
    private boolean enUso;

    // Constructor que inicializa el semáforo con 1 permiso (solo un hilo puede imprimir a la vez)
    public ImpresoraCompartida(int permisos) {
        this.semaphore = new Semaphore(permisos);
        this.enUso = false;
    }

    // Método que intenta imprimir un documento, utilizando exclusión mutua
    public void imprimirDocumento(String documento) {
        try {
            semaphore.acquire(); // Solicitar acceso exclusivo a la impresora mediante el semáforo

            // Bloque sincronizado para proteger la operación de entrar y salir de la impresora
            synchronized (this) {
                enUso = true;
                System.out.println(Thread.currentThread().getName() + " ha entrado a la impresora.");
            }

            // Simular el proceso de impresión
            System.out.println(Thread.currentThread().getName() + " está imprimiendo: " + documento);
            Thread.sleep(2000); // Simular tiempo de impresión

            synchronized (this) {
                enUso = false;
                System.out.println(Thread.currentThread().getName() + " ha salido de la impresora.");
            }
            /*El uso de los metodos del bloque synchronized son para ejemplificar una posible fuga de datos y como evitamos esta */
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Liberar el acceso a la impresora
        }
    }
}
