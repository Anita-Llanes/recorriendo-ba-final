package com.recorriendoba.tours.model;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ItemReserva {
    private Tour tour;
    private Integer tourId;
    private Integer cantidad;
    private Double precioUnitario;
    private Double precioTotal;
    private java.time.LocalDate fechaReserva;
    private java.time.LocalTime horaReserva;
    private String nombreCliente;
    private String emailCliente;
    private String telefonoCliente;
    private java.time.LocalDate fechaCreacion;
    private java.time.LocalDate fechaActualizacion;
    private String estadoReserva;
    private String metodoPago;
    private String numeroTarjeta;
    private String nombreApellidoTitularTarjeta;
    private String tipoTarjeta;
    private Integer fechaExpiracion;
    private String codigoSeguridad;
    private String direccionFacturacion;
    private String ciudadFacturacion;
    private String paisFacturacion;
    private String codigoPostalFacturacion;
    private String estadoFacturacion;
    private String nombreTitular;
    private String apellidoTitular;
    private String numeroDocumento;
    private String tipoDocumento;
    private String nacionalidad;
    private String genero;
    private java.time.LocalDate fechaNacimiento;
    private String lugarNacimiento;
    private String itemReservaId;
    
}
