package ArqClienteServidor.Clases;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;

    public User(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress(){
        return address;
    }

}
