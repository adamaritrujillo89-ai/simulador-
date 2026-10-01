
package javaapplication4;

import java.util.Random;

public class CabinaPeaje implements Runnable {

    // Variable global compartida
    public static int totalRecaudadoGlobal = 0;

    // Atributos
    private String nombre;
    private int vehiculosAtendidos;
    private int vehiculosPorAtender;

    // Constructor
    public CabinaPeaje(String nombre, int vehiculosPorAtender) {
        this.nombre = nombre;
        this.vehiculosPorAtender = vehiculosPorAtender;
        this.vehiculosAtendidos = 0;
    }

    @Override
    public void run() {

        Random random = new Random();

        for (int i = 0; i < vehiculosPorAtender; i++) {

            try {
                // Tiempo aleatorio entre 500 y 1500 milisegundos
                int tiempo = random.nextInt(1001) + 500;

                Thread.sleep(tiempo);

                vehiculosAtendidos++;

                // Cobrar $50 por vehículo
                totalRecaudadoGlobal += 50;

                System.out.println(nombre
                        + " atendio un vehiculo."
                        + " Total: " + vehiculosAtendidos
                        + " | Recaudacion: $"
                        + totalRecaudadoGlobal);

            } catch (InterruptedException e) {
                System.out.println(nombre + " fue interrumpida.");
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(nombre + " termino su trabajo.");
    }

    // Obtener nombre
    public String getNombre() {
        return nombre;
    }

    // Obtener vehículos atendidos
    public int getVehiculosAtendidos() {
        return vehiculosAtendidos;
    }
}