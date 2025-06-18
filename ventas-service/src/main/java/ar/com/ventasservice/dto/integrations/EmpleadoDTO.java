package ar.com.ventasservice.dto.integrations;

public class EmpleadoDTO {
    private Long id;
    private String nombre;
    private String email;
    private String dni;
    private String puesto;
    private Long concessionId;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

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
