package ArqClienteServidor.Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args){
        final String HOST = "localhost";
        Scanner scanner = new Scanner(System.in);
        final int PUERTO = 5000;
        DataInputStream input;
        DataOutputStream output;
        String op;

        try (Socket sc = new Socket(HOST, PUERTO)){
            input = new DataInputStream(sc.getInputStream());
            output = new DataOutputStream(sc.getOutputStream());

            while (true){
                System.out.println("Se ha conectado al servidor");
                output.writeUTF("Hola desde el lado del cliente");

                String mensaje = input.readUTF();
                System.out.println(mensaje);

                System.out.println("Presione 'S' para salir: ");
                op = scanner.nextLine().toLowerCase();

                if (op.equals("s")){
                    break;
                }

            }


        }catch (IOException e){
            System.err.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}
