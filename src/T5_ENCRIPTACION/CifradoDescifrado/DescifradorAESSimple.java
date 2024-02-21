package T5_ENCRIPTACION.CifradoDescifrado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;

public class DescifradorAESSimple {
    public static void main(String[] args) throws RuntimeException {
        final int LONGITUD_BLOQUE = 16; //expresado en bytes
        final String NOMBRE_FICHERO = "mensaje_cifrado.txt";
        final String PASSWORD = "AntonioDiazSantamaria";
        try {
            File file = new File(NOMBRE_FICHERO);
            Key clave = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD_BLOQUE);
            String textoEnClaro;
            try (BufferedReader br = new BufferedReader( new FileReader(file))) {
                String textoCifrado = br.readLine();
                textoEnClaro = AESSimpleManager.descifrar(textoCifrado, clave);
            }
            System.out.println("El texto descifrado es: " + textoEnClaro);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
