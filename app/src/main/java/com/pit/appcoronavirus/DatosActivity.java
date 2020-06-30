package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {

    TextView txtNum,txtNac,txtTipo,txtDoc,txtBand;
    Button btnRegresar,btnSession;
    String num,nac,tipo,doc;
    boolean band;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);



        txtNum=(TextView) findViewById(R.id.txtNumero);
        txtNac=(TextView) findViewById(R.id.txtNac);
        txtTipo=(TextView) findViewById(R.id.txtTipoDoc);
        txtDoc=(TextView) findViewById(R.id.txtNroDoc);
        txtBand=(TextView) findViewById(R.id.txtBandera);

        SharedPreferences preferencias=getSharedPreferences("variables",Context.MODE_PRIVATE);

        num=preferencias.getString("NumCelular","");
        nac= preferencias.getString("Nacionalidad","");
        tipo=preferencias.getString("TipoDocumento","");
        doc=preferencias.getString("NumDocumento","");
        band=preferencias.getBoolean("bandera",false);

        txtNum.setText(num);
        txtNac.setText(nac);
        txtTipo.setText(tipo);
        txtDoc.setText(doc);
        txtBand.setText("Perfil: "+band);

        btnRegresar=(Button) findViewById(R.id.btnRegresar);
        btnSession=(Button) findViewById(R.id.btnSession);

        btnSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferencias=getSharedPreferences("variables",Context.MODE_PRIVATE);
                Boolean bandActivity=preferencias.getBoolean("bandera",false);
                if(bandActivity==true){

                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putBoolean("bandera",false);
                    editor.commit();

                    mostrarUsuario();

                }


            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarMenu();
            }

        });
    }





    public void mostrarMenu(){
        Intent intent=new Intent(this,MenuPrincipal.class);
        startActivity(intent);
    }

    public void mostrarUsuario(){

        Intent intent=new Intent(this,activity_regusuario.class);
        startActivity(intent);

    }



}
