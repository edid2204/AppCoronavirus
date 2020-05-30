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

public class activity_regusuario extends AppCompatActivity {

    //Declariacion de objetos
    EditText numcel,numdoc;
    Spinner spinac,spitipo;
    Button btnregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regusuario);

        //Obtener referencia para carga de Spinners
        spinac=(Spinner) findViewById(R.id.spiNacionalidad);
        spitipo=(Spinner) findViewById(R.id.spiTipodoc);

        //Crear Adapter Nacionalidad
        String[] nacionalidad=new String[]{"Peruano","Venezolano","Chileno","Ecuatoriano","Colombiano"};
        ArrayAdapter<String> adpnacion=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nacionalidad);
        spinac.setAdapter(adpnacion);

        //Crear Adapter Tipo Documento
        String[] tipodoc=new String[]{"DNI","CE","PTP","Pasaporte"};
        ArrayAdapter<String>adptipo=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipodoc);
        spitipo.setAdapter(adptipo);

        //Obtener referencia
        numcel=(EditText) findViewById(R.id.edtNumero);
        spinac=(Spinner) findViewById(R.id.spiNacionalidad);
        spitipo=(Spinner) findViewById(R.id.spiTipodoc);
        numdoc=(EditText) findViewById(R.id.edtNroDoc);
        btnregistrar=(Button) findViewById(R.id.btnRegUsuario);

        //Codigo del boton registrar
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ejecutarServicio("http://192.168.1.61:8080/pitperu_bd/insertar_usuario.php");

                //Muestra Menu Principal
                mostrarMenuPrincipal();

            }
        });

    }

    //Metodo que envia las peticiones al server url: ruta del webservice
    private void ejecutarServicio(String URL){
        //Declara peticion y tipo
        StringRequest sr=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"SE REGISTRO USUARIO",Toast.LENGTH_SHORT).show();
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

                parametros.put("NumCelular",numcel.getText().toString());
                parametros.put("Nacionalidad",spinac.getSelectedItem().toString());
                parametros.put("TipoDocumento",spitipo.getSelectedItem().toString());
                parametros.put("NumDocumento",numdoc.getText().toString());
                return parametros;
            }
        };
        //Creacion de cola para agrgar la conexion para su ejecucion
        RequestQueue rq= Volley.newRequestQueue(this);
        rq.add(sr);

    }

    public void mostrarMenuPrincipal(){
        Intent intent=new Intent(this,MenuPrincipal.class);

        startActivity(intent);
    }


}
