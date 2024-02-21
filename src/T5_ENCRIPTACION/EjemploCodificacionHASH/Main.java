package T5_ENCRIPTACION.EjemploCodificacionHASH;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    private static final String TIPO_ALGORITMO_1 = "SHA-256";
    private static final String TIPO_ALGORITMO_2 = "SHA-512";

    public static void main(String[] args) {
        String mensaje = "Hola Mundo";
        System.out.println("La cadena sin cifrar es " + mensaje);
        System.out.println("La cadena cifrada con " + TIPO_ALGORITMO_1 + " es: " +
                codificar(mensaje, TIPO_ALGORITMO_1));
        System.out.println("La cadena cifrada con " + TIPO_ALGORITMO_2 + " es: " +
                codificar(mensaje, TIPO_ALGORITMO_2));
    }

    private static String codificar(String mensajeClaro, String tipoAlgoritmo) {
        try {
            MessageDigest sha = MessageDigest.getInstance(tipoAlgoritmo);
            byte[] digest = sha.digest(mensajeClaro.getBytes());
            StringBuilder hexString = new StringBuilder();
            for ( byte b : digest ) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}
