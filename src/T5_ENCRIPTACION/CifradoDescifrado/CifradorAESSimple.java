package T5_ENCRIPTACION.CifradoDescifrado;

import java.io.PrintWriter;
import java.security.Key;

public class CifradorAESSimple {
    public static void main(String[] args) {
        final int LONGITUD_BLOQUE = 16; //expresado en bytes
        final String NOMBRE_FICHERO = "mensaje_cifrado.txt";
        final String PASSWORD = "AntonioDiazSantamaria";
        final String TEXTO_EN_CLARO = "La clave secreta en la caja fuerte es 123987456";
        Key clave;
        String textoEnClaro;
        String textoCifrado;
        PrintWriter pw;
        try {
            clave = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD_BLOQUE);
            textoEnClaro = TEXTO_EN_CLARO;
            textoCifrado = AESSimpleManager.cifrar(textoEnClaro, clave);
            pw = new PrintWriter(NOMBRE_FICHERO);
            pw.write(textoCifrado);
            pw.close();
            System.out.println("El mensaje se ha cifrado correctamente");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
