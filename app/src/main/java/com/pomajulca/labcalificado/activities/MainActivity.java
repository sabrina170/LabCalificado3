package com.pomajulca.labcalificado.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pomajulca.labcalificado.R;
import com.pomajulca.labcalificado.models.User;
import com.pomajulca.labcalificado.repositories.UserRepository;

public class MainActivity extends AppCompatActivity {
    private TextView fullnameText;
    private ListView contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullnameText = findViewById(R.id.fullname_text);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            String fullname = bundle.getString("fullname");
            if(fullname != null) {
                // Imprimir el username...
                fullnameText.setText(fullname);
            }

        }

        contactList = findViewById(R.id.contact_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adapter.add("");
        contactList.setAdapter(adapter);

    }

    public void callRegisterNota(View view) {

        Intent intent = new Intent(this, RegisterNotaActivity.class);
        startActivityForResult(intent, 100);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("MainActivity","requestCode:" + requestCode + " - resultCode:" + resultCode + " - data:" + data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                if(bundle != null){

                    String fullname = bundle.getString("fullname");
                    Log.d("MainActivity", " User " + fullname);

                    // Añadir un elemento al listview
                    ArrayAdapter<String> adapter = (ArrayAdapter<String>)contactList.getAdapter();
                    adapter.add(fullname);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

}


