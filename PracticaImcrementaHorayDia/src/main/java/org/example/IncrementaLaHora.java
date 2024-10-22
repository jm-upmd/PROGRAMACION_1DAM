package org.example;

import java.util.Scanner;

public class IncrementaLaHora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hora:");
        int hora = sc.nextInt();
        System.out.println("Minuto:");
        int minuto = sc.nextInt();
        System.out.println("Segundo:");
        int segundo = sc.nextInt();

        // Control de errores

        if ( !(hora <0 || hora > 23 || minuto < 0 || minuto > 59 || segundo < 0 || segundo >59)){ // ifgrande

            // Hago los calculos
            segundo++;
            if (segundo > 59){ // if1
                segundo = 0;
                minuto++;
                if (minuto > 59 ) {
                    minuto = 0;
                    hora++;
                    if(hora > 23){
                        hora = 0;
                    }
                }
            } // if1

            // Poner un cero delante de los que tengan un solo digito

            String sHora = (hora /10 == 0) ? "0"+hora : hora + "";
            String sMinuto = (minuto /10 == 0) ? "0"+minuto : minuto + "";
            String sSegundo = (segundo /10 == 0) ? "0"+segundo : segundo + "";

            // Modo alternativo de mostrar resultado con 2 dígintos. Usando el printf

            System.out.printf("La nueva hora es : %02d:%02d:%02d\n", hora, minuto, segundo);


            //System.out.println("La nueva hora es : " + sHora +":" + sMinuto + ":" + sSegundo);
        } else { // ifgrande
            System.out.println("Hay halgún fuera de rango");
        }


        System.out.println("Programa finalizado");


    }
}
