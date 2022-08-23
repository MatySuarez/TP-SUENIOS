package basededatos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class dbPersona {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String suenio;

    public dbPersona() {
        super();
    }

    public dbPersona(String nombre, String apellido, Integer edad, String suenio) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.suenio = suenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSuenio() {
        return suenio;
    }

    public void setSuenio(String suenio) {
        this.suenio = suenio;
    }

}
