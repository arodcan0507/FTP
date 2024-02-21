package T5_ENCRIPTACION.EncriptacionCesar;

import java.util.Scanner;

public class Cesar {
    private static final String ABC = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private static final int desplazamiento = 3;
    private static final String delimitador = "\n";
    private final Scanner teclado = new Scanner(System.in);
    private String mensajeClaro = "";
    private String mensajeCodificado = "";

    public Cesar() {
        teclado.useDelimiter(delimitador);
        System.out.print("Introduce una frase -> ");
        mensajeClaro = teclado.next().toUpperCase();
    }
    public Cesar(String mensajeCodificado) {
        this.mensajeCodificado = mensajeCodificado;
        mensajeClaro = "";
    }
    private void codificar() {
        char caracter;
        int pos;
        mensajeCodificado = "";

        for (int i = 0; i < mensajeClaro.length(); i++) {
            caracter = mensajeClaro.charAt(i);
            pos = ABC.indexOf(caracter);
            if (pos == -1) {
                mensajeCodificado += caracter;
            } else {
                mensajeCodificado += ABC.charAt((pos + desplazamiento) % ABC.length());
            }
        }
    }
    private void descodificar() {
        char caracter;
        int pos;
        mensajeClaro = "";

        for (int i = 0; i < mensajeCodificado.length(); i++) {
            caracter = mensajeCodificado.charAt(i);
            pos = ABC.indexOf(caracter);

            if (pos == -1) {
                mensajeClaro += caracter;
            } else if (pos < 3) {
                mensajeClaro += ABC.charAt(ABC.length() - (desplazamiento - pos));
            } else {
                mensajeClaro += ABC.charAt(pos - desplazamiento);
            }
        }
    }

    public String getMensajeCodificado() {
        if (mensajeCodificado.isBlank() || mensajeCodificado.isEmpty()) {
            codificar();
        }
        return mensajeCodificado;
    }

    public String getMensajeClaro() {
        if (mensajeClaro.isBlank() || mensajeClaro.isEmpty()) {
            descodificar();
        }
        return mensajeClaro;
    }
}
