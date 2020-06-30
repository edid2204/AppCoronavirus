package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Verificar estado de bandera de Usuario


            //Muestra activity Regusuario

        Boolean bandActivity=false;

        if(bandActivity){

            mostrarUsuario();

        }else{

            SharedPreferences preferencias=getSharedPreferences("variables",Context.MODE_PRIVATE);
            Boolean pref=preferencias.getBoolean("bandera",false);

            if(pref==false){
                mostrarUsuario();
            }else{
                mostrarMenuPrincipal();
            }
        }

    }

    //Iniciar activity registrar usuario
    public void mostrarUsuario(){

        Intent intent=new Intent(this,activity_regusuario.class);
        startActivity(intent);

    }

    public void mostrarMenuPrincipal(){
        Intent intent=new Intent(this,MenuPrincipal.class);

        startActivity(intent);
    }

}
