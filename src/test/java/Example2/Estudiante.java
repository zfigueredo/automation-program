package Example2;

public class Estudiante extends Persona{

    int estudianteId;

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }
    //Constructor de la clase que dice que toma tamb el contructor de la clase padre con la palabra super
    public Estudiante(String nombre, int edad, int estudianteId) {
        super(nombre, edad);
        this.estudianteId = estudianteId;
    }

    public void estudiar(){
        System.out.println("El id de " + getNombre() + " es " + getEstudianteId());
    }

}
