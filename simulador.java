
package javaapplication4;

public class simulador {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("       SIMULADOR DE PEAJE");
        System.out.println("====================================");

        // Crear las tres cabinas
        CabinaPeaje cabina1 = new CabinaPeaje("Cabina Garcia", 10);
        CabinaPeaje cabina2 = new CabinaPeaje("Cabina 2", 10);
        CabinaPeaje cabina3 = new CabinaPeaje("Cabina 3", 10);

        // Crear los hilos
        Thread hilo1 = new Thread(cabina1);
        Thread hilo2 = new Thread(cabina2);
        Thread hilo3 = new Thread(cabina3);

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Esperar a que terminen los tres hilos
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();

        } catch (InterruptedException e) {
            System.out.println("Error al esperar los hilos.");
            Thread.currentThread().interrupt();
            return;
        }

        // Reporte final
        System.out.println("\n====================================");
        System.out.println("           REPORTE FINAL");
        System.out.println("====================================");

        System.out.println(cabina1.getNombre() + ": "
                + cabina1.getVehiculosAtendidos() + " vehiculos");

        System.out.println(cabina2.getNombre() + ": "
                + cabina2.getVehiculosAtendidos() + " vehiculos");

        System.out.println(cabina3.getNombre() + ": "
                + cabina3.getVehiculosAtendidos() + " vehiculos");

        System.out.println("------------------------------------");

        System.out.println("Total de vehiculos: "
                + (cabina1.getVehiculosAtendidos()
                + cabina2.getVehiculosAtendidos()
                + cabina3.getVehiculosAtendidos()));

        System.out.println("Total recaudado: $"
                + CabinaPeaje.totalRecaudadoGlobal);

        System.out.println("====================================");
        System.out.println("Simulacion finalizada.");
    }
}