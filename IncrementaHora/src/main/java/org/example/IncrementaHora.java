package org.example;

import java.util.Scanner;

public class IncrementaHora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hora Minuto Segundo");
        int hora = sc.nextInt();
        int minuto = sc.nextInt();
        int segundo = sc.nextInt();

        if(hora < 0 || hora > 23 || minuto < 0 || minuto > 59 || segundo < 0 || segundo > 59){
            System.out.println("Algún componente de la hora está fuera de rango");
        } else {
            if(++segundo > 59) {
                segundo = 0;
                if ( ++minuto > 59){
                    minuto= 0;
                    if (++hora > 23){
                        hora = 0;
                    }
                }
            }

            // Opcional: Si hora,minuto o segundo solo tiene un dígito creamos String con 0 a la izquierda.
            // Ponemos un 0 delante de las partes que solo tengan un dígito
            // Mejor alternativa es crear un método que lo haga y no repetir tres veces la misma operacón
            // lo veremos más adelante cuando usemos métodos.
            String sHora = (hora / 10 == 0) ? "0"+hora : hora+"";
            String sMinuto = (minuto / 10 == 0) ? "0"+minuto : minuto+"";
            String sSegundo = (segundo / 10 == 0) ? "0"+segundo : segundo+"";
            System.out.println("La nueva hora es: " + sHora + ":" + sMinuto + ":" + sSegundo );

           // Opción 2 utilizar método printf. Mas cómodo y corto.
            System.out.printf("La nueva hora es: %02d:%02d:%02d\n", hora, minuto, segundo);
     } // else

        System.out.println("Fin del programa");
    } // main
}