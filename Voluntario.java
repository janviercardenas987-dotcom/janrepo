package Product;

public class Voluntario extends Persona{
    private int horasTrabajadas;
    private String profesion;

    public Voluntario(String dni, String nombre, String apellido, String telefono, int horasTrabajadas, String profesion) {
        super(dni, nombre, apellido, telefono);
        this.horasTrabajadas = horasTrabajadas;
        this.profesion = profesion;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        if (horasTrabajadas >= 0)this.horasTrabajadas = horasTrabajadas;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Voluntario{" +
                "horasTrabajadas=" + horasTrabajadas +
                ", profesion='" + profesion + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
