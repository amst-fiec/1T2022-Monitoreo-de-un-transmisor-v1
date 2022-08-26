package com.example.trackfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;


public class Menu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        ImageView bperfil = findViewById(R.id.imgperf);
        bperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Perfil.class);
                Intent intent = getIntent();
                HashMap<String, String> info_user = (HashMap<String, String>)intent.getSerializableExtra("info_user");
                i.putExtra("userid", info_user.get("user_id"));
                i.putExtra("username",info_user.get("user_name"));
                i.putExtra("useremail",info_user.get("user_email"));
                i.putExtra("userphoto",info_user.get("user_photo"));
                startActivity(i);
            }
        });

    }
    public void listadisps(View v){
        Intent i = new Intent(getBaseContext(), ListaDispositivos.class);
        startActivity(i);
    }
    public void cerrarSesion(View view){
        FirebaseAuth.getInstance().signOut();
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("msg", "cerrarSesion");
        startActivity(intent);
    }

}