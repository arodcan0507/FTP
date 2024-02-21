package T4_FTP.SubirFTP;

import java.io.IOException;

import static T4_FTP.FTP.Constante.*;

public class MainCliente {
    public static void main(String[] args) {
        String user = "usuario";
        String password = "1234";
        Cliente cliente = new Cliente(user,password);
        try {
            System.out.println("Empieza la conexión");
            cliente.connect();
        } catch (IOException e) {
            errorFatal("Error al realizar el login",e.getMessage(),-1);
        }
        try {
            System.out.println("Empieza el logeo");
            cliente.login();
        } catch (IOException e) {
            errorFatal("Error al realizar el login",e.getMessage(),-1);
        }

        System.out.println("Conexión y Login realizados con éxito");
        cliente.subir("a.txt");
        try {
            cliente.disconnect();
        } catch (IOException e) {
            errorFatal("Error al desconectar",e.getMessage(),-3);
        }
        System.out.println("Programa terminado con éxito");
    }
}
