package org.example;

public class BusquedaBinaria {


public static void buscar(int array[], int valor ){
    Thread ejemploRunnable = new Thread(new HiloIzquierda(array,valor));
    Thread ejemploThread = new Thread(new HiloDerecha(array,valor));
    ejemploRunnable.start();
    ejemploThread.start();

    do {
        if (!ejemploRunnable.isAlive() && HiloIzquierda.isFind()) {
            System.out.println("Hilo izquierda encontro el objetivo en la posicion " + HiloIzquierda.getIndice());
            ejemploThread.interrupt();
        }
        if (!ejemploThread.isAlive() && HiloDerecha.isfind()) {
            System.out.println("Hilo derecha encontro el objetivo en la posicion " + HiloDerecha.getIndice());
            ejemploRunnable.interrupt();
        }

    }while  ((!HiloDerecha.isfind() || !HiloIzquierda.isFind() )
            && ( ejemploRunnable.isAlive() || ejemploThread.isAlive())); ;
    if (!HiloDerecha.isfind() && !HiloIzquierda.isFind()) {
        System.out.println("El valor no se encuentra en el arreglo");
    }
}


}
