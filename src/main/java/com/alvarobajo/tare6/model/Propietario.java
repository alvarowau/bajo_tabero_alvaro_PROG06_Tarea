package com.alvarobajo.tare6.model;

import java.io.Serializable;

/**
 * La clase Propietario representa a la persona dueña de un vehículo.
 * Contiene información como el nombre, apellidos y DNI del propietario.
 *
 * @author Álvaro Bajo
 * @company BriandaMendoza-Programacion
 * @version 1.0
 */
public class Propietario implements Serializable {

    /**
     * El nombre del propietario del vehículo.
     */
    private String nombrePropietario;

    /**
     * El primer apellido del propietario.
     */
    private String apellido1;

    /**
     * El segundo apellido del propietario.
     */
    private String apellido2;

    /**
     * El DNI del propietario del vehículo.
     */
    private String dniPropietario;

    /**
     * Constructor de la clase Propietario.
     *
     * @param nombrePropietario El nombre del propietario.
     * @param apellido1 El primer apellido del propietario.
     * @param apellido2 El segundo apellido del propietario.
     * @param dniPropietario El DNI del propietario.
     */
    public Propietario(String nombrePropietario, String apellido1, String apellido2, String dniPropietario) {
        this.nombrePropietario = nombrePropietario;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dniPropietario = dniPropietario;
    }

    /**
     * Obtiene el nombre del propietario.
     *
     * @return El nombre del propietario.
     */
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    /**
     * Establece el nombre del propietario.
     *
     * @param nombrePropietario El nuevo nombre del propietario.
     */
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    /**
     * Obtiene el primer apellido del propietario.
     *
     * @return El primer apellido del propietario.
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Establece el primer apellido del propietario.
     *
     * @param apellido1 El nuevo primer apellido del propietario.
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Obtiene el segundo apellido del propietario.
     *
     * @return El segundo apellido del propietario.
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Establece el segundo apellido del propietario.
     *
     * @param apellido2 El nuevo segundo apellido del propietario.
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Obtiene el DNI del propietario.
     *
     * @return El DNI del propietario.
     */
    public String getDniPropietario() {
        return dniPropietario;
    }

    /**
     * Establece el DNI del propietario.
     *
     * @param dniPropietario El nuevo DNI del propietario.
     */
    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    /**
     * Devuelve una representación en cadena del propietario.
     *
     * @return Una cadena formateada con la información del propietario.
     */
    @Override
    public String toString() {
        return String.format("Propietario:%n" +
                        "  Nombre:          %s%n" +
                        "  Apellido1:       %s%n" +
                        "  Apellido2:       %s%n" +
                        "  DNI:             %s%n",
                nombrePropietario, apellido1, apellido2, dniPropietario);
    }
}
