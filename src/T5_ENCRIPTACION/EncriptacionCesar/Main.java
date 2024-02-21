package T5_ENCRIPTACION.EncriptacionCesar;

public class Main {
    public static void main(String[] args) {
        Cesar cesar = new Cesar();
        System.out.println("Mensaje en claro -> " + cesar.getMensajeClaro());
        System.out.println("Mensaje codificado -> " + cesar.getMensajeCodificado());

        Cesar comprobacion = new Cesar(cesar.getMensajeCodificado());
        System.out.println("Mensaje codificado: " + comprobacion.getMensajeCodificado());
        System.out.println("Mensaje en claro: " + comprobacion.getMensajeClaro());
    }
}
