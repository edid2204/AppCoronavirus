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

    TextView canconf;
    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cifras);

        canconf=(TextView) findViewById(R.id.txtConfirmado);
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

        String url="http://env-6410274.j.layershift.co.uk/servicio_web/rest/estado";


        JsonObjectRequest jr=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray json=response.getJSONArray("estado");

                    int cont=0;

                    for(int i=0; i<json.length();i++){
                        JSONObject e=json.getJSONObject(i);
                        String est=e.getString("estado");
                        if(est.equals("Positivo")){
                            cont++;
                        }
                    }
                    canconf.setText(cont);

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
