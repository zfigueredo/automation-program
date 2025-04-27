package clase2;

import org.junit.jupiter.api.Test;

public class vehiculoTest {

    @Test
    void vehiculoTest() {

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMarca("Chevrolet");
        vehiculo.setModelo("Camero");
        vehiculo.setYear(2025);
        vehiculo.setColor("Amarillo");

        vehiculo.encender();
        vehiculo.acelerar(20);
        vehiculo.mostrarInformation();

    }
}
