package Fragmentos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.pit.appcoronavirus.R;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatosFragment extends Fragment {


    public DatosFragment() {
        // Required empty public constructor
    }

    TextView canconf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_datos, container, false);

        canconf=(TextView) v.findViewById(R.id.txtConfirmado);

        ejecutarServicio();

        return v;
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
                Toast.makeText(getContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue rq=Volley.newRequestQueue(getContext());
        rq.add(jr);

    }

    private void showTextView(JSONObject obj){
        try {

            JSONArray lista=obj.optJSONArray("");


            int conta=0;

            for(int i=0;i<lista.length();i++){

                JSONObject json=lista.getJSONObject(i);

                String estado=json.getString("estado");

                if(estado.equals("Positivo")){
                    conta=conta+1;
                }
            }
            canconf.setText("Nro. Casos: "+conta);

        }catch(Exception e){
            e.printStackTrace();

        }
    }


}
