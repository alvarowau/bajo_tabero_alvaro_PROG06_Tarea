package com.alvarobajo.tare6;

import com.alvarobajo.tare6.data.Concesionario;
import com.alvarobajo.tare6.data.DatosPrueba;
import com.alvarobajo.tare6.model.Vehiculo;
import com.alvarobajo.tare6.util.MostrarDatos;
import com.alvarobajo.tare6.util.UtilComprobaciones;
import com.alvarobajo.tare6.util.UtilDatos;

import java.util.List;

/**
 * La clase Main es la clase principal que contiene el método main
 * para ejecutar la aplicación de gestión de vehículos en un concesionario.
 * Proporciona un menú interactivo para que el usuario realice diversas acciones.
 * Utiliza un objeto de la clase Concesionario para gestionar la información de los vehículos.
 *
 * @author Álvaro Bajo
 * @company BriandaMendoza-Programacion
 * @version 1.0
 */
public class Main {

    // Atributos

    private static MostrarDatos mostrarDatos;
    private static Concesionario concesionario;

    // Métodos

    /**
     * El método main es el punto de entrada principal para la aplicación.
     * Inicializa el concesionario, carga vehículos de prueba y muestra un menú interactivo.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        concesionario = new Concesionario();
        mostrarDatos = new MostrarDatos(concesionario);

        cargarVehiculosDePrueba();

        int opcion;
        String opcionTxt;

        do {
            mostrarMenuPrincipal();

            do {
                opcionTxt = UtilDatos.entradaTeclado("Seleccione una opción: ");
            } while (!UtilComprobaciones.esEnteroPositivo(opcionTxt));

            try {
                opcion = Integer.parseInt(opcionTxt);
                realizarAccion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduce un número válido.");
                opcion = -1;
            }

        } while (opcion != 6);
    }

    /**
     * Muestra el menú principal en la consola con las opciones disponibles.
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("1. Nuevo Vehículo");
        System.out.println("2. Listar Vehiculos");
        System.out.println("3. Buscar Vehiculo");
        System.out.println("4. Modificar kms Vehículo");
        System.out.println("5. Borrar vehiculo");
        System.out.println("6. Salir");
    }

    /**
     * Realiza la acción correspondiente según la opción seleccionada por el usuario.
     *
     * @param opcion La opción seleccionada por el usuario.
     */
    private static void realizarAccion(int opcion) {
        switch (opcion) {
            case 1:
                agregarNuevoVehiculo();
                break;
            case 2:
                listarVehiculos();
                break;
            case 3:
                buscarVehiculo();
                break;
            case 4:
                modificarKilometros();
                break;
            case 5:
                borrarVehiculo();
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    }

    /**
     * Agrega un nuevo vehículo al concesionario después de que el usuario ingrese los detalles.
     */
    private static void agregarNuevoVehiculo() {
        Vehiculo nuevoVehiculo = UtilDatos.crearVehiculo(concesionario);
        if (nuevoVehiculo != null) {
            String resultado = concesionario.insertarVehiculo(nuevoVehiculo);
            System.out.println(resultado);
        } else {
            System.out.println("Error: No se pudo crear el vehículo.");
        }
    }

    /**
     * Muestra la lista de vehículos disponibles en el concesionario.
     */
    private static void listarVehiculos() {
        mostrarDatos.mostrarListaVehiculos();
    }

    /**
     * Busca un vehículo en el concesionario según la matrícula ingresada por el usuario.
     */
    private static void buscarVehiculo() {
        String matricula = UtilDatos.entradaTeclado("Ingrese la matrícula del vehículo a buscar:");
        mostrarDatos.buscarVehiculo(matricula);
    }

    /**
     * Modifica los kilómetros de un vehículo después de la entrada del usuario.
     */
    private static void modificarKilometros() {
        String matricula;
        String nuevosKms;
        boolean matriculaValida = false;
        boolean numeroValido = false;

        do {
            matricula = UtilDatos.entradaTeclado("Ingrese la matrícula del vehículo a modificar:");

            if (concesionario.matriculaExiste(matricula)) {
                matriculaValida = true;
            } else {
                System.out.println("Error: No existe un vehículo con esa matrícula.");
                System.out.println("¿Desea volver a introducir la matrícula? (Sí/No)");

                String respuesta = UtilDatos.entradaTeclado("").toLowerCase();
                if (!respuesta.equals("si")) {
                    return; // Salir del método si el usuario no desea volver a introducir la matrícula
                }
            }

        } while (!matriculaValida);

        do {
            nuevosKms = UtilDatos.entradaTeclado("Ingrese la nueva cantidad de kilómetros:");

            if (UtilComprobaciones.esEnteroPositivo(nuevosKms)) {
                numeroValido = true;
            } else {
                System.out.println("Error: La cantidad de kilómetros debe ser un número entero positivo.");
                System.out.println("¿Desea volver a introducir la cantidad de kilómetros? (Sí/No)");

                String respuesta = UtilDatos.entradaTeclado("").toLowerCase();
                if (!respuesta.equals("si")) {
                    return; // Salir del método si el usuario no desea volver a introducir la cantidad de kilómetros
                }
            }

        } while (!numeroValido);

        // Convertir la cantidad de kilómetros a un entero
        int KmNumerico = Integer.parseInt(nuevosKms);

        // Llamamos al método para modificar los kilómetros del vehículo
        mostrarDatos.modificarKMDeVehiculo(matricula, KmNumerico);
    }

    /**
     * Carga vehículos de prueba en el concesionario.
     */
    private static void cargarVehiculosDePrueba() {
        // Obtener la lista de vehículos de prueba
        List<Vehiculo> vehiculosDePrueba = DatosPrueba.obtenerVehiculosDePrueba();

        // Agregar los vehículos al concesionario
        for (Vehiculo vehiculo : vehiculosDePrueba) {
            concesionario.insertarVehiculo(vehiculo);
        }
    }

    /**
     * Solicita al usuario la matrícula y pregunta si desea borrar el vehículo correspondiente.
     */
    private static void borrarVehiculo() {
        String matricula = UtilDatos.entradaTeclado("Ingrese la matrícula del vehículo a borrar:");
        mostrarDatos.preguntarBorrarVehiculo(matricula);
    }
}
