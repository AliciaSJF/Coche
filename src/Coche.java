import java.util.ArrayList;
import java.util.List;

public class Coche {
    private final String marca;
    private final String modelo;
    private ArrayList<Plaza>plazas;
    private static String ultimaPersonaMontada;

    private final ArrayList<String> listaPersonas = new ArrayList<>(){{
        add("DAVID");
        add("FRANCISCO");
        add("GEMMA");
        add("OSCAR");
        add("YOLANDA");
    }};

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.plazas = new ArrayList<>();
    }
    public ArrayList<String> getListaPersona(){
        return listaPersonas;
    }

    public boolean estaLleno(){
        return plazas.size()==4;
    }
    public boolean estaVacio(){
        return plazas.isEmpty();
    }
    public void meterPersona(Persona persona){
        plazas.add(new Plaza(persona));
    }
    public void setUltimaPersonaMontada(String personaMontada){
        ultimaPersonaMontada = personaMontada;
    }

    public String getUltimaPersonaMontada() {
        return ultimaPersonaMontada;
    }

    public ArrayList<Plaza> getPlazas() {
        return plazas;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", plazas=" + plazas +
                '}';
    }
}
