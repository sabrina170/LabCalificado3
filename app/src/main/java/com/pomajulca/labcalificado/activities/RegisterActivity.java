package com.pomajulca.labcalificado.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pomajulca.labcalificado.R;
import com.pomajulca.labcalificado.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {
    private EditText usuarioInput;
    private EditText fullnameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usuarioInput=findViewById(R.id.usuario_input2);
        fullnameInput = findViewById(R.id.fullname_input2);
        emailInput = findViewById(R.id.email_input2);
        passwordInput = findViewById(R.id.password_input2);
        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRegister();
            }
        });
    }

    private void callRegister(){
        try {

            String usuario=usuarioInput.getText().toString();
            String fullname = fullnameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            if (usuario.isEmpty() || fullname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            UserRepository.create(usuario,fullname, email, password);

            Toast.makeText(this, "Registro satisfactorio", Toast.LENGTH_SHORT).show();

            finish();

        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
