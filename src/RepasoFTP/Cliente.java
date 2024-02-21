package RepasoFTP;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.*;

import static RepasoFTP.Constante.*;
import static T4_FTP.FTP.Constante.RUTA;
import static T4_FTP.FTP.Constante.warning;

public class Cliente {
    private final String user;
    private final String password;
    private final FTPClient cliente;

    public Cliente(String user,String password) {
        this.user = user;
        this.password = password;
        this.cliente = new FTPClient();
    }
    public void connect() throws IOException {
        cliente.connect(NOMBRE,PUERTO);
    }
    public void login() throws IOException {
        cliente.login(user,password);
    }
    public void ls() {
        try {
            System.out.println("---- LISTADO DE FICHEROS ----");
            FTPFile[] ficheros = cliente.listFiles();

            for (FTPFile fichero : ficheros) {
                System.out.println(fichero.getName());
            }
        } catch (IOException e) {
            warning("Error al lista los ficheros", e.getMessage());
        }
        try {
            System.out.println("---- LISTADO DE CARPETAS ----");
            FTPFile[] directories = cliente.listDirectories();

            for (FTPFile fichero : directories) {
                System.out.println(fichero.getName());
            }
        } catch (IOException e) {
            warning("Error al lista los ficheros", e.getMessage());
        }
    }
    public void cd (String directorio) {
        try {
            cliente.changeWorkingDirectory(directorio);
            System.out.println("Cambiando a directorio " + directorio);
        } catch (IOException e) {
            warning("Error al cambiar de directorio",e.getMessage());
        }
    }
    public void pwd() {
        try {
            System.out.println("Ruta actual: " + cliente.printWorkingDirectory());
        } catch (IOException e) {
            warning("Error al imprimir la ruta actual",e.getMessage());
        }
    }
    public void mkdir(String directorio) {
        try {
            cliente.makeDirectory(directorio);
            System.out.println("Creando directorio " + directorio);
        } catch (IOException e) {
            warning("Error al crear directorio",e.getMessage());
        }
    }
    public void disconnect() throws IOException {
        cliente.disconnect();
    }
    public void descargar(String nombre) {
        File fichero = new File(RUTA + "/" + nombre);
        OutputStream out;
        boolean descargaOK;

        try {
            out = new BufferedOutputStream(new FileOutputStream(fichero));
        } catch (FileNotFoundException e) {
            warning("No se ha encontrado la ruta local",e.getMessage());
            return;
        }
        try {
            if (cliente.retrieveFile(nombre,out)) {
                System.out.println("Archivo descargado con éxito");
            }
        } catch (IOException e) {
            warning("Error al descargar el fichero",e.getMessage());
        }
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            warning("Error en la descarga",e.getMessage());
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
            if (cliente.storeFile(nombre,in)) {
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
