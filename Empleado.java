package Product;

public class Empleado extends Persona{
    private String cargo;
    public Empleado(String dni, String nombre, String apellido, String telefono, String cargo){
        super(dni, nombre, apellido, telefono);

    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (!(cargo == null || cargo.trim().isEmpty())) this.cargo = cargo;
    }

    public void trabajo(){
        System.out.println("El empleado " + nombre + " " + apellido + " tiene un trabajo de " + cargo);
    }
}
