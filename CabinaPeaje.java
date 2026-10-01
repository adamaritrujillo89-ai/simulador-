
package javaapplication4;

import java.util.Random;

public class CabinaPeaje implements Runnable {

    public static int totalRecaudadoGlobal = 0;

    private String nombre;
    private int vehiculosAtendidos;
    private int vehiculosPorAtender;

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
                int tiempo = random.nextInt(1001) + 500;

                Thread.sleep(tiempo);

                vehiculosAtendidos++;

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

    public String getNombre() {
        return nombre;
    }
    public int getVehiculosAtendidos() {
        return vehiculosAtendidos;
    }
}
