package Example2;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int year;
    private String color;
    private int velocidad;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public void encender(){
        System.out.println("Vehiculo encendido");
    }

    public void acelerar(int cantidad){
       velocidad = velocidad + cantidad;
        System.out.println("Acelerando...velocidad actual:" + "Km/h");
    }

    public void mostrarInformation(){
        System.out.println("Marca: "+marca);
        System.out.println("Modelo: "+modelo);
        System.out.println("Color: "+color);
        System.out.println("Year: "+year);
    }
}
