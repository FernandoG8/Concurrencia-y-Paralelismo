package org.example;

public class HiloDerecha extends Thread {
    private int [] arrayR ;
    private static int  indice;
    private int target ;
    private static boolean find = false;
    public static boolean isfind() {
        return find;
    }
    public static  int   getIndice(){
        return indice;

    }
    public HiloDerecha(int[]arrayR, int target) {
        this.arrayR = arrayR;
        this.target = target;
    }
    @Override
    public void run() {
        if (arrayR [arrayR.length/2] == target ){
            System.out.println("Lo encontre " + Thread.currentThread().getName());
            currentThread().interrupt();
            find = true;
        }
        for (int i = arrayR.length - 1 ; i > arrayR.length/2 ; i--) {
            if (arrayR[i] == target){
                indice = i ;
                System.out.println(Thread.currentThread().getName() + " Lo encontré " + indice);
                find = true;
                break;

            }
            currentThread().interrupt();
        }

    }

}
