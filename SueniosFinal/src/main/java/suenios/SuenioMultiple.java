package suenios;

import java.util.ArrayList;
import java.util.List;

public class SuenioMultiple extends Suenio{
    private final List<Suenio> sueniosMultiples;

    //CONSTRUCTORES
    public SuenioMultiple(Integer felicidonios, List<Suenio> sueniosMultiples) {
        super(felicidonios);
        this.sueniosMultiples = sueniosMultiples;
    }

    //METODOS
    @Override
    public void validar(Persona persona) {
        sueniosMultiples.forEach(suenio -> suenio.validar(persona));
    }

    @Override
    public void realizar(Persona persona) {
        sueniosMultiples.forEach(suenio -> suenio.realizar(persona));
    }

    @Override
    public Integer felicidonios() {
        return sueniosMultiples.stream().mapToInt(suenio -> suenio.felicidonios()).sum();
    }

}
