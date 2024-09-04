package org.example;

public class HiloIzquierda implements  Runnable {
    private int[] arrayL;
    private static int indice;
    private int target;
    private static boolean find = false;
    public static boolean isFind (){
            return find;    }
    public static int getIndice() {
        return indice;

    }

    public HiloIzquierda(int[] arrayL, int target) {
        this.arrayL = arrayL;
        this.target = target;
    }

    @Override
    public void run() {
        for (int i = 0; i < arrayL.length / 2; i++) {
            if (arrayL[i] == target) {
                indice = i;
                System.out.println(Thread.currentThread().getName() + " Lo encontré " + indice);
                find = true;
                break;
            }

        }
    }
}

