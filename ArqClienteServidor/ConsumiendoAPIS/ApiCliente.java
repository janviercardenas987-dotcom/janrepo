package ArqClienteServidor.ConsumiendoAPIS;

import ArqClienteServidor.Clases.Todo;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCliente {
    public static void main(String[] args){
        // creamos el cliente http
        HttpClient cliente = HttpClient.newHttpClient();

        //creamos la petición

        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users/1"))
                .GET()
                .build();

        // enviamos la peticion
        try {
            HttpResponse<String> respuesta = cliente.send(
                    peticion,
                    HttpResponse.BodyHandlers.ofString()
            );

            // obtenemos el código http

            if (respuesta.statusCode() == 200){
                System.out.println("Código HTTP: " + respuesta.statusCode());
                //obtenemos el contenido de la respuesta
                //System.out.println("Respuesta: ");
                //System.out.println(respuesta.body());

                ObjectMapper mapper = new ObjectMapper();

                Todo todo = mapper.readValue(
                        respuesta.body(),
                        Todo.class
                );

                System.out.println("ID: " + todo.getId());
                System.out.println("Usuario: " + todo.getUserId());
                System.out.println("Titulo: " + todo.getTitle());
                System.out.println("Completado: " + todo.isCompleted());
            }else {
                System.out.println("La peticón falló código: " + respuesta.statusCode());
            }

        }catch (IOException | InterruptedException e){
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}
