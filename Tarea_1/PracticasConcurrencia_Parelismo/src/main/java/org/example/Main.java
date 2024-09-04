package org.example;

import java.util.Random;
import java.util.Scanner;
public class Main extends Thread{
   static public int [] generadorArreglos(int size){
        int [] array = new int [size];
        Random aleatorio = new Random(System.currentTimeMillis());
        for (int i = 0; i < array.length; i++) {
            array[i] =  aleatorio.nextInt(size) ;
        }
        return array;
    }
    static public  void impresionArreglo (int [] array) {

        for (int i = 0; i < array.length; i++) {
            if (i % 5 == 0) {
                System.out.println();
                System.out.print(array[i] + " ");
            }else{
                System.out.print(array[i] + " ");
        }

        }
    }

    public static void main(String[] args) {

        System.out.println("Inserte el tamaño del arreglo");
        Scanner entrada = new Scanner(System.in);
        int size = entrada.nextInt();
            int [] array = generadorArreglos(size);
                    impresionArreglo(array);
        System.out.println("Inserte el valor que quiere buscar");
        int valor = entrada.nextInt();

    BusquedaBinaria.buscar(array, valor);


    }






}



