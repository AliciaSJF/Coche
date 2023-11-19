public class Plaza {
    private  int numero;
    private Persona persona;
    private static int aux = 1;

    public Plaza(Persona persona ) {
        numero = aux++;
        this.persona = persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public int getNumero() {
        return numero;
    }
}
