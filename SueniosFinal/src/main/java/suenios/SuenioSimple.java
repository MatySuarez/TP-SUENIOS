package suenios;

public class SuenioSimple extends Suenio{
    protected Integer felicidonios;

    public SuenioSimple(Integer felicidonios) {
        super(felicidonios);
    }

    //GETTER
    public Integer felicidonios(){return this.felicidonios;}

    //SETTER
    public void setFelicidonios(Integer felicidonios){this.felicidonios = felicidonios;}

    //METODOS
    @Override
    public void validar(Persona persona) {
    }

    @Override
    public void realizar(Persona persona) {
    }

    public Boolean esAmbicioso(){
        return felicidonios() > 100;
    }

}
