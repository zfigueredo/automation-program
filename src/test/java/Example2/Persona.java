package Example2;

public class Persona {
    private String nombre;
    private int edad;

   //Constructor
    public Persona (String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public void presentarse(){
        System.out.println("Hola, mi nombre es " + nombre + "y tengo " + edad + " annos de edad");

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}


