import java.security.SecureRandom;

public class Persona implements Runnable{
    private int TIEMPO1 = 3000;
    private String apodo;
    private Coche coche;
    private Plaza plaza;
    private SecureRandom random;

    public Persona(String apodo, Coche coche) {
        this.apodo = apodo;
        this.coche = coche;
       random = new SecureRandom();
    }

    public Persona(String apodo) {
        this.apodo = apodo;
    }

    public String getApodo() {
        return apodo;
    }

    public void setPlaza(Plaza plaza) {
        this.plaza = plaza;
    }

    @Override
    public void run() {
        try {
            System.out.println("Voy a cantar la cacnión Twist");
            Thread.sleep(random.nextInt(1,TIEMPO1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        while (plaza ==null && !coche.estaLleno() && coche.getListaPersona().indexOf(this.getApodo()) > coche.getListaPersona().indexOf(coche.getUltimaPersonaMontada())){
            synchronized (coche){
                    if (coche.estaVacio()){
                        coche.meterPersona(this);
                        System.out.printf("Soy %s y me he montado en el coche en la plaza %d porque estaba vacio\n ",getApodo(),coche.getPlazas().get(coche.getPlazas().size()-1).getNumero());
                        coche.setUltimaPersonaMontada(this.apodo);
                        setPlaza(coche.getPlazas().get(coche.getPlazas().size()-1));

                    }else{
                        coche.meterPersona(this);
                        System.out.printf("Soy %s y me he montado en el coche en la plaza %d  despues de %s \n ",getApodo(),coche.getPlazas().get(coche.getPlazas().size()-1).getNumero(),coche.getUltimaPersonaMontada());
                        coche.setUltimaPersonaMontada(this.apodo);
                        setPlaza(coche.getPlazas().get(coche.getPlazas().size()-1));
                    }
            }
        }
        if(plaza ==null){
            System.out.printf("[%s]El coche está lleno, me voy a casa andando \n" ,this.apodo);
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "apodo='" + apodo + '\'' +
                '}';
    }
}
