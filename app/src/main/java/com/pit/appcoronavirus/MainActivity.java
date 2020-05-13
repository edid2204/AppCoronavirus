package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    //Creacion de variables
    EditText numcel,numdoc;
    Spinner spinac,spitipo;
    Button btnregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtener referencia para carga de Spinners
        spinac=(Spinner) findViewById(R.id.spiNacionalidad);
        spitipo=(Spinner) findViewById(R.id.spiTipodoc);

        //Crear Adapter Nacionalidad
        String[] nacionalidad=new String[]{"Peruano","Venezolano","Chileno","Ecuatoriano","Colombiano"};
        ArrayAdapter<String>adpnacion=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nacionalidad);
        spinac.setAdapter(adpnacion);

        //Crear Adapter Tipo Documento
        String[] tipodoc=new String[]{"DNI","CE","PTP","Pasaporte"};
        ArrayAdapter<String>adptipo=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipodoc);
        spitipo.setAdapter(adptipo);

        //Obtener referencia para envio de datos
        numcel=(EditText) findViewById(R.id.edtNumero);
        spinac=(Spinner) findViewById(R.id.spiNacionalidad);
        spitipo=(Spinner) findViewById(R.id.spiTipodoc);
        numdoc=(EditText) findViewById(R.id.edtNroDoc);
        btnregistrar=(Button) findViewById(R.id.btnRegistrar);

        //Codigo del boton registrar
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //Metodo que envia las peticiones al server url: ruta del webservice


}
