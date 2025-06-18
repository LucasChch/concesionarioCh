package ar.com.usuarioservice.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EMPLEADO")
public class Empleado extends Usuario {
    private String puesto;
    private Long sucursalId;  // Concesionaria donde trabaja

    protected Empleado() {}

    public Empleado(String nombre, String email, String dni, String puesto, Long sucursalId){
        super(nombre, email, dni);
        setPuesto(puesto);
        setSucursalId(sucursalId);
    }

    //Getters and Setters
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
    }
}
