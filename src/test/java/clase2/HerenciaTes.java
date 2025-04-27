package clase2;

import org.junit.jupiter.api.Test;

public class HerenciaTes {

    @Test
    void estudianteTest() {

        Estudiante estudiante = new Estudiante("Juan ", 25, 123456);
        estudiante.presentarse();
        estudiante.estudiar();
    }
}
