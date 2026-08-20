package ArqClienteServidor.Sockets;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args){

        final int PUERTO = 5000;
        Socket socket = null;
        DataInputStream input;
        DataOutputStream output;
        try (ServerSocket serverSocket = new ServerSocket(PUERTO);)
        {
            System.out.println("Servidor Iniciado");
            while (true){
                socket = serverSocket.accept();
                System.out.println("Cliente Conectado");
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());

                String mensaje = input.readUTF();
                System.out.println(mensaje);

                output.writeUTF("¡Hola mundo desde el servidor!");

                input.close();
                output.close();
                socket.close();
                System.out.println("Cliente desconectado");
            }
        }catch (IOException e){
            System.err.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}
