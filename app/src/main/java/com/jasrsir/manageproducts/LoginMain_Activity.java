package com.jasrsir.manageproducts;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jasrsir.manageproducts.modelLogin.ILoginMvp;
import com.jasrsir.manageproducts.modelLogin.LoginApplication;
import com.jasrsir.manageproducts.modelLogin.LoginPresenter;

public class LoginMain_Activity extends AppCompatActivity implements ILoginMvp.View {

    //region class variables
    private ILoginMvp.Presenter mloginMvp;
    private EditText mEdtPassword;
    private EditText mEdtUser;
    private Button mBtnLogin;
    private TextInputLayout mtilPass;
    private TextInputLayout mtilUser;
    private final String TAG = "loginrelative";



    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        inicializar();
    }

    private void inicializar() {
        //El presentador tenía una referencia a la vista, y la vista es la activity THIS
        mloginMvp = new LoginPresenter(this);
        mEdtUser = (EditText) findViewById(R.id.edtUser);
        mEdtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mtilUser.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mEdtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mtilPass.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mBtnLogin = (Button) findViewById(R.id.btnLogin);
        mtilPass = (TextInputLayout) findViewById(R.id.tilPass);
        mtilUser = (TextInputLayout) findViewById(R.id.tilUser);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mloginMvp.validateCredentials(mEdtUser.getText().toString(), mEdtPassword.getText().toString());
            }
        });
    }

    @Override
    public void setMessageError(String messageError, int id) {
        switch (id) {
            case R.id.edtUser:
                mtilUser.setError(messageError);
                break;
            case R.id.edtPassword:
                mtilPass.setError(messageError);
                break;
            case 0:
                Intent intent = new Intent(LoginMain_Activity.this, ListProducts_Activity.class);
                startActivity(intent);
        }

    }
    private void resetValues() {
        mEdtPassword.setText("");
        mEdtUser.setText("");
    }
}
