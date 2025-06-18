package ar.com.usuarioservice.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EMPLEADO")
public class Empleado extends Usuario {
    private String puesto;
    private Long concessionId;  // Concesionaria donde trabaja

    protected Empleado() {}

    public Empleado(String nombre, String email, String dni, String puesto, Long concessionId){
        super(nombre, email, dni);
        setPuesto(puesto);
        setConcessionId(concessionId);
    }

    //Getters and Setters
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Long getConcessionId() {
        return concessionId;
    }

    public void setConcessionId(Long concessionId) {
        this.concessionId = concessionId;
    }
}
