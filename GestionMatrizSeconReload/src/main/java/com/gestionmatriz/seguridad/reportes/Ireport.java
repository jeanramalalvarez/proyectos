
package com.gestionmatriz.seguridad.reportes;

import com.gestionmatriz.config.services.KeyService_I;
import com.gestionmatriz.dao.PaqueteBusinessDelegate;
import com.gestionmatriz.util.EncriptionSource;
import com.gestionmatriz.util.FunctionByte;
import com.gestionmatriz.util.ReportUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author zholo
 */
public class Ireport {

    private KeyService_I objKey_I;
    private final Logger log=Logger.getLogger(Ireport.class);
    
    public void usuarioContrasenia(String usuario, String contrasenia) {
        InputStream input=null;
        try {
            input=getClass().getResourceAsStream("/com/gestionmatriz/reporte/ResumenUsuario.jasper");
            Map<String, Object> parametros = new HashMap<>();
            parametros.clear();
            EncriptionSource objEncriptador = new EncriptionSource();
            objKey_I = PaqueteBusinessDelegate.getKeyService();
            byte[] llave = FunctionByte.hex2byte(objKey_I.getKey().getKey());
            String descPass = objEncriptador.Decrypt(llave, FunctionByte.hex2byte(contrasenia));
            parametros.put("str_usuario", usuario);
            parametros.put("str_contrasenia", descPass);
            ReportUtil.printView(parametros,input);
        } catch (MalformedURLException ex) {
            log.error(ex);
        }catch (Exception ex) {
            log.error(ex.getMessage(),ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                log.error(ex);
            }
        }
    }
}
