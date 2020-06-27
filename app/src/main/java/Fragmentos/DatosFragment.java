package Fragmentos;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.pit.appcoronavirus.Cifras;
import com.pit.appcoronavirus.DatosActivity;
import com.pit.appcoronavirus.R;
import com.pit.appcoronavirus.Regciudadano;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatosFragment extends Fragment {


    public DatosFragment() {
        // Required empty public constructor
    }

    TextView canconf,canrecup,canfalle,canuci,caneva;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_datos, container, false);

        canconf=(TextView) v.findViewById(R.id.txtConfirmado);
        canrecup=(TextView) v.findViewById(R.id.txtRecuperados);
        canfalle=(TextView) v.findViewById(R.id.txtFallecido);
        canuci=(TextView) v.findViewById(R.id.txtUci);
        caneva=(TextView) v.findViewById(R.id.txtEvaluacion);
        Button btnCifras=(Button) v.findViewById(R.id.btnCifras);

        btnCifras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Cifras.class);
                startActivity(intent);
            }
        });


        return v;
    }

    private void ejecutarServicio(){

        String url="http://env-6410274.j.layershift.co.uk/servicio_web/rest/estado";

        JsonObjectRequest jr=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    //JSONArray jarray=response.getJSONArray("");
                    JSONObject js=response.getJSONObject("");
                    int cont=0;

                    for(int i=0; i<js.length();i++){
                        //JSONObject est=jarray.getJSONObject(i);
                        cont++;
                        //String estado=est.getString("estado");
                        //canconf.append(estado+"\n");
                        canconf.setText(cont);
                    }

                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue rq=Volley.newRequestQueue(getContext());
        rq.add(jr);

    }

    private void showTextView(JSONObject obj){

        int contaconf=0;

        try {

            JSONArray lista=obj.getJSONArray("estado");



            for(int i=0;i<lista.length();i++){

                JSONObject json=lista.getJSONObject(i);
                String estconf=json.getString("estado");

                if(estconf.equals("Positivo")){
                    contaconf++;
                }

            }

        }catch(Exception e){
            e.printStackTrace();

        }

    }


}
