package suenios;

import excepciones.*;

public class AdoptarHijo extends SuenioSimple {
    private Integer hijosAAdoptar;

    //CONSTRUCTORES
    public AdoptarHijo(Integer felicidonios, Integer hijosAAdoptar) {
        super(felicidonios);
        this.felicidonios=felicidonios;
        this.hijosAAdoptar=hijosAAdoptar;
    }

    //METODOS
    @Override
    public void validar(Persona persona) {
        if (persona.tieneHijos()){
            throw new AdoptarHijoException("No se puede adoptar si se tiene un hijo");
        }
    }

    @Override
    public void realizar(Persona persona) {
        persona.agregarHijos(hijosAAdoptar);
    }
}