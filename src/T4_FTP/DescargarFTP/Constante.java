package T4_FTP.DescargarFTP;

public class Constante {
    public final static String NOMBRE = "localhost";
    public static final int PUERTO = 21;
    public static final String RUTA = "C:\\Users\\usuario\\Desktop\\2ºCFGS_DAM\\MULTIHILO\\PruebaFTP\\Descargar";
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
