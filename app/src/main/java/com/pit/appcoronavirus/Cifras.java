package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Cifras extends AppCompatActivity {

    TextView canconf,canrec,canuci,canteva,cantfall;
    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cifras);

        canconf=(TextView) findViewById(R.id.txtConfirmado);
        canrec=(TextView) findViewById(R.id.txtRecuperados);
        canuci=(TextView) findViewById(R.id.txtUci);
        canteva=(TextView) findViewById(R.id.txtEvaluacion);
        cantfall=(TextView) findViewById(R.id.txtFallecido);
        regresar=(Button) findViewById(R.id.btnRegresar);

        ejecutarServicio();

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarMenu();
            }
        });
    }

    private void ejecutarServicio(){

        String url="http://grupo2-pit.j.layershift.co.uk/Services/select_estado_get.php";


        JsonObjectRequest jr=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray json=response.getJSONArray("postData");

                    int contc=0, contr=0,contu=0,conte=0,contf=0;

                    for(int i=0; i<json.length();i++){

                        contc++;

                        JSONObject e=json.getJSONObject(i);

                        String estado=e.getString("condicion");

                        if(estado.equals("Recuperado")){
                            contr++;
                        }
                        if(estado.equals("UCI")){
                            contu++;
                        }
                        if(estado.equals("Evaluacion")){
                            conte++;
                        }
                        if(estado.equals("Fallecido")){
                            contf++;
                        }

                    }
                    canconf.setText(""+contc);
                    canrec.setText(""+contr);
                    canuci.setText(""+contu);
                    canteva.setText(""+conte);
                    cantfall.setText(""+contf);

                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue rq= Volley.newRequestQueue(this);
        rq.add(jr);

    }

    public void mostrarMenu(){
        Intent intent=new Intent(this,MenuPrincipal.class);
        startActivity(intent);
    }

}
