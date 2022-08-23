package suenios;

public abstract class Suenio {
    //ATRIBUTOS
    private boolean cumplido;
    protected Integer felicidonios;

    //CONSTRUCTOR
    public Suenio(Integer felicidonios) {
        this.felicidonios = felicidonios;
        this.cumplido = false;
    }

    //METODOS ABSTRACTOS
    public abstract void validar(Persona persona);
    public abstract void realizar(Persona persona);
    public abstract Integer felicidonios();

    //GETTERS
    public Boolean estaPendiente(){
        return !cumplido;
    }

    public Boolean getCumplido(){return cumplido;}

    //SETTERS
    public void setCumplido(Boolean cumplido){this.cumplido = cumplido;}

    public void cumplir() {setCumplido(true);}

    //METODOS
    public void cumplir(Persona persona) {
        validar(persona);
        realizar(persona);
        cumplir();
        persona.sumarFelicidad(felicidonios());
    }


    //TOSTRING
    @Override
    public String toString(){return "Suenio{" + "cumplido=" + cumplido + "}";}
}

