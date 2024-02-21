package T4_FTP.FTP;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

import static T4_FTP.FTP.Constante.*;

public class Cliente {
    private final String user;
    private final String password;
    private final FTPClient ftpCliente;
    public Cliente(String user,String password) {
        this.user = user;
        this.password = password;
        this.ftpCliente = new FTPClient();
    }
    public void connect() throws IOException {
        ftpCliente.connect(NOMBRE,PUERTO);
    }
    public void login() throws IOException {
        ftpCliente.login(user,password);
    }
    public void disconnect() throws IOException {
        ftpCliente.disconnect();
    }
    public void ls() {
        try {
            System.out.println("---- LISTADO DE FICHEROS ----");
            FTPFile[] ficheros = ftpCliente.listFiles();

            for (FTPFile fichero : ficheros) {
                System.out.println(fichero.getName());
            }
        } catch (IOException e) {
            warning("Error al lista los ficheros", e.getMessage());
        }
        try {
            System.out.println("---- LISTADO DE CARPETAS ----");
            FTPFile[] directories = ftpCliente.listDirectories();

            for (FTPFile fichero : directories) {
                System.out.println(fichero.getName());
            }
        } catch (IOException e) {
            warning("Error al lista los ficheros", e.getMessage());
        }
    }
    public void cd(String directorio) {
        try {
            ftpCliente.changeWorkingDirectory(directorio);
        } catch (IOException e) {
            warning("Error al cambiar de directorio " + directorio, e.getMessage());
        }
    }
    public void pwd() {
        try {
            System.out.println("Carpeta actual: " + ftpCliente.printWorkingDirectory());
        } catch (IOException e) {
            warning("Error al mostrar la ruta actual",e.getMessage());
        }
    }
    public void mkdir(String directorio) {
        try {
            ftpCliente.makeDirectory(directorio);
        } catch (IOException e) {
            warning("Error al crear el directorio",e.getMessage());
        }
    }
}
