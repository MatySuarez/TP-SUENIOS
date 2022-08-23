package suenios;

import excepciones.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Persona {
    private String nombre;
    private List<Suenio> suenio;
    private Integer felicidonios;
    private Integer cantidadHijos = 0;
    private TipoPersona tipoPersona;

    private List<String> lugaresVisitados = new ArrayList<>();
    private List<String> carrerasQueQuiereEstudiar = new ArrayList<>();
    private List<String> carrerasCompletadas = new ArrayList<>();

    private Integer sueldoPretendido;

    //CONSTRUCTORES

    public Persona(String nombre, List<Suenio> suenio, Integer felicidonios, TipoPersona tipoPersona){
        this.nombre = nombre;
        this.suenio = suenio;
        this.felicidonios = felicidonios;
        this.tipoPersona = tipoPersona;
    }

    //GETTERS
    public List<Suenio>getSuenios(){return suenio;}

    public Integer getFelicidonios(){return felicidonios;}

    public Integer getFelicidoniosPendientes(){return sueniosPendientes().mapToInt(Suenio::felicidonios).sum();}

    public List<String> getCarrerasCompletadas() {return carrerasCompletadas;}

    public List<String> getLugaresVisitados(){return lugaresVisitados;}

    public Integer getCantidadHijos(){return cantidadHijos;}

    public Integer getSueldoPretendido(){return sueldoPretendido;}

    //SETTERS

    public void setCarrerasQueQuiereEstudiar(List<String> carrerasQueQuiereEstudiar){this.carrerasQueQuiereEstudiar = carrerasQueQuiereEstudiar;}

    public void setSueldoPretendido(Integer sueldoPretendido){this.sueldoPretendido = sueldoPretendido;}


    //METODOS

    public void cumplir(Suenio suenio) {
        if (!sueniosPendientes().toList().contains(suenio)){
            throw new SuenioNoPendienteException("El suenio " + suenio + "no esta pendiente");
        }
        suenio.cumplir(this);
    }

    public Stream<Suenio> sueniosPendientes(){return suenio.stream().filter(Suenio::estaPendiente);}

    public void sumarFelicidad(Integer felicidonios){
        this.felicidonios += felicidonios;
    }

    public Boolean tieneHijos(){
        return this.cantidadHijos > 0;
    }

    public void agregarHijos(Integer hijosAAdoptar) {
        this.cantidadHijos += hijosAAdoptar;
    }

    public void cumplirSuenioElegido() {
        Suenio suenioElegido = tipoPersona.elegirSuenio(sueniosPendientes().toList());
        cumplir(suenioElegido);
    }

    public Boolean visitoLugar(String lugar){
        return this.lugaresVisitados.contains(lugar);
    }

    public void viajarA(String lugar) {
        this.lugaresVisitados.add(lugar);
    }



    public Boolean quiereEstudiar(String carrera){
        return this.carrerasQueQuiereEstudiar.contains(carrera);
    }

    public Boolean completoCarrera(String carrera) {
        return this.carrerasCompletadas.contains(carrera);
    }

    public void completarCarrera(String carrera) {
        this.carrerasCompletadas.add(carrera);
    }

    //METODOS

    public Boolean esFeliz(){
        return this.felicidonios > getFelicidoniosPendientes();
    }

    public Boolean esAmbiciosa(){
        return suenio.stream().mapToInt(Suenio::felicidonios).sum() > 100;
    }


    //TIENE SUELDO
    public Boolean tieneSueldo(Integer sueldoPretendido){return this.sueldoPretendido > sueldoPretendido;}

}
