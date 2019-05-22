package com.pomajulca.labcalificado.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pomajulca.labcalificado.R;
import com.pomajulca.labcalificado.models.User;
import com.pomajulca.labcalificado.repositories.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private EditText usuarioInput;
    private EditText passwordInput;
    private Button loginButton;
    private Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioInput=findViewById(R.id.usuario_input);
        passwordInput=findViewById(R.id.password_input);

        loginButton=findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLogin();
            }
        });

        registerButton = findViewById(R.id.register_button2);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegister();
            }
        });

        verifySession();

    }

    private void showRegister(){
        startActivity(new Intent(this, RegisterActivity.class));
    }

    private void callLogin(){
        String usuario = usuarioInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(usuario.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        //login process
        User user = UserRepository.login(usuario, password);

        if(user == null) {
            Toast.makeText(this, "usuario y/o password inválido", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean success = sp.edit().putString("usuario",usuario).
                putLong("id",user.getId()).
                putBoolean("idlogged",true).
                commit();
        goMain();

        // Go to main
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void verifySession(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if(sp.getBoolean("islogged",false)){
            goMain();
        }
    }
    private void goMain(){
        startActivity(new Intent(this, MainActivity.class));
        finish();

    }
}
