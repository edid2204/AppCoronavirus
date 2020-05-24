package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Muestra activity Regusuario
        mostrarUsuario();

    }

    //Iniciar activity registrar usuario
    public void mostrarUsuario(){

        Intent intent=new Intent(this,activity_regusuario.class);
        startActivity(intent);

    }




}
