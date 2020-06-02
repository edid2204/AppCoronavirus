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

public class Regciudadano extends AppCompatActivity {

    //Declaración de objetos
    EditText nomCiudadano,direccion,nroCell,nroDocum;
    Spinner spiNac,spiDep,spiProv,spiDis,spiTipoDoc,spiDia,spiMes,spiAno;
    Button btnRegCiudadano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regciudadano);

        //Obtener referencia de objetos
        spiNac=(Spinner) findViewById(R.id.spiNacionalidad);
        spiTipoDoc=(Spinner) findViewById(R.id.spiTipodoc);
        nroDocum=(EditText) findViewById(R.id.edtNroDoc);
        nroCell=(EditText) findViewById(R.id.edtNumero);
        nomCiudadano=(EditText) findViewById(R.id.edtNombre);
        spiDia=(Spinner) findViewById(R.id.spiDia);
        spiMes=(Spinner) findViewById(R.id.spiMes);
        spiAno=(Spinner) findViewById(R.id.spiAno);
        direccion=(EditText) findViewById(R.id.edtDireccion);
        spiDep=(Spinner) findViewById(R.id.spiDepartamento);
        spiProv=(Spinner) findViewById(R.id.spiProvincia);
        spiDis=(Spinner) findViewById(R.id.spiDistrito);
        btnRegCiudadano=(Button) findViewById(R.id.btnRegCiudadano);

        //Crear Adapter Nacionalidad
        String[] nacionalidad=new String[]{"Peruano","Venezolano","Chileno","Ecuatoriano","Colombiano"};
        ArrayAdapter<String> adpnacion=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nacionalidad);
        spiNac.setAdapter(adpnacion);

        //Crear Adapter Tipo Documento
        String[] tipodoc=new String[]{"DNI","CE","PTP","Pasaporte"};
        ArrayAdapter<String>adptipo=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipodoc);
        spiTipoDoc.setAdapter(adptipo);

        //Crear Adapter Departamento
        String[] departamento=new String[]{"Amazonas","Ancash","Apurimac","Arequipa","Ayacucho","Cajamarca","Callao","Huancavelica","Huanuco","Ica","Junin","La Libertad","Lambayeque","Lima","Loreto","Madre De Dios","Moquegua",
        "Pasco","Piura","Puno","San Martin","Tacna","Tumbes","Ucayali"};
        ArrayAdapter<String> adpdep=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,departamento);
        spiDep.setAdapter(adpdep);

        //Crear Adapter Provincia
        String[] Provincia=new String[]{"Huarochiri","Ricardo Palma","Huaura"};
        ArrayAdapter<String> adpprov=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Provincia);
        spiProv.setAdapter(adpprov);

        //Crear Adapter Distrito
        String[] Distrito=new String[]{"Lince","El Agustino","Los Olivos","Callao","Comas"};
        ArrayAdapter<String> adpdis=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Distrito);
        spiDis.setAdapter(adpdis);

        //Crear Adapter Dia
        String[] Dia=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        ArrayAdapter<String> adpdia=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Dia);
        spiDia.setAdapter(adpdia);

        //Crear Adapter Mes
        String[] Mes=new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
        ArrayAdapter<String> adpmes=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Mes);
        spiMes.setAdapter(adpmes);

        //Crear Adapter Año
        String[] Ano=new String[]{"1970","1980","1999","2000","2010"};
        ArrayAdapter<String> adpano=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Ano);
        spiAno.setAdapter(adpano);

        //Código de boton Registrar Ciudadano
        btnRegCiudadano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ejecutarServicio("http://192.168.1.61:8080/pitperu_bd/insertar_ciudadano.php");
                //Llama activiy Sintomas
                MostrarSintomas();

            }
        });


    }

    //Metodo que envia las peticiones al server url: ruta del webservice
    private void ejecutarServicio(String URL){
        //Declara peticion y tipo
        StringRequest sr=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"SE REGISTRO CIUDADANO",Toast.LENGTH_SHORT).show();
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
                parametros.put("Nacionalidad",spiNac.getSelectedItem().toString());
                parametros.put("TipoDocumento",spiTipoDoc.getSelectedItem().toString());
                parametros.put("NumDocumento",nroDocum.getText().toString());
                parametros.put("NumCelular",nroCell.getText().toString());
                parametros.put("Nombre",nomCiudadano.getText().toString());
                parametros.put("Dia",spiDia.getSelectedItem().toString());
                parametros.put("Mes",spiMes.getSelectedItem().toString());
                parametros.put("Ano",spiAno.getSelectedItem().toString());
                parametros.put("Direccion",direccion.getText().toString());
                parametros.put("Departamento",spiDep.getSelectedItem().toString());
                parametros.put("Provincia",spiProv.getSelectedItem().toString());
                parametros.put("Distrito",spiDis.getSelectedItem().toString());

                return parametros;
            }
        };
        //Proceso y ejecucion de peticion
        RequestQueue rq= Volley.newRequestQueue(this);
        rq.add(sr);

    }

    //Muestra inteface de Sintomas enviando parametro dni
    public void MostrarSintomas(){

        Intent intent=new Intent(this,regsintomas.class);
        intent.putExtra("dni",nroDocum.getText().toString());
        startActivity(intent);

    }
}
