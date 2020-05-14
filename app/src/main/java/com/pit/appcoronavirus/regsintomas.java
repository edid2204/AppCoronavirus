package com.pit.appcoronavirus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class regsintomas extends AppCompatActivity {

    //Declariacion de objetos
    CheckBox chktos,chkfiebre,chkcansancio,chkrespirar,chkcontacto;
    Button btnregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsintomas);

        //Obtener referencia para envio de datos
        chktos= (CheckBox) findViewById(R.id.chktos);
        chkfiebre= (CheckBox) findViewById(R.id.chkfiebre);
        chkcansancio= (CheckBox) findViewById(R.id.chkcansancio);
        chkrespirar= (CheckBox) findViewById(R.id.chkrespirar);
        chkcontacto= (CheckBox) findViewById(R.id.chkcontacto);
        btnregistrar=(Button) findViewById(R.id.btnRegistrar);


        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://192.168.1.61:8080/pitperu_bd/insertar_sintoma.php");
            }
        });

    }

    private void ejecutarServicio(String URL){
        //Declara peticion y tipo
        StringRequest sr=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"SE REGISTRO SINTOMAS",Toast.LENGTH_SHORT).show();
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

                if(chktos.isChecked()){
                    parametros.put("tos",chktos.getText().toString());
                }else{
                    parametros.put("tos",chktos.getText().toString());
                }
                if(chkfiebre.isChecked()){
                    parametros.put("fiebre",chkfiebre.getText().toString());
                }else{
                    parametros.put("fiebre",chkfiebre.getText().toString());
                }
                if(chkcansancio.isChecked()){
                    parametros.put("cansancio",chkcansancio.getText().toString());
                }else{
                    parametros.put("cansancio",chkcansancio.getText().toString());
                }
                if(chkrespirar.isChecked()){
                    parametros.put("dificultadrespirar",chkrespirar.getText().toString());
                }else{
                    parametros.put("dificultadrespirar",chkrespirar.getText().toString());
                }
                if(chkcontacto.isChecked()){
                    parametros.put("contactoconfirmado",chkcontacto.getText().toString());
                }else{
                    parametros.put("contactoconfirmado",chkcontacto.getText().toString());
                }


                return parametros;
            }
        };
        //Proceso y ejecucion de peticion
        RequestQueue rq= Volley.newRequestQueue(this);
        rq.add(sr);

    }


}
