package com.jasrsir.manageproducts.modelLogin;

import android.app.Application;
import com.jasrsir.manageproducts.modelLogin.Usuario;
/**
 * Created by jasrsir on 20/10/16.
 */

public class LoginApplication extends Application {
    //Esta aplicación va a guardar una entidad que es el USUARIO, ocn el nombre y contraseña
    private Usuario usuario;
    //Para este objeto mmodelo le hacemos las propiedades get y set
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }


}
