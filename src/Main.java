import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Coche coche = new Coche("FIAt","600");
        for(String persona :coche.getListaPersona()){
            executor.execute(new Persona(persona,coche));
        }
        executor.shutdown();

    }


}