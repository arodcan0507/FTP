package RepasoFTP;

import java.io.IOException;
import java.util.Scanner;

import static RepasoFTP.Constante.*;

public class Main {
    public static void main(String[] args) {
        boolean opt = true;
        int opcion;
        Scanner scanner = new Scanner(System.in);

        String user = "usuario", password = "1234",param;
        Cliente cliente = new Cliente(user,password);

        try {
            cliente.connect();
            System.out.println("Iniciando conexión");
            cliente.login();
            System.out.println("Iniciando sesión...");
        } catch (IOException e) {
            errorFatal("Error al realizar la conexión o iniciar sesión", e.getMessage(), -1);
        }

        while (opt) {
            System.out.println(MENU);
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case MKDIR -> {
                    System.out.print("Introduce el directorio a crear: ");
                    param = scanner.next();
                    cliente.mkdir(param);
                }
                case CD -> {
                    System.out.print("Introduce el directorio a moverse: ");
                    param = scanner.next();
                    cliente.cd(param);
                }
                case PWD -> {
                    cliente.pwd();
                }
                case LS -> {
                    cliente.ls();
                }
                case SUBIR -> {
                    System.out.print("Introduce el directorio a crear: ");
                    param = scanner.next();
                    cliente.subir(param);
                }
                case DESCARGAR -> {
                    System.out.print("Introduce el directorio a crear: ");
                    param = scanner.next();
                    cliente.descargar(param);
                }
                case SALIR -> {
                    try {
                        cliente.disconnect();
                        opt = false;
                    } catch (IOException e) {
                        errorFatal("Error al cerrar la conexión",e.getMessage(),-2);
                    }
                }
                default -> {
                    System.out.println("Opción no válida.");
                }
            }
        }
    }
}
