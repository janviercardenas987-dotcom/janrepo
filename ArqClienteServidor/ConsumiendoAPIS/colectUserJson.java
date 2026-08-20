package ArqClienteServidor.ConsumiendoAPIS;

import ArqClienteServidor.Clases.User;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class colectUserJson {
    public static void main(String[] args){

        TypeReference<List<User>> tipo = new TypeReference<List<User>>() {};

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = cliente.send(
                    peticion,
                    HttpResponse.BodyHandlers.ofString()
            );
            if (response.statusCode() == 200){
                System.out.println("Código http: " + response.statusCode());
                ObjectMapper mapper = new ObjectMapper();

                List<User> usaurios = mapper.readValue(response.body(), tipo);

                for (User user: usaurios){
                    System.out.println(user.getId() + " - " + user.getName());
                }
            }

        }catch (IOException | InterruptedException e){
            System.err.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}
