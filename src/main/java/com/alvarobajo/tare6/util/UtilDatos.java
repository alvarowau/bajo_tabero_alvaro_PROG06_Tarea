package com.alvarobajo.tare6.util;

import com.alvarobajo.tare6.data.Concesionario;
import com.alvarobajo.tare6.model.Propietario;
import com.alvarobajo.tare6.model.Vehiculo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * La clase UtilDatos proporciona métodos para la entrada de datos desde el teclado y la creación de objetos Propietario y Vehiculo.
 * También incluye métodos para validar DNI, matrícula, cantidades y números enteros positivos.
 *
 * @author Álvaro Bajo
 * @company BriandaMendoza-Programacion
 * @version 1.0
 */
public class UtilDatos {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Método que solicita al usuario una entrada de texto desde el teclado.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @return La cadena de texto ingresada por el usuario.
     */
    public static String entradaTeclado(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    /**
     * Método que crea un objeto Propietario a partir de la entrada del usuario.
     *
     * @return Un objeto Propietario válido.
     */
    public static Propietario crearPropietario() {
        Propietario propietario = null;

        do {
            String nombrePropietario = entradaTeclado("Ingrese el nombre, apellido1 y apellido2 del propietario (separados por espacios):");
            String[] partes = nombrePropietario.split(" ");

            if (partes.length == 3 && UtilComprobaciones.esFormatoNombreValido(partes[0], partes[1], partes[2])) {
                String dniPropietario = pedirDNIValido();
                propietario = new Propietario(partes[0], partes[1], partes[2], dniPropietario);
            } else {
                System.out.println("Formato incorrecto del nombre completo. Por favor, vuelva a ingresar los datos.");
            }

        } while (propietario == null);

        return propietario;
    }

    private static String pedirDNIValido() {
        String dni;

        do {
            dni = entradaTeclado("Ingrese el DNI del propietario:");
        } while (!UtilComprobaciones.esFormatoDNIValido(dni));

        return dni;
    }

    /**
     * Método que crea un objeto Vehiculo a partir de la entrada del usuario.
     *
     * @param concesionario El concesionario que se utilizará para verificar la existencia de la matrícula.
     * @return Un objeto Vehiculo válido.
     */
    public static Vehiculo crearVehiculo(Concesionario concesionario) {
        Vehiculo vehiculo = null;

        String marca;
        int kilometros;
        LocalDate fechaMatriculacion;
        String descripcion;
        BigDecimal precio;
        String matricula;
        Propietario propietario;

        while (true) {
            marca = entradaTeclado("Ingrese la marca del vehículo:");

            kilometros = pedirEnteroPositivo("Ingrese la cantidad de kilómetros recorridos por el vehículo:");

            fechaMatriculacion = UtilComprobaciones.pedirFechaValida("Ingrese la fecha de matriculación del vehículo (formato: yyyy-MM-dd):");

            descripcion = entradaTeclado("Ingrese una descripción del vehículo:");

            precio = pedirCantidadValida("Ingrese el precio del vehículo:");

            matricula = pedirMatriculaValida(concesionario);

            propietario = crearPropietario();

            if (propietario == null) {
                continue;
            }

            vehiculo = new Vehiculo(marca, kilometros, fechaMatriculacion, descripcion, precio, matricula, propietario);
            break;
        }

        return vehiculo;
    }

    private static int pedirEnteroPositivo(String mensaje) {
        int valor;

        do {
            String input = entradaTeclado(mensaje);
            if (!UtilComprobaciones.esEnteroPositivo(input)) {
                System.out.println("Error: Ingrese un valor entero positivo.");
            } else {
                valor = Integer.parseInt(input);
                break;
            }
        } while (true);

        return valor;
    }

    private static BigDecimal pedirCantidadValida(String mensaje) {
        BigDecimal valor;

        do {
            String input = entradaTeclado(mensaje);
            if (!UtilComprobaciones.esCantidadValida(input)) {
                System.out.println("Error: Ingrese un número válido y mayor que 0.");
            } else {
                valor = new BigDecimal(input);
                break;
            }
        } while (true);

        return valor;
    }

    private static String pedirMatriculaValida(Concesionario concesionario) {
        String matricula;

        do {
            matricula = entradaTeclado("Ingrese la matrícula del vehículo:");
            if (!UtilComprobaciones.esFormatoMatriculaValido(matricula)) {
                System.out.println("Error: El formato de la matrícula no es válido.");
            } else if (concesionario.matriculaExiste(matricula)) {
                System.out.println("Error: La matrícula ya existe en el concesionario.");
            } else {
                break;
            }
        } while (true);

        return matricula;
    }
}
