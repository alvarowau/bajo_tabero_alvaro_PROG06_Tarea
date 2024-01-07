package com.alvarobajo.tare6.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * La clase UtilComprobaciones proporciona métodos para validar diferentes tipos de datos.
 * También incluye métodos para verificar el formato de DNI, matrícula, nombre completo y obtener una fecha válida.
 *
 * @author Álvaro Bajo
 * @company BriandaMendoza-Programacion
 * @version 1.0
 */
public class UtilComprobaciones {

    /**
     * Método que valida si una cadena representa una cantidad de dinero válida.
     *
     * @param str La cadena a validar.
     * @return true si es una cantidad válida, false si hay errores.
     */
    public static boolean esCantidadValida(String str) {
        try {
            if (str == null) {
                System.out.println("Error: No hemos recibido una cantidad de dinero.");
                return false;
            }
            BigDecimal cantidad = new BigDecimal(str);
            // Validar que la cantidad no sea negativa
            if (cantidad.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("Error: La cantidad de dinero no puede ser negativa.");
                return false;
            }
            // Validar la escala (número de decimales)
            if (cantidad.scale() > 2) {
                System.out.println("Error: La cantidad de dinero no puede tener más de dos decimales.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: Introduce una cantidad de dinero válida.");
            return false;
        }
    }

    /**
     * Método que valida si una cadena representa un valor entero positivo.
     *
     * @param str La cadena a validar.
     * @return true si es un valor entero positivo, false si hay errores.
     */
    public static boolean esEnteroPositivo(String str) {
        try {
            if (str == null) {
                System.out.println("Error: No hemos recibido un valor entero positivo.");
                return false;
            }
            int valor = Integer.parseInt(str);
            // Validar que el valor sea positivo y mayor que cero
            if (valor > 0) {
                return true;
            } else {
                System.out.println("Error: Introduce un valor entero positivo mayor que cero.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Introduce un valor entero válido.");
            return false;
        }
    }

    /**
     * Método que valida si una cadena tiene el formato de DNI español válido.
     *
     * @param dni La cadena a validar.
     * @return true si el formato es válido, false si hay errores.
     */
    public static boolean esFormatoDNIValido(String dni) {
        // Expresión regular para validar el formato del DNI
        String regexDNI = "\\d{8}[A-HJ-NP-TV-Z]";
        if (dni == null) {
            System.out.println("Error: No hemos recibido un DNI.");
            return false;
        }
        if (dni.matches(regexDNI)) {
            return true;
        } else {
            System.out.println("Error: Introduce un DNI válido (8 dígitos seguidos de una letra).");
            return false;
        }
    }

    /**
     * Método que valida si una cadena tiene el formato de matrícula español válido.
     *
     * @param matricula La cadena a validar.
     * @return true si el formato es válido, false si hay errores.
     */
    public static boolean esFormatoMatriculaValido(String matricula) {
        // Expresión regular para validar el formato de la matrícula
        String regexMatricula = "[0-9]{4}[A-Z]{3}";

        if (matricula == null) {
            System.out.println("Error: No hemos recibido una matrícula.");
            return false;
        }

        if (matricula.matches(regexMatricula)) {
            return true;
        } else {
            System.out.println("Error: Introduce una matrícula válida (formato: NNNNLLL).");
            return false;
        }
    }

    /**
     * Método que valida si las partes del nombre completo tienen un formato válido.
     *
     * @param nombre   El nombre del propietario.
     * @param apellido1 El primer apellido del propietario.
     * @param apellido2 El segundo apellido del propietario.
     * @return true si el formato es válido, false si hay errores.
     */
    public static boolean esFormatoNombreValido(String nombre, String apellido1, String apellido2) {
        if (nombre == null || apellido1 == null || apellido2 == null) {
            System.out.println("Error: No hemos recibido información completa del propietario.");
            return false;
        }
        // Verificar que haya al menos un nombre y dos apellidos
        if (!nombre.isEmpty() && !apellido1.isEmpty() && !apellido2.isEmpty()) {
            // Unir las partes para obtener el nombre completo
            String nombreCompleto = nombre + " " + apellido1 + " " + apellido2;
            // Verificar que la longitud total no exceda de 40 caracteres
            if (nombreCompleto.length() <= 40) {
                return true;
            } else {
                System.out.println("Error: La longitud del nombre completo excede de 40 caracteres.");
            }
        } else {
            System.out.println("Error: Introduce un nombre completo de propietario válido (al menos un nombre y dos apellidos).");
        }
        return false;
    }

    /**
     * Método que valida si una cadena de texto no está vacía.
     *
     * @param texto Cadena de texto a validar.
     * @return true si la cadena no está vacía, false si está vacía.
     */
    public static boolean esTextoNoVacio(String texto) {
        // Verificar si la cadena de texto no es nula y no está vacía después de quitar espacios en blanco al inicio y al final.
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Método que pide al usuario ingresar una fecha en formato válido (yyyy-MM-dd).
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @return LocalDate si la fecha es válida, null si hay un error.
     */
    public static LocalDate pedirFechaValida(String mensaje) {
        do {
            // Solicitar al usuario que ingrese la fecha mediante el método entradaTeclado
            String inputFecha = UtilDatos.entradaTeclado(mensaje);

            try {
                // Intentar convertir la cadena de entrada en LocalDate
                LocalDate fecha = LocalDate.parse(inputFecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                // Verificar si la fecha es anterior o igual a la fecha actual
                if (fecha.isBefore(LocalDate.now()) || fecha.isEqual(LocalDate.now())) {
                    // Devolver la fecha si es válida
                    return fecha;
                } else {
                    System.out.println("Error: La fecha de matriculación no puede ser en el futuro.");
                }
            } catch (Exception e) {
                System.out.println("Error: Formato de fecha inválido. Por favor, ingrese una fecha en el formato yyyy-MM-dd.");
            }

        } while (true);
    }
}
