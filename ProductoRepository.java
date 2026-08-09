package Prueba;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Solo definiendo esta interfaz ya tienes metodos como:
    // save(), findById(), findAll(), deleteById(), etc. ¡Sin escribir una sola linea de SQL!
}