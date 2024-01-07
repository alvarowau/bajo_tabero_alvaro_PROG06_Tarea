package com.alvarobajo.tare6.util;

import com.alvarobajo.tare6.data.Concesionario;
import com.alvarobajo.tare6.model.Vehiculo;

import javax.swing.*;
import java.util.List;

/**
 * La clase MostrarDatos proporciona métodos para mostrar información sobre vehículos del concesionario.
 * Permite modificar los kilómetros de un vehículo, mostrar la lista de vehículos y buscar vehículos por matrícula.
 *
 * @author Álvaro Bajo
 * @company BriandaMendoza-Programacion
 * @version 1.0
 */
public class MostrarDatos {

    private Concesionario concesionario;

    /**
     * Constructor de la clase MostrarDatos.
     *
     * @param concesionario El concesionario que contiene la información de los vehículos.
     */
    public MostrarDatos(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    /**
     * Método para modificar los kilómetros de un vehículo.
     *
     * @param matricula La matrícula del vehículo a modificar.
     * @param km        Los nuevos kilómetros a establecer.
     * @return true si la modificación es exitosa, false si hay errores o se cancela la operación.
     */
    public boolean modificarKMDeVehiculo(String matricula, int km) {
        Vehiculo vehiculo = concesionario.buscarVehiculo(matricula);

        // Verificar si se encontró el vehículo
        if (vehiculo != null) {
            System.out.println("Datos del Vehículo con Matrícula " + matricula + ":");
            imprimirInfoVehiculo(vehiculo);
            System.out.println("Kilómetros actuales: " + vehiculo.getKilometros());
            System.out.println("Kilómetros a modificar: " + km);

            // Verificar si los kilómetros a modificar son mayores a los actuales
            if (km > vehiculo.getKilometros()) {
                // Llamar a concesionario.actualizarKms(matricula, km) y verificar el resultado
                boolean actualizacionExitosa = concesionario.actualizarKms(matricula, km);

                if (actualizacionExitosa) {
                    System.out.println("Los kilómetros se han modificado correctamente.");
                    return true;
                } else {
                    System.out.println("Error al intentar actualizar los kilómetros.");
                }
            } else {
                System.out.println("Error: La nueva cantidad de kilómetros debe ser mayor a la actual.");
            }
        } else {
            System.out.println("No se encontró ningún vehículo con la matrícula " + matricula + ".");
        }

        // Preguntar al usuario si quiere volver a intentarlo o regresar al menú
        System.out.println("¿Desea volver a intentarlo? (Sí/No)");

        String respuesta = UtilDatos.entradaTeclado("").toLowerCase();
        if (respuesta.equalsIgnoreCase("si")) {
            // Volver a pedir los kilómetros hasta que sea un número entero positivo
            int nuevosKmNumerico;
            do {
                String nuevosKms = UtilDatos.entradaTeclado("Ingrese la nueva cantidad de kilómetros:");
                if (UtilComprobaciones.esEnteroPositivo(nuevosKms)) {
                    nuevosKmNumerico = Integer.parseInt(nuevosKms);
                    break;
                } else {
                    System.out.println("Error: La cantidad de kilómetros debe ser un número entero positivo.");
                }
            } while (true);

            return modificarKMDeVehiculo(matricula, nuevosKmNumerico);
        }

        return false; // Si el usuario decide no volver a intentarlo, retornar false
    }

    /**
     * Método para mostrar la lista de vehículos en el concesionario.
     */
    public void mostrarListaVehiculos() {
        // Obtener la lista de vehículos
        List<Vehiculo> vehiculos = concesionario.obtenerListaVehiculos();

        // Verificar si la lista está vacía
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos en el concesionario.");
        } else {
            // Imprimir encabezado del listado
            System.out.println("Listado de Vehículos en el Concesionario:");
            System.out.printf("%-20s%-15s%-15s%-15s%-30s%n", "Marca", "Matrícula", "Precio", "Kilómetros", "Descripción");
            System.out.println("--------------------------------------------------------------------");

            // Iterar sobre cada vehículo y mostrar la información
            for (Vehiculo vehiculo : vehiculos) {
                imprimirInfoVehiculo(vehiculo);
            }

            // Imprimir el total de vehículos en el concesionario
            System.out.println("Total de Vehículos en el Concesionario: " + vehiculos.size());
        }
    }

    // Método auxiliar para imprimir la información de un vehículo
    private void imprimirInfoVehiculo(Vehiculo vehiculo) {
        System.out.printf("%-20s%-15s%-15s%-15s%-30s%n",
                vehiculo.getMarca(), vehiculo.getMatricula(), vehiculo.getPrecio(),
                vehiculo.getKilometros(), vehiculo.getDescripcion());
    }

    /**
     * Método para buscar un vehículo por matrícula e imprimir sus datos.
     *
     * @param matricula La matrícula del vehículo a buscar.
     */
    public void buscarVehiculo(String matricula) {
        Vehiculo vehiculo = concesionario.buscarVehiculo(matricula);

        if (vehiculo != null) {
            System.out.println("Datos del Vehículo con Matrícula " + matricula + ":");
            System.out.println(vehiculo.toString());
        } else {
            System.out.println("No se encontró ningún vehículo con la matrícula " + matricula + ".");
            System.out.println("¿Desea volver a intentarlo? (Sí/No)");

            String respuesta = UtilDatos.entradaTeclado("").toLowerCase();
            if (respuesta.equalsIgnoreCase("si")) {
                // Volver a pedir la matrícula hasta que se encuentre un vehículo
                do {
                    matricula = UtilDatos.entradaTeclado("Ingrese la matrícula del vehículo a buscar:");
                    vehiculo = concesionario.buscarVehiculo(matricula);

                    if (vehiculo != null) {
                        System.out.println("Datos del Vehículo con Matrícula " + matricula + ":");
                        System.out.println(vehiculo.toString());
                        break;
                    } else {
                        System.out.println("No se encontró ningún vehículo con la matrícula " + matricula + ".");
                        System.out.println("¿Desea volver a intentarlo? (Sí/No)");
                        respuesta = UtilDatos.entradaTeclado("").toLowerCase();
                    }
                } while (respuesta.equalsIgnoreCase("si"));
            }
        }
    }

    /**
     * Método para imprimir la información completa de un vehículo por matrícula.
     *
     * @param matricula La matrícula del vehículo a imprimir.
     */
    public void imprimirVehiculoCompleto(String matricula) {
        Vehiculo vehiculo = concesionario.buscarVehiculo(matricula);

        if (vehiculo != null) {
            System.out.println("Vehículo Completo con Matrícula " + matricula + ":");
            System.out.println(vehiculo.toString());
        } else {
            System.out.println("No se encontró ningún vehículo con la matrícula " + matricula + ".");
        }
    }

    /**
     * Método para preguntar y borrar un vehículo por matrícula.
     *
     * @param matricula La matrícula del vehículo a borrar.
     */
    public void preguntarBorrarVehiculo(String matricula) {
        if (concesionario.matriculaExiste(matricula)) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea borrar el vehículo con matrícula " + matricula + "?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                boolean borradoExitoso = concesionario.borrarVehiculo(matricula);

                if (borradoExitoso) {
                    System.out.println("El vehículo con matrícula " + matricula + " ha sido borrado correctamente.");
                } else {
                    System.out.println("Error al intentar borrar el vehículo con matrícula " + matricula + ".");
                }
            } else {
                System.out.println("Operación de borrado cancelada.");
            }
        } else {
            System.out.println("No se encontró ningún vehículo con la matrícula " + matricula + ".");
            System.out.println("¿Desea volver a intentarlo? (Sí/No)");

            String respuesta = UtilDatos.entradaTeclado("").toLowerCase();
            if (respuesta.equalsIgnoreCase("si")) {
                // Volver a pedir la matrícula hasta que se encuentre un vehículo
                do {
                    matricula = UtilDatos.entradaTeclado("Ingrese la matrícula del vehículo a buscar:");
                    Vehiculo vehiculo = concesionario.buscarVehiculo(matricula);

                    if (vehiculo != null) {
                        System.out.println("Datos del Vehículo con Matrícula " + matricula + ":");
                        System.out.println(vehiculo.toString());
                        break;
                    } else {
                        System.out.println("No se encontró ningún vehículo con la matrícula " + matricula + ".");
                        System.out.println("¿Desea volver a intentarlo? (Sí/No)");
                        respuesta = UtilDatos.entradaTeclado("").toLowerCase();
                    }
                } while (respuesta.equalsIgnoreCase("si"));
            }
        }
    }
}
