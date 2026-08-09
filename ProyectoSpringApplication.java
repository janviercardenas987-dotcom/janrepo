package Prueba;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProyectoSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProyectoSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner testDatabase(ProductoRepository repository) {
        return args -> {
            System.out.println("--- Guardando un nuevo producto ---");
            Producto p1 = new Producto("Teclado Mecánico", 89.99);
            repository.save(p1);

            System.out.println("--- Productos en la base de datos ---");
            repository.findAll().forEach(producto -> {
                System.out.println("ID: " + producto.getId() + " | Nombre: " + producto.getNombre());
            });
        };
    }
}