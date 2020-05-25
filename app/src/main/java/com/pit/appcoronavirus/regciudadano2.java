package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class regciudadano2 extends AppCompatActivity {

    //Declaración de objetos
    EditText nroCell,nroDocum;
    Spinner spiNac,spiTipoDoc;
    Button btnRegCiudadano;
    String nombre,edad,direccion,dep,prov,dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regciudadano2);

        //Obtener referencia para carga de Spinners
        spiNac=(Spinner) findViewById(R.id.spiNacionalidad);
        spiTipoDoc=(Spinner) findViewById(R.id.spiTipodoc);

        //Crear Adapter Nacionalidad
        String[] nacionalidad=new String[]{"Peruano","Venezolano","Chileno","Ecuatoriano","Colombiano"};
        ArrayAdapter<String> adpnacion=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nacionalidad);
        spiNac.setAdapter(adpnacion);

        //Crear Adapter Tipo Documento
        String[] tipodoc=new String[]{"DNI","CE","PTP","Pasaporte"};
        ArrayAdapter<String>adptipo=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipodoc);
        spiTipoDoc.setAdapter(adptipo);

        //Obtener referencia para envio de datos
        nroCell=(EditText) findViewById(R.id.edtNumero);
        spiNac=(Spinner) findViewById(R.id.spiNacionalidad);
        spiTipoDoc=(Spinner) findViewById(R.id.spiTipodoc);
        nroDocum=(EditText) findViewById(R.id.edtNroDoc);
        btnRegCiudadano=(Button) findViewById(R.id.btnRegCiudadano);
        nombre=getIntent().getStringExtra("nombre");
        edad=getIntent().getStringExtra("edad");
        direccion=getIntent().getStringExtra("direccion");
        dep=getIntent().getStringExtra("dep");
        prov=getIntent().getStringExtra("prov");
        dis=getIntent().getStringExtra("dis");

        btnRegCiudadano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //llamar al metodo

                ejecutarServicio("http://192.168.1.61:8080/pitperu_bd/insertar_ciudadano.php");
                MostrarSintomas();
            }

        });
    }
    //Metodo que envia las peticiones al server url: ruta del webservice
    private void ejecutarServicio(String URL){
        //Declara peticion y tipo
        StringRequest sr=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"SE REGISTRO CIUDADANO",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }

        }){
            //Envio de parametros
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                parametros.put("nombre",nombre);
                parametros.put("edad",edad);
                parametros.put("direccion",direccion);
                parametros.put("dep",dep);
                parametros.put("prov",prov);
                parametros.put("dis",dis);
                parametros.put("NumCelular",nroCell.getText().toString());
                parametros.put("Nacionalidad",spiNac.getSelectedItem().toString());
                parametros.put("TipoDocumento",spiTipoDoc.getSelectedItem().toString());
                parametros.put("NumDocumento",nroDocum.getText().toString());
                return parametros;
            }
        };
        //Proceso y ejecucion de peticion
        RequestQueue rq= Volley.newRequestQueue(this);
        rq.add(sr);

    }

    public void MostrarSintomas(){

        Intent intent=new Intent(this,regsintomas.class);
        intent.putExtra("dni",nroDocum.getText().toString());
        startActivity(intent);

    }
}
