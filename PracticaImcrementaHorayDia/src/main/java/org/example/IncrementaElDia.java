package org.example;

import java.util.Scanner;

public class IncrementaElDia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Día:");
        int dia = sc.nextInt();
        System.out.println("Mes:");
        int mes = sc.nextInt();
        System.out.println("Año:");
        int anio = sc.nextInt();

        // En función del mes comprueba que el día está en el rango corecto.
        // Si no lo esta a la variable numDias la asignael valor 0
        // En caso contrario le asigna el número de días del mes.

        int numDias = switch (mes) {
            // Si el case solo tiene una instrucción no es necesario poner el yield
            case 4, 6, 9, 11 -> (dia <1 || dia > 30) ? 0 : 30;
            case 2 -> (dia <1 || dia > 28) ? 0 : 28;
            case 3, 1, 5, 7, 8, 10, 12 -> (dia < 1 || dia > 31) ? 0:31;
            default -> {
                System.out.println("El mes o día introducido está fuera de rango");
                yield 0;
            }
        };

        // Si numDias es distinto de cero es porque el día y el mes eran correctos
        // Hacemos comprobación adicional del año, suponiendo que tiene que ser mayor que cero
        if (numDias != 0 && anio > 0) {
            // Hago los cálculos
            dia++;                        // Sumo un día
            if (dia > numDias) {          // Si desppues de sumar sobrepaso en nuum max de dias del mes
                dia = 1;                  // Pone dia a 1
                mes++;                    // y mes lo incrementa una unidad
                if (mes > 12) {           // si depueus de incrementar mes una unidad se pasa del max de meses
                    mes = 1;              // pone mes a 1
                    anio++;               // e incrementa anio una unidad
                }
            }

            System.out.printf("La nueva fecha es: %02d/%02d/%04d%n", dia, mes, anio);

        } else {
            System.out.println("Algun dato de la fecha está fuera de rango");
        }

        System.out.println("Programa finalizado");
    }
}
