package com.alvarobajo.tare6.data;

import com.alvarobajo.tare6.model.Propietario;
import com.alvarobajo.tare6.model.Vehiculo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase DatosPrueba proporciona datos de prueba para la aplicación.
 * Incluye 22 vehículos y 4 propietarios predefinidos.
 *
 * @author Álvaro Bajo
 * @company BriandaMendoza-Programacion
 * @version 1.0
 */
public class DatosPrueba {

    /**
     * Obtiene una lista de 22 vehículos de prueba con propietarios predefinidos.
     *
     * @return Lista de vehículos de prueba.
     */
    public static List<Vehiculo> obtenerVehiculosDePrueba() {
        List<Vehiculo> vehiculos = new ArrayList<>();

        Propietario propietario1 = new Propietario("Alvaro", "Bajo", "Tabero", "12345678A");
        Propietario propietario2 = new Propietario("María", "López", "Fernández", "87654321B");
        Propietario propietario3 = new Propietario("Pedro", "Martínez", "García", "56789012C");
        Propietario propietario4 = new Propietario("Laura", "Sánchez", "Jiménez", "98765432D");

        vehiculos.add(new Vehiculo("Seat Ibiza", 50000, LocalDate.of(2020, 5, 15),
                "Coche compacto en excelente estado", new BigDecimal("12000.00"), "1234ABC", propietario1));

        vehiculos.add(new Vehiculo("Renault Megane", 70000, LocalDate.of(2019, 8, 20),
                "Vehículo familiar con bajo consumo", new BigDecimal("15000.00"), "5678XYZ", propietario2));

        vehiculos.add(new Vehiculo("Ford Fiesta", 30000, LocalDate.of(2021, 2, 10),
                "Pequeño y ágil, perfecto para la ciudad", new BigDecimal("10000.00"), "9999ZZZ", propietario3));

        vehiculos.add(new Vehiculo("Volkswagen Golf", 60000, LocalDate.of(2018, 11, 5),
                "Diseño clásico y eficiencia", new BigDecimal("18000.00"), "4567LMN", propietario4));

        vehiculos.add(new Vehiculo("Toyota Corolla", 45000, LocalDate.of(2020, 9, 25),
                "Sedán confiable y económico", new BigDecimal("16000.00"), "1111ABC", propietario1));

        vehiculos.add(new Vehiculo("Peugeot 208", 35000, LocalDate.of(2017, 6, 12),
                "Estilo moderno y consumo reducido", new BigDecimal("14000.00"), "2222XYZ", propietario2));

        vehiculos.add(new Vehiculo("Honda Civic", 55000, LocalDate.of(2019, 4, 3),
                "Deportividad y eficiencia combinadas", new BigDecimal("20000.00"), "3333ZZZ", propietario3));

        vehiculos.add(new Vehiculo("Hyundai i30", 40000, LocalDate.of(2018, 10, 30),
                "Calidad y buen equipamiento", new BigDecimal("17000.00"), "4444LMN", propietario4));

        vehiculos.add(new Vehiculo("Mazda CX-5", 80000, LocalDate.of(2016, 12, 8),
                "SUV espacioso y cómodo", new BigDecimal("22000.00"), "5555ABC", propietario1));

        vehiculos.add(new Vehiculo("Kia Sportage", 60000, LocalDate.of(2017, 7, 18),
                "Diseño atractivo y tecnología avanzada", new BigDecimal("19000.00"), "6666XYZ", propietario2));

        vehiculos.add(new Vehiculo("Audi A3", 55000, LocalDate.of(2018, 4, 22),
                "Elegancia y rendimiento en un compacto", new BigDecimal("25000.00"), "7777ZZZ", propietario3));

        vehiculos.add(new Vehiculo("Mercedes-Benz C-Class", 70000, LocalDate.of(2017, 1, 14),
                "Lujo y confort en un sedán premium", new BigDecimal("30000.00"), "8888LMN", propietario4));


        vehiculos.add(new Vehiculo("Ford Focus", 40000, LocalDate.of(2019, 10, 1),
                "Compacto y eficiente", new BigDecimal("16000.00"), "123XYZ", propietario1));

        vehiculos.add(new Vehiculo("Chevrolet Cruze", 55000, LocalDate.of(2018, 6, 5),
                "Estilo moderno y buena potencia", new BigDecimal("18000.00"), "456ABC", propietario2));

        vehiculos.add(new Vehiculo("Nissan Qashqai", 60000, LocalDate.of(2020, 3, 12),
                "SUV popular y versátil", new BigDecimal("20000.00"), "789XYZ", propietario3));

        vehiculos.add(new Vehiculo("BMW 3 Series", 50000, LocalDate.of(2018, 9, 18),
                "Sedán premium con elegancia", new BigDecimal("25000.00"), "101LMN", propietario4));

        vehiculos.add(new Vehiculo("Volkswagen Polo", 35000, LocalDate.of(2017, 4, 25),
                "Pequeño pero potente", new BigDecimal("14000.00"), "202ZZZ", propietario1));

        vehiculos.add(new Vehiculo("Mercedes-Benz GLC", 75000, LocalDate.of(2016, 11, 30),
                "SUV de lujo con gran confort", new BigDecimal("28000.00"), "303ABC", propietario2));

        vehiculos.add(new Vehiculo("Hyundai Tucson", 48000, LocalDate.of(2019, 7, 8),
                "SUV compacto y eficiente", new BigDecimal("19000.00"), "404XYZ", propietario3));

        vehiculos.add(new Vehiculo("Audi Q5", 65000, LocalDate.of(2018, 5, 3),
                "SUV premium con prestaciones", new BigDecimal("30000.00"), "505ABC", propietario4));

        vehiculos.add(new Vehiculo("Renault Clio", 30000, LocalDate.of(2021, 1, 14),
                "Pequeño y ágil para la ciudad", new BigDecimal("12000.00"), "606ZZZ", propietario1));

        vehiculos.add(new Vehiculo("Toyota RAV4", 70000, LocalDate.of(2018, 8, 22),
                "SUV espacioso y fiable", new BigDecimal("22000.00"), "707XYZ", propietario2));

        return vehiculos;
    }
}

