package suenios;

import excepciones.*;

public class Trabajar extends SuenioSimple {
    private Integer sueldoPretendido;

    //CONSTRUCTOR
    public Trabajar(Integer felicidonios, Integer sueldoPretendido){
        super(felicidonios);
        this.felicidonios=felicidonios;
        this.sueldoPretendido=sueldoPretendido;
    }

    //METODOS
    @Override
    public void validar(Persona persona) {
        if (!persona.tieneSueldo(sueldoPretendido)){
            throw new SueldoNoDeseadoException("Sueldo actual inferior o igual al que desea ganar");
        }
    }

    @Override
    public void realizar(Persona persona) {
        persona.setSueldoPretendido(sueldoPretendido);
    }

}
