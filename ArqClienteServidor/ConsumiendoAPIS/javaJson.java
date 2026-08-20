package ArqClienteServidor.ConsumiendoAPIS;

import ArqClienteServidor.Clases.Car;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.net.MalformedURLException;

public class javaJson {
    public static void main(String[] args) throws MalformedURLException {

        //conversion de objeto a java json

        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("Azul", "Lexus");
        objectMapper.writeValue(new File("target/car.json"), car);

        //el resultado de lo anterior en el archivo será:
        //{"color":"azul","marca":"lexus}
        /*
        * Los métodos writeValueAsString y writeValueAsBytes de la clase ObjectMapper
        * generan un JSON a partir de un objeto Java y devuelven el JSON generado como
        * una cadena o como una matriz de bytes:*/

        String carAsString = objectMapper.writeValueAsString(car);

        // json a objeto java

        String json = "{\"color\":\"Negro\", \"marca\":\"BMW\"}";
        Car car2 = objectMapper.readValue(json, Car.class);

        // La función redValue() también acepta otras formas de entrada, como un archivo que contiene
        // una cadena json

        //Car car3 = objectMapper.readValue(new File("src/test/resources/json.car.json")),
          //      Car.class;

        // o una url

        //Car car5 = objectMapper.readValue(new URL("file:src/test/resources/json_car.jon"));

       // TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>();
    }
}
