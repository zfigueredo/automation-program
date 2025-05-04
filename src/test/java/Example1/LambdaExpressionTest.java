package Example1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressionTest {
    /*
    Lambda Expressions en Java
    - Son funciones anónimas que se pueden usar para implementar interfaces funcionales.
    - Sintaxis: (parámetros) -> { cuerpo }

    Ejemplos:
    () -> System.out.println("Hola");
    (x, y) -> x + y;
    s -> s.toUpperCase();

    Se usan comúnmente con Streams para transformar, filtrar o procesar colecciones de forma concisa.
*/

    @Test
    void lambdaTest() {
        List<String> list = Arrays.asList("Java", "Python", "C#");
        //Filtra los elementos de la lista que comienza con J e imprimelos
        list.stream().
                filter(name ->name.startsWith("J")).
                forEach(System.out::println);

        //Dado una lista de enteros use stream y lambdas para imprimir solo los nros pares
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        numbers.stream().
                filter(n ->n%2 ==0).
                forEach(System.out::println);
        //-------------------------------------
        //Dado una lista de enteros usa lambda para contar cuantos elementos son mayores a 10
        List<Integer> numbersList = Arrays.asList(5,15,20,7,10);
        long quantity = numbersList.stream().
                filter(n -> n>10)
                .count();

        System.out.println("Greater than 10:"+quantity);
    }

    @Test
    void testInteger() {
        Integer[] values ={2,9,0,5,3,1,7,4,6,8};

        //Displayed original list
        System.out.println("Original values:"+ Arrays.asList(values));

        //Sorted la lista
        System.out.println("Sorted list:"+Arrays.stream(values).sorted().toList());

        //Imprimir valores mayores a 4
        List<Integer> greaterThan4 = Arrays.stream(values).
                filter(n -> n>4).toList();
            System.out.println("Values greater than 4: "+greaterThan4);

    }

    @Test
    void testStrings() {
        String[]stringsList = {"Red", "orange", "Yellow", "green", "Blue"};
        System.out.println("Original values" +Arrays.asList(stringsList));


        //To UpperCase
        System.out.println("To uppercase"+
                Arrays.stream(stringsList)//Convierte arreglo a stream
                        .map(String::toUpperCase)//aplica una transformacion a cada elemento(String::toUpperCase s -> s.toUpperCase())
                        .toList()//convierte el Stream en una lista
        );

        //Sorted Ascending
        System.out.println("Sorted Ascending:"+
                Arrays.stream(stringsList).sorted().toList());

        //Imprimir los elementos que empiecen con B
        System.out.println("Start with capital B"+
                Arrays.stream(stringsList)
                        .filter(c ->c.toLowerCase().startsWith("b"))
                        .map(String::toUpperCase)
                        .toList());

    }

}
