package ar.com.sucursalservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String direccion;

    @NotBlank
    private String pais;

    @FutureOrPresent
    private LocalDate fechaApertura;

    //Constructors
    protected Sucursal() {}

    public Sucursal(String nombre, String direccion, String pais, LocalDate fechaApertura) {
        setNombre(nombre);
        setDireccion(direccion);
        setPais(pais);
        setFechaApertura(fechaApertura);
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
}
