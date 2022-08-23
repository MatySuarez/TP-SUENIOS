package suenios;

public class TenerHijos extends SuenioSimple {
    private Integer cantidadHijos;

    //CONSTRUCTORES
    public TenerHijos(Integer felicidonios, Integer cantidadHijos) {
        super(felicidonios);
        this.felicidonios = felicidonios;
        this.cantidadHijos = cantidadHijos;
    }

    //METODOS
    @Override
    public void validar(Persona persona) {
    }

    @Override
    public void realizar(Persona persona) {
        persona.agregarHijos(cantidadHijos);
    }
}
