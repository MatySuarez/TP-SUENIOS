package suenios;

import java.util.Comparator;
import java.util.List;

public class Alocado implements TipoPersona{

    @Override
    public Suenio elegirSuenio(List<Suenio> sueniosPendientes){
        return sueniosPendientes.stream().findAny().get();
    }

}
