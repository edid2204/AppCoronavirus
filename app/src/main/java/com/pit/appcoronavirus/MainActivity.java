package com.pit.appcoronavirus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Fragmentos.AlertFragment;
import Fragmentos.CiudadanoFragment2;
import Fragmentos.DatosFragment;
import Fragmentos.MapFragment;
import Fragmentos.ciudadano_Fragment;


public class MainActivity extends AppCompatActivity {

    //Referenciar objeto
    BottomNavigationView mBottonNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrarUsuario();

        //Fragment por defecto
        mostrarFragmento(new AlertFragment());

        //Intanciar objeto
        mBottonNavigation=(BottomNavigationView) findViewById(R.id.bottomNavigation);

        //Saber a que boton se da click
        mBottonNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {



                if(menuItem.getItemId()==R.id.menu_alert){
                    //Llamar al metodo y enviar fragment
                    mostrarFragmento(new AlertFragment());
                }

                if(menuItem.getItemId()==R.id.menu_map){
                    mostrarFragmento(new MapFragment());
                }

                if(menuItem.getItemId()==R.id.menu_triaje){
                    mostrarFragmento(new ciudadano_Fragment());
                    
                }

                if(menuItem.getItemId()==R.id.menu_datos){
                    mostrarFragmento(new DatosFragment());
                }

                if(menuItem.getItemId()==R.id.menu_menu){

                }

                return true;
            }
        });

    }

    //Metodo que permite elegir el Fragment
    //container: framelayout en activity main
    private void mostrarFragmento(Fragment frag){

        getSupportFragmentManager().beginTransaction().replace(R.id.container,frag)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    //Iniciar activity registrar usuario
    public void registrarUsuario(){

        Intent intent=new Intent(this,activity_regusuario.class);
        startActivity(intent);

    }


}
