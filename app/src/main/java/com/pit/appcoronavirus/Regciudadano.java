package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Regciudadano extends AppCompatActivity {

    //Declaración de objetos
    EditText nomCiudadano,edad,direccion;
    Spinner spiDep,spiProv,spiDis;
    Button btnContinuar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regciudadano);

        //Obtener referencia para carga de Spinners
        spiDep=(Spinner) findViewById(R.id.spiDepartamento);
        spiProv=(Spinner) findViewById(R.id.spiProvincia);
        spiDis=(Spinner) findViewById(R.id.spiDistrito);

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

        //Obtener referencia para envio de datos
        nomCiudadano=(EditText) findViewById(R.id.edtNombre);
        //edad=(EditText) findViewById(R.id.edtEdad);
        direccion=(EditText) findViewById(R.id.edtDireccion);
        spiDep=(Spinner) findViewById(R.id.spiDepartamento);
        spiProv=(Spinner) findViewById(R.id.spiProvincia);
        spiDis=(Spinner) findViewById(R.id.spiDistrito);
        btnContinuar=(Button) findViewById(R.id.btnContinuar);


        //Código de boton continiuar
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Llama activiy Registro Ciudadano2
                regCiudadano2();

            }
        });


    }

    //Muestra Registro de Ciudadano enviando parametros por bundle
    public void regCiudadano2(){

        Intent intent=new Intent(this,regciudadano2.class);
        intent.putExtra("nombre",nomCiudadano.getText().toString());
        intent.putExtra("edad",edad.getText().toString());
        intent.putExtra("direccion",direccion.getText().toString());
        intent.putExtra("dep",spiDep.getSelectedItem().toString());
        intent.putExtra("prov",spiProv.getSelectedItem().toString());
        intent.putExtra("dis",spiDis.getSelectedItem().toString());
        startActivity(intent);

    }
}
