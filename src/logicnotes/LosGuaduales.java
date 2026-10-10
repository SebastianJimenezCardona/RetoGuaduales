package logicnotes;

import java.util.Scanner;

public class LosGuaduales {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        double[] consumos = new double[6];
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    registrarConsumo(consumos);
                    break;
                case 2:
                    consultarFactura(consumos);
                    break;
                case 3:
                    generarReporte(consumos);
                    break;
                case 4:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 4);
    }

    static void mostrarMenu() {
        System.out.println();
        System.out.println("===== LOS GUADUALES - CONTROL DE AGUA =====");
        System.out.println("1. Registrar consumo de un apartamento");
        System.out.println("2. Consultar factura de un apartamento");
        System.out.println("3. Ver reporte general del conjunto");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");
    }

    static void registrarConsumo(double[] consumos) {

        System.out.print("Número de apartamento (1 a 6): ");
        int apartamento = sc.nextInt();

        while (apartamento < 1 || apartamento > 6) {
            System.out.print("Error, el apartamento debe estar entre 1 y 6. Intente de nuevo: ");
            apartamento = sc.nextInt();
        }

        System.out.print("Consumo en m3: ");
        double consumo = sc.nextDouble();

        while (consumo <= 0) {
            System.out.print("Error, el consumo debe ser mayor que 0. Intente de nuevo: ");
            consumo = sc.nextDouble();
        }

        consumos[apartamento - 1] = consumo;

        System.out.println("Consumo registrado para el apartamento " + apartamento);
    }

    static void consultarFactura(double[] consumos) {

        System.out.print("Número de apartamento (1 a 6): ");
        int apartamento = sc.nextInt();

        while (apartamento < 1 || apartamento > 6) {
            System.out.print("Error, el apartamento debe estar entre 1 y 6. Intente de nuevo: ");
            apartamento = sc.nextInt();
        }

        double consumo = consumos[apartamento - 1];

        if (consumo == 0) {
            System.out.println("El apartamento " + apartamento + " no tiene consumo registrado");
        } else {
            imprimirFactura(apartamento, consumo);
        }
    }

    static void imprimirFactura(int apartamento, double consumo) {

        double cargoFijo = 12000;
        double tarifa;

        if (consumo <= 10) {
            tarifa = 3000;
        } else if (consumo <= 20) {
            tarifa = 4500;
        } else {
            tarifa = 6000;
        }

        double valorConsumo = consumo * tarifa;
        double subtotal = cargoFijo + valorConsumo;

        double recargo = 0;
        if (consumo > 25) {
            recargo = subtotal * 0.10;
        }

        double total = subtotal + recargo;

        System.out.println();
        System.out.println("----- FACTURA APARTAMENTO " + apartamento + " -----");
        System.out.println("Consumo: " + consumo + " m3");
        System.out.println("Tarifa aplicada: $" + tarifa + " por m3");
        System.out.println("Valor del consumo: $" + valorConsumo);
        System.out.println("Cargo fijo: $" + cargoFijo);
        if (consumo > 25) {
            System.out.println("Recargo (10%): $" + recargo);
        }
        System.out.println("Total a pagar: $" + total);

        if (consumo > 25) {
            System.out.println("ALERTA: consumo excesivo");
        }
    }

    static void generarReporte(double[] consumos) {

        double total = 0;
        int registrados = 0;
        int sinRegistro = 0;
        int excesivos = 0;
        double mayor = 0;
        int aptoMayor = 0;

        for (int i = 0; i < 6; i++) {
            if (consumos[i] == 0) {
                sinRegistro = sinRegistro + 1;
            } else {
                total = total + consumos[i];
                registrados = registrados + 1;

                if (consumos[i] > 25) {
                    excesivos = excesivos + 1;
                }

                if (consumos[i] > mayor) {
                    mayor = consumos[i];
                    aptoMayor = i + 1;
                }
            }
        }

        if (registrados == 0) {
            System.out.println("Aún no hay consumos registrados");
        } else {

            double promedio = total / registrados;

            System.out.println();
            System.out.println("----- REPORTE GENERAL -----");
            System.out.println("Consumo total: " + total + " m3");
            System.out.println("Consumo promedio: " + promedio + " m3");
            System.out.println("Mayor consumo: apartamento " + aptoMayor + " con " + mayor + " m3");
            System.out.println("Apartamentos sin registro: " + sinRegistro);
            System.out.println("Apartamentos con consumo excesivo: " + excesivos);
        }
    }
}