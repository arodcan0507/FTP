package RepasoFTP;

public class Constante {
    public static String MENU = "-- MENÚ DE OPCIONES --\n 1. MKDIR\n 2. CD\n 3. PWD\n 4. LS\n 5. SUBIR\n 6. DESCARGAR\n 7. SALIR\n";
    public static final int MKDIR = 1;
    public static final int CD = 2;
    public static final int PWD = 3;
    public static final int LS = 4;
    public static final int SUBIR = 5;
    public static final int DESCARGAR = 6;
    public static final int SALIR = 7;
    public static final String NOMBRE = "localhost";
    public static final int PUERTO = 21;
    public static final String RUTA = "C:\\Users\\usuario\\Desktop\\2ºCFGS_DAM\\MULTIHILO\\PruebaFTP";
    public static void errorFatal(String description, String exception, int codigo) {
        System.err.println(description);
        System.err.println(exception);
        System.exit(codigo);
    }
    public static void warning(String descripcion, String excepcion) {
        System.err.println(descripcion);
        System.err.println(excepcion);
    }
}
