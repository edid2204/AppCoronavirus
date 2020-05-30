package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class DatosActivity extends AppCompatActivity {

    TextView txtNum1,txtNac1,txtTipo1,txtDoc1;
    Button btnRegresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        txtNum1=(TextView) findViewById(R.id.txtNumero);
        txtNac1=(TextView) findViewById(R.id.txtNac);
        txtTipo1=(TextView) findViewById(R.id.txtTipoDoc);
        txtDoc1=(TextView) findViewById(R.id.txtNroDoc);


        btnRegresar=(Button) findViewById(R.id.btnRegresar);

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

}
