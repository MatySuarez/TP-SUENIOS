package suenios;

public class Viajar extends SuenioSimple {
    private String lugar;

    //CONSTRUCTORES
    public Viajar(Integer felicidonios, String lugar) {
        super(felicidonios);
        this.felicidonios = felicidonios;
        this.lugar = lugar;
    }

    //METODOS
    @Override
    public void validar(Persona persona) {
        if(persona.visitoLugar(lugar)){
            throw new RuntimeException("Esta tratando de viajar a un lugar visitado");
        }
    }

    @Override
    public void realizar(Persona persona) {
        persona.viajarA(lugar);
    }

}
