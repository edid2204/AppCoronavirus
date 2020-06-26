package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cifras extends AppCompatActivity {

    TextView canconf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_datos);

        canconf=(TextView) findViewById(R.id.txtConfirmado);

        ejecutarServicio();



    }

    private void ejecutarServicio(){

        String url="http://env-6410274.j.layershift.co.uk/servicio_web/rest/estado";

        JsonObjectRequest jr=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                showTextView(response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(jr);

    }

    private void showTextView(JSONObject obj){
        try {

            JSONArray lista=obj.optJSONArray("");


            int conta=0;

            for(int i=0;i<lista.length();i++){

                JSONObject json=lista.getJSONObject(i);

                conta=conta+1;
            }
            canconf.setText(conta);

        }catch(Exception e){
            e.printStackTrace();

        }
    }

}
