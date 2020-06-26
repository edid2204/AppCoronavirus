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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class regriesgos extends AppCompatActivity {

    //Declariacion de objetos
    CheckBox chkalerta,chkcontacto,chksalir,chktrabajo,chkobesidad,chkpulmonar,chkasma,chkdiabetes,chkhiper,chkinmune,chkcardio,chkrenal,chkcancer;
    Button btnregistrar;
    String dni,gusto,tos,garganta,respirar,congestion,fiebre,fiebre1,fiebre2,otro,obs,dia,mes,ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regriesgos);

        //Obtener referencia para envio de datos
        chkalerta= (CheckBox) findViewById(R.id.chkalerta);
        chkcontacto= (CheckBox) findViewById(R.id.chkcontacto);
        chksalir= (CheckBox) findViewById(R.id.chksalir);
        chktrabajo= (CheckBox) findViewById(R.id.chktrabajo);
        chkobesidad= (CheckBox) findViewById(R.id.chkobesidad);
        chkpulmonar= (CheckBox) findViewById(R.id.chkpulmonar);
        chkasma= (CheckBox) findViewById(R.id.chkasma);
        chkdiabetes= (CheckBox) findViewById(R.id.chkdiabetes);
        chkhiper= (CheckBox) findViewById(R.id.chkhipertension);
        chkinmune= (CheckBox) findViewById(R.id.chkinmune);
        chkcardio= (CheckBox) findViewById(R.id.chkcardio);
        chkrenal= (CheckBox) findViewById(R.id.chkrenal);
        chkcancer= (CheckBox) findViewById(R.id.chkcancer);
        btnregistrar=(Button) findViewById(R.id.btnRegistrar);

        dni=getIntent().getStringExtra("dni");
        gusto=getIntent().getStringExtra("gusto");
        tos=getIntent().getStringExtra("tos");
        garganta=getIntent().getStringExtra("garganta");
        respirar=getIntent().getStringExtra("respirar");
        congestion=getIntent().getStringExtra("congestion");
        fiebre=getIntent().getStringExtra("fiebre");
        fiebre1=getIntent().getStringExtra("fiebre1");
        fiebre2=getIntent().getStringExtra("fiebre2");
        otro=getIntent().getStringExtra("otro");
        obs=getIntent().getStringExtra("obs");
        dia=getIntent().getStringExtra("dia");
        mes=getIntent().getStringExtra("mes");
        ano=getIntent().getStringExtra("ano");

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ejecutarServicio("http://pit-covid19.j.layershift.co.uk/Services/insertar_sintoma.php");

                ejecutarServicio("http://env-6410274.j.layershift.co.uk/servicio_web/rest/sintomas/");

                mostrarMenuPrincipal();
            }
        });

    }


    //Metodo que envia las peticiones al server url: ruta del webservice Java
    private void ejecutarServicio(String URL){

        //Envio de parametros

            Map<String,String> parametros=new HashMap<String,String>();
            parametros.put("dni",dni);
            parametros.put("gusto",gusto);
            parametros.put("tos",tos);
            parametros.put("garganta",garganta);
            parametros.put("respirar",respirar);
            parametros.put("congestion",congestion);
            parametros.put("fiebre",fiebre);
            parametros.put("fiebre1",fiebre1);
            parametros.put("fiebre2",fiebre2);
            parametros.put("otro",otro);
            parametros.put("observacion",obs);
            parametros.put("dia",dia);
            parametros.put("mes",mes);
            parametros.put("ano",ano);
            parametros.put("estado","");

            String cad1="",cad2="",cad3="",cad4="",cad5="",cad6="",cad7="",cad8="",cad9="",cad10="",cad11="",cad12="",cad13="";

            if(chkalerta.isChecked()==true){
                cad1+="Sí";
                parametros.put("alerta",cad1);
            }else{
                cad1+="No";
                parametros.put("alerta",cad1);
            }
            if(chkcontacto.isChecked()==true){
                cad2+="Sí";
                parametros.put("contacto",cad2);
            }else{
                cad2+="No";
                parametros.put("contacto",cad2);
            }
            if(chksalir.isChecked()==true){
                cad3+="Sí";
                parametros.put("salir",cad3);
            }else{
                cad3+="No";
                parametros.put("salir",cad3);
            }
            if(chktrabajo.isChecked()==true){
                cad4+="Sí";
                parametros.put("trabajo",cad4);
            }else{
                cad4+="No";
                parametros.put("trabajo",cad4);
            }
            if(chkobesidad.isChecked()==true){
                cad5+="Sí";
                parametros.put("obesidad",cad5);
            }else{
                cad5+="No";
                parametros.put("obesidad",cad5);
            }

            if(chkpulmonar.isChecked()==true){
                cad6+="Sí";
                parametros.put("pulmonar",cad6);
            }else{
                cad6+="No";
                parametros.put("pulmonar",cad6);
            }

            if(chkasma.isChecked()==true){
                cad7+="si";
                parametros.put("asma",cad7);
            }else{
                cad7+="No";
                parametros.put("asma",cad7);
            }

            if(chkdiabetes.isChecked()==true){
                cad8+="Sí";
                parametros.put("diabetes",cad8);
            }else{
                cad8+="No";
                parametros.put("diabetes",cad8);
            }

            if(chkhiper.isChecked()==true){
                cad9+="Sí";
                parametros.put("hipertension",cad9);
            }else{
                cad9+="No";
                parametros.put("hipertension",cad9);
            }

            if(chkinmune.isChecked()==true){
                cad10+="Sí";
                parametros.put("inmune",cad10);
            }else{
                cad10+="No";
                parametros.put("inmune",cad10);
            }

            if(chkcardio.isChecked()==true){
                cad11+="Sí";
                parametros.put("cardio",cad11);
            }else{
                cad11+="No";
                parametros.put("cardio",cad11);
            }

            if(chkrenal.isChecked()==true){
                cad12+="Sí";
                parametros.put("renal",cad12);
            }else{
                cad12+="No";
                parametros.put("renal",cad12);
            }

            if(chkcancer.isChecked()==true){
                cad13+="Sí";
                parametros.put("cancer",cad13);
            }else{
                cad13+="No";
                parametros.put("cancer",cad13);
            }

        JSONObject js=new JSONObject(parametros);

        JsonObjectRequest jr=new JsonObjectRequest(Request.Method.POST, URL, js, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        //Proceso y ejecucion de peticion
        Volley.newRequestQueue(this).add(jr);

    }

    /*
    //Metodo que envia las peticiones al server url: ruta del webservice PHP
    private void ejecutarServicio(String URL){
        //Declara peticion y tipo
        StringRequest sr=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"SE REGISTRO TRIAJE",Toast.LENGTH_SHORT).show();
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
                parametros.put("dni",dni);
                parametros.put("gusto",gusto);
                parametros.put("tos",tos);
                parametros.put("garganta",garganta);
                parametros.put("respirar",respirar);
                parametros.put("congestion",congestion);
                parametros.put("fiebre",fiebre);
                parametros.put("fiebre1",fiebre1);
                parametros.put("fiebre2",fiebre2);
                parametros.put("otro",otro);
                parametros.put("obs",obs);
                parametros.put("dia",dia);
                parametros.put("mes",mes);
                parametros.put("ano",ano);
                parametros.put("estado","");

                String cad1="",cad2="",cad3="",cad4="",cad5="",cad6="",cad7="",cad8="",cad9="",cad10="",cad11="",cad12="",cad13="";

                if(chkalerta.isChecked()==true){
                    cad1+="si";
                    parametros.put("alerta",cad1);
                }else{
                    cad1+="no";
                    parametros.put("alerta",cad1);
                }
                if(chkcontacto.isChecked()==true){
                    cad2+="si";
                    parametros.put("contacto",cad2);
                }else{
                    cad2+="no";
                    parametros.put("contacto",cad2);
                }
                if(chksalir.isChecked()==true){
                    cad3+="si";
                    parametros.put("salir",cad3);
                }else{
                    cad3+="no";
                    parametros.put("salir",cad3);
                }
                if(chktrabajo.isChecked()==true){
                    cad4+="si";
                    parametros.put("trabajo",cad4);
                }else{
                    cad4+="no";
                    parametros.put("trabajo",cad4);
                }
                if(chkobesidad.isChecked()==true){
                    cad5+="si";
                    parametros.put("obesidad",cad5);
                }else{
                    cad5+="no";
                    parametros.put("obesidad",cad5);
                }

                if(chkpulmonar.isChecked()==true){
                    cad6+="si";
                    parametros.put("pulmonar",cad6);
                }else{
                    cad6+="no";
                    parametros.put("pulmonar",cad6);
                }

                if(chkasma.isChecked()==true){
                    cad7+="si";
                    parametros.put("asma",cad7);
                }else{
                    cad7+="no";
                    parametros.put("asma",cad7);
                }

                if(chkdiabetes.isChecked()==true){
                    cad8+="si";
                    parametros.put("diabetes",cad8);
                }else{
                    cad8+="no";
                    parametros.put("diabetes",cad8);
                }

                if(chkhiper.isChecked()==true){
                    cad9+="si";
                    parametros.put("hiper",cad9);
                }else{
                    cad9+="no";
                    parametros.put("hiper",cad9);
                }

                if(chkinmune.isChecked()==true){
                    cad10+="si";
                    parametros.put("inmune",cad10);
                }else{
                    cad10+="no";
                    parametros.put("inmune",cad10);
                }

                if(chkcardio.isChecked()==true){
                    cad11+="si";
                    parametros.put("cardio",cad11);
                }else{
                    cad11+="no";
                    parametros.put("cardio",cad11);
                }

                if(chkrenal.isChecked()==true){
                    cad12+="si";
                    parametros.put("renal",cad12);
                }else{
                    cad12+="no";
                    parametros.put("renal",cad12);
                }

                if(chkcancer.isChecked()==true){
                    cad13+="si";
                    parametros.put("cancer",cad13);
                }else{
                    cad13+="no";
                    parametros.put("cancer",cad13);
                }


                return parametros;
            }
        };
        //Proceso y ejecucion de peticion
        RequestQueue rq= Volley.newRequestQueue(this);
        rq.add(sr);

    }*/

    public void mostrarMenuPrincipal(){
        Intent intent=new Intent(this,MenuPrincipal.class);

        startActivity(intent);
    }

}
