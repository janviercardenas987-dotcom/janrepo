package ArqClienteServidor.ConsumiendoAPIS;

import ArqClienteServidor.Clases.User;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class mapJson {
    public static void main(String[] args){

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users/1"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = cliente.send(
                    peticion,
                    HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() == 200){
                System.out.println("Codigo: " + response.statusCode());
                ObjectMapper mapper = new ObjectMapper();

                User user = mapper.readValue(
                        response.body(),
                        User.class
                );

                System.out.println("ID: " + user.getId());
                System.out.println("Name: " + user.getName());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Email: " + user.getEmail());
                System.out.println("City: " + user.getAddress().getCity());

            }else {
                System.out.println("La petición falló. Código HTTP: " + response.statusCode());
            }

            System.out.println(response.body());

        } catch (InterruptedException |IOException e) {
            throw new RuntimeException(e);
        }

    }
}
