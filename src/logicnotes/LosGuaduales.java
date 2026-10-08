package logicnotes;

import java.util.Scanner;

public class LosGuaduales {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] apartamento = new int[6];

        int opcion;

        do {

            opcion = mostrarMenu(sc);

            switch (opcion) {

                case 1:
                    registrarConsumo(sc, apartamento);
                    break;

                case 2:
                    System.out.println(consultarFactura(sc, apartamento));
                    break;

                case 3:
                    verReporte(apartamento);
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Elige del 1 al 4.");
            }

        } while (opcion != 4);

        sc.close();
    }


    public static int mostrarMenu(Scanner sc) {

        System.out.println();
        System.out.println("----------- MENÚ -----------");
        System.out.println("1. Registrar consumo de un apartamento");
        System.out.println("2. Consultar factura de un apartamento");
        System.out.println("3. Ver reporte general del conjunto");
        System.out.println("4. Salir");
        System.out.println("-----------------------------");
        System.out.print("Seleccione una opción: ");

        int opcion = sc.nextInt();

        return opcion;
    }


    public static int registrarConsumo(Scanner sc, int[] apartamento) {

        System.out.println();
        System.out.println("Ingrese el número del apartamento del 1 al 6");

        int numeroApartamento = sc.nextInt();

        System.out.println("Ingrese el consumo del apartamento:");

        int valorConsumido = sc.nextInt();

        apartamento[numeroApartamento - 1] = valorConsumido;

        System.out.println("Consumo registrado correctamente.");

        return valorConsumido;
    }


    public static int consultarFactura(Scanner sc, int[] apartamento) {

        int valorPequeno = 3000;
        int valorMediano = 4500;
        int valorExcesivo = 6000;
        int consumoTotal;

        System.out.println();
        System.out.println("Ingrese el número del apartamento del 1 al 6");

        int numeroApartamento = sc.nextInt();

        int valorConsumido = apartamento[numeroApartamento - 1];

        if (valorConsumido < 10) {

            consumoTotal = valorConsumido * valorPequeno;
            System.out.println("El valor es: " + consumoTotal);

        } else if (valorConsumido <= 20) {

            consumoTotal = valorConsumido * valorMediano;
            System.out.println("El valor es: " + consumoTotal);

        } else {

            consumoTotal = valorConsumido * valorExcesivo;
            System.out.println("El valor es: " + consumoTotal + ". El valor es excesivo");

        }

        return consumoTotal;
    }


    public static void verReporte(int[] apartamento) {

        int total = 0;

        for (int i = 0; i <= 6; i++) {

            System.out.println("Apartamento " + (i + 1) + ": " + apartamento[i]);

            total = total + apartamento[i];
        }

        System.out.println("Consumo total: " + total);
    }

}