package T4_FTP.SubirFTP;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.*;

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
    public void descargar(String nombre) {
        File fichero = new File(RUTA + "/", nombre);
        OutputStream out;
        boolean descargaOK;
        try {
            out = new BufferedOutputStream(new FileOutputStream(fichero));
        } catch (FileNotFoundException e) {
            warning("No se ha encontrado la ruta local -> " + RUTA,e.getMessage());
            return;
        }
        try {
            if (ftpCliente.retrieveFile(nombre,out)) {
                System.out.println("Archivo descargado con éxito");
            }
        } catch (IOException e) {
            warning("Error al descargar el fichero -> " + nombre, e.getMessage());
            return;
        }
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            warning("Error en la descarga de -> " + nombre, e.getMessage());
            return;
        }
    }
    public void subir(String nombre) {
        File fichero = new File(RUTA + "/", nombre);
        BufferedInputStream in;
        boolean descargaOK;
        try {
            in = new BufferedInputStream(new FileInputStream(fichero));
        } catch (FileNotFoundException e) {
            warning("No se ha encontrado la ruta local -> " + RUTA,e.getMessage());
            return;
        }
        try {
            if (ftpCliente.storeFile(nombre,in)) {
                System.out.println("Archivo subido con éxito");
            }
        } catch (IOException e) {
            warning("Error al subir el fichero -> " + nombre, e.getMessage());
            return;
        }
        try {
            in.close();
        } catch (IOException e) {
            warning("Error en la subida de -> " + nombre, e.getMessage());
            return;
        }
    }
}
