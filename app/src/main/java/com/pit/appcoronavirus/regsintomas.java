package com.pit.appcoronavirus;

import android.content.Intent;
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
    String dni;

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
        btnregistrar=(Button) findViewById(R.id.btnRegSintomas);
        dni=getIntent().getStringExtra("dni");


        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://192.168.1.61:8080/pitperu_bd/insertar_sintoma.php");
                MenuPrincipal();
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

                String cad1="",cad2="",cad3="",cad4="",cad5="";

                if(chktos.isChecked()==true){
                    cad1+="si";
                    parametros.put("tos",cad1);
                }else{
                    cad1+="no";
                    parametros.put("tos",cad1);
                }
                if(chkfiebre.isChecked()==true){
                    cad2+="si";
                    parametros.put("fiebre",cad2);
                }else{
                    cad2+="no";
                    parametros.put("fiebre",cad2);
                }
                if(chkcansancio.isChecked()==true){
                    cad3+="si";
                    parametros.put("cansancio",cad3);
                }else{
                    cad3+="no";
                    parametros.put("cansancio",cad3);
                }
                if(chkrespirar.isChecked()==true){
                    cad4+="si";
                    parametros.put("dificultadrespirar",cad4);
                }else{
                    cad4+="no";
                    parametros.put("dificultadrespirar",cad4);
                }
                if(chkcontacto.isChecked()==true){
                    cad5+="si";
                    parametros.put("contactoconfirmado",cad5);
                }else{
                    cad5+="no";
                    parametros.put("contactoconfirmado",cad5);
                }
                parametros.put("dni",dni);

                return parametros;
            }
        };
        //Proceso y ejecucion de peticion
        RequestQueue rq= Volley.newRequestQueue(this);
        rq.add(sr);

    }

    public void MenuPrincipal(){

        Intent intent=new Intent(this,MenuPrincipal.class);
        startActivity(intent);

    }


}
