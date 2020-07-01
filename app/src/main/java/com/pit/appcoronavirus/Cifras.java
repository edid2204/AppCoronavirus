package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

import java.util.HashMap;
import java.util.Map;

public class Cifras extends AppCompatActivity {

    TextView canconf,canrec,canuci,canteva,cantfall;
    Button regresar;
    Spinner depa;

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
        depa=(Spinner) findViewById(R.id.spiDep);

        //Crear Adapter Departamento
        final String[] departamento=new String[]{"Perú","Amazonas","Ancash","Apurimac","Arequipa","Ayacucho","Cajamarca","Callao","Huancavelica","Huanuco","Ica","Junin","La Libertad","Lambayeque","Lima","Loreto","Madre De Dios","Moquegua",
                "Pasco","Piura","Puno","San Martin","Tacna","Tumbes","Ucayali"};
        ArrayAdapter<String> adpdep=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,departamento);
        depa.setAdapter(adpdep);


        depa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String d=parent.getItemAtPosition(position).toString();

                    ejecutarServicioxdep(d);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarMenu();
            }
        });
    }

    private void ejecutarServicioxdep(final String depa){

        String url="http://grupo2-pit.j.layershift.co.uk/Services/select_estado_get.php";


        JsonObjectRequest jr=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray json=response.getJSONArray("postData");

                    int contc=0, contr=0,contu=0,conte=0,contf=0;

                    Toast.makeText(getApplicationContext(),depa,Toast.LENGTH_SHORT).show();

                    for(int i=0; i<json.length();i++) {

                        JSONObject e = json.getJSONObject(i);

                            contc++;

                            String estado = e.getString("condicion");

                            if (estado.equals("Recuperado")) {
                                contr++;
                            }
                            if (estado.equals("UCI")) {
                                contu++;
                            }
                            if (estado.equals("Evaluacion")) {
                                conte++;
                            }
                            if (estado.equals("Fallecido")) {
                                contf++;
                            }


                            canconf.setText(""+contc);
                            canrec.setText("" + contr);
                            canuci.setText("" + contu);
                            canteva.setText("" + conte);
                            cantfall.setText("" + contf);
                    }

                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){

            //Envio de parametros
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                parametros.put("Departamento",depa);


                return parametros;
            }

        };

        RequestQueue rq= Volley.newRequestQueue(this);
        rq.add(jr);

    }

    public void mostrarMenu(){
        Intent intent=new Intent(this,MenuPrincipal.class);
        startActivity(intent);
    }

}
