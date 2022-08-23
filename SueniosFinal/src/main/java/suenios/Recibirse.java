package suenios;

public class Recibirse extends SuenioSimple {
    private String carrera;

    //CONSTRUCTORES
    public Recibirse(Integer felicidonios, String carrera) {
        super(felicidonios);
        this.felicidonios = felicidonios;
        this.carrera = carrera;
    }

    //METODOS
    @Override
    public void validar(Persona persona) {
        if (!persona.quiereEstudiar(carrera)) {
            throw new RuntimeException("Quiere estudiar una carrera que no desea");
        }
        if (persona.completoCarrera(carrera)) {
            throw new RuntimeException("Ya te recibiste de esta carrera");
        }
    }

    @Override
    public void realizar(Persona persona) {
        persona.completarCarrera(carrera);
    }
}
