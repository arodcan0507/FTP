package T5_ENCRIPTACION.AlgoritmosHASH;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final String TIPO_MESSAGE_DIGEST = MessageDigest.class.getSimpleName();
        Provider[] proveedores = Security.getProviders();
        for ( Provider proveedor : proveedores ) {
            Set<Provider.Service> servicios = proveedor.getServices();
            for ( Provider.Service servicio : servicios ) {
                if ( servicio.getType().equals(TIPO_MESSAGE_DIGEST)) {
                    System.out.println(servicio.getAlgorithm());
                }
            }
        }
    }
}
