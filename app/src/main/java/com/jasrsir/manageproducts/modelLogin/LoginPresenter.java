package com.jasrsir.manageproducts.modelLogin;

import android.content.Context;
import android.text.TextUtils;

import com.jasrsir.manageproducts.R;

/**
 * Created by jasrsir on 20/10/16.
 */

public class LoginPresenter implements ILoginMvp.Presenter {

    private ILoginMvp.View vista;

    public LoginPresenter(ILoginMvp.View view) {
        this.vista = view;
    }

    //El presentador NO devuelve nada a la vista, lo modifica y pasa
    //Obtenemos el recurso
    @Override
    public void validateCredentials(String user, String pass) {
        int idError = 0;
        String msgError = "";
        if (TextUtils.isEmpty(user)) {
            msgError = ((Context) vista).getResources().getString(R.string.data_empty_u);
            idError = R.id.edtUser;
        } else if (TextUtils.isEmpty(pass)) {
            msgError = ((Context) vista).getResources().getString(R.string.data_empty_p);
            idError = R.id.edtPassword;
        } else if (!pass.matches("^.{0,}([0-9])+.{0,}$")) {
            msgError = ((Context) vista).getResources().getString(R.string.password_digit);
            idError = R.id.edtPassword;
        } else if (!pass.matches("^.+[a-zA-Z]+.+$")) {
            msgError = ((Context) vista).getResources().getString(R.string.password_case);
            idError = R.id.edtPassword;
        } else if (pass.length() < 8) {
            msgError = ((Context) vista).getResources().getString(R.string.password_length);
            idError = R.id.edtPassword;
        } else {
            //Guardar el usuario en la clase Application, lo hacre el presentador
            //Hacemos un up-cast y luego un down-cast

            //((LoginApplication)((Context)vista).getApplicationContext()).setUsuario(new Usuario(user,pass));
        }
        vista.setMessageError(msgError,idError);
    }
}
