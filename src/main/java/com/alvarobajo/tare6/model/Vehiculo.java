package com.alvarobajo.tare6.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * La clase Vehiculo representa un vehículo con información como la marca, kilómetros,
 * fecha de matriculación, descripción, precio, matrícula y propietario.
 *
 * @author Álvaro Bajo
 * @company BriandaMendoza-Programacion
 * @version 1.0
 */
public class Vehiculo implements Serializable {

    private String marca;
    private int kilometros;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private BigDecimal precio;
    private String matricula;
    private Propietario propietario;

    /**
     * Constructor de la clase Vehiculo.
     *
     * @param marca             La marca del vehículo.
     * @param kilometros        Los kilómetros del vehículo.
     * @param fechaMatriculacion La fecha de matriculación del vehículo.
     * @param descripcion       La descripción del vehículo.
     * @param precio            El precio del vehículo.
     * @param matricula         La matrícula del vehículo.
     * @param propietario       El propietario del vehículo.
     */
    public Vehiculo(String marca, int kilometros, LocalDate fechaMatriculacion,
                    String descripcion, BigDecimal precio,
                    String matricula, Propietario propietario) {
        this.marca = marca;
        this.kilometros = kilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        // Dos decimales para el precio, redondeado hacia arriba
        this.precio = precio.setScale(2, RoundingMode.HALF_UP);
        this.matricula = matricula;
        this.propietario = propietario;
    }

    // Getters y Setters

    /**
     * Obtiene la marca del vehículo.
     *
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     *
     * @param marca La nueva marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene los kilómetros del vehículo.
     *
     * @return Los kilómetros del vehículo.
     */
    public int getKilometros() {
        return kilometros;
    }

    /**
     * Establece los kilómetros del vehículo.
     *
     * @param kilometros Los nuevos kilómetros del vehículo.
     */
    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    /**
     * Obtiene la fecha de matriculación del vehículo.
     *
     * @return La fecha de matriculación del vehículo.
     */
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    /**
     * Establece la fecha de matriculación del vehículo.
     *
     * @param fechaMatriculacion La nueva fecha de matriculación del vehículo.
     */
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    /**
     * Obtiene la descripción del vehículo.
     *
     * @return La descripción del vehículo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del vehículo.
     *
     * @param descripcion La nueva descripción del vehículo.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del vehículo.
     *
     * @return El precio del vehículo.
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del vehículo.
     *
     * @param precio El nuevo precio del vehículo.
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la matrícula del vehículo.
     *
     * @return La matrícula del vehículo.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del vehículo.
     *
     * @param matricula La nueva matrícula del vehículo.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene el propietario del vehículo.
     *
     * @return El propietario del vehículo.
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * Establece el propietario del vehículo.
     *
     * @param propietario El nuevo propietario del vehículo.
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    /**
     * Devuelve una representación en cadena del vehículo.
     *
     * @return Una cadena formateada con la información del vehículo.
     */
    @Override
    public String toString() {
        return String.format("Vehiculo:%n" +
                        "  Marca:           %s%n" +
                        "  Kilómetros:      %d%n" +
                        "  Fecha Matriculación: %s%n" +
                        "  Descripción:     %s%n" +
                        "  Precio:          %.2f%n" +
                        "  Matrícula:       %s%n" +
                        "  Propietario:     %s%n",
                marca, kilometros, fechaMatriculacion, descripcion, precio, matricula, propietario);
    }
}
