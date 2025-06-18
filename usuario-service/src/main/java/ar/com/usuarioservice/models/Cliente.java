package ar.com.usuarioservice.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CLIENTE")
public class Cliente extends Usuario {

    private String direccion;
    private String telefono;

    protected Cliente() {}

    public Cliente(String nombre, String email, String dni, String direccion, String telefono){
        super(nombre, email, dni);
        setDireccion(direccion);
        setTelefono(telefono);
    }

    //Getters and Setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
