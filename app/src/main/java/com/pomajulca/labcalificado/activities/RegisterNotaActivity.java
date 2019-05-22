package com.pomajulca.labcalificado.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pomajulca.labcalificado.R;
import com.pomajulca.labcalificado.models.Nota;
import com.pomajulca.labcalificado.repositories.NotaRepository;
import com.pomajulca.labcalificado.repositories.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RegisterNotaActivity extends AppCompatActivity {

    private EditText TituloInput;
    private EditText ComentarioInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_nota);
        setTitle("Registro de Notas");

        TituloInput = findViewById(R.id.titulo_input);
        ComentarioInput = findViewById(R.id.comentario_input);
    }


    public String getDate(){

        SimpleDateFormat nowString=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date date=new Date();
        return nowString.format(date);
    }
    public void callDoRegisterNota(View view){

        String titulo = TituloInput.getText().toString();
        String comentario=ComentarioInput.getText().toString();
        String fecha=getDate();


        //Nota note=new Nota();
        //String nowString=new SimpleDateFormat("dd/MM/yyyy").format(note);

        if(titulo.isEmpty() || comentario.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        //NotaRepository.create(titulo,comentario);
        //Toast.makeText(this, "Registro satisfactorio", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.putExtra("fullname", fecha +"\n"+"Titulo:"+"\n"+titulo+"\n"+ " " +"Comentario:"+"\n"+ comentario);

        setResult(RESULT_OK, intent);
        finish();

    }



}
