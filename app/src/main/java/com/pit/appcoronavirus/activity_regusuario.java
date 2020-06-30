package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

public class activity_regusuario extends AppCompatActivity {

    //Declariacion de objetos
    EditText numcel,numdoc;
    Spinner spinac,spitipo;
    Button btnregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regusuario);

        //Obtener referencia para carga de Spinners
        spinac=(Spinner) findViewById(R.id.spiNacionalidad);
        spitipo=(Spinner) findViewById(R.id.spiTipodoc);

        //Crear Adapter Nacionalidad
        String[] nacionalidad=new String[]{"Peruano","Venezolano","Chileno","Ecuatoriano","Colombiano"};
        ArrayAdapter<String> adpnacion=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nacionalidad);
        spinac.setAdapter(adpnacion);

        //Crear Adapter Tipo Documento
        String[] tipodoc=new String[]{"DNI","CE","PTP","Pasaporte"};
        ArrayAdapter<String>adptipo=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipodoc);
        spitipo.setAdapter(adptipo);

        //Obtener referencia
        numcel=(EditText) findViewById(R.id.edtNumero);
        spinac=(Spinner) findViewById(R.id.spiNacionalidad);
        spitipo=(Spinner) findViewById(R.id.spiTipodoc);
        numdoc=(EditText) findViewById(R.id.edtNroDoc);
        btnregistrar=(Button) findViewById(R.id.btnRegUsuario);

        //Codigo del boton registrar
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pattern p=Pattern.compile("[1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
                Pattern p1=Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");

                if(numcel.getText().toString().trim().equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "FAVOR DE REGISTRAR CELULAR", Toast.LENGTH_SHORT).show();
                }else if(numdoc.getText().toString().trim().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"FAVOR DE REGISTRAR NUMERO DE DOCUMENTO",Toast.LENGTH_SHORT).show();
                }else if(p.matcher(numcel.getText().toString()).matches()==false){
                    Toast.makeText(getApplicationContext(), "FAVOR DE INGRESAR 9 DIGITOS EN CELULAR", Toast.LENGTH_SHORT).show();
                }else if(p1.matcher(numdoc.getText().toString()).matches()==false){
                    Toast.makeText(getApplicationContext(), "FAVOR DE INGRESAR 8 DIGITOS EN DNI", Toast.LENGTH_SHORT).show();
                }else {

                    //Cargar datos del propietario del celular
                    cargarPreferencias();

                    //Pasar el valor a true

                    SharedPreferences preferencias=getSharedPreferences("variables",Context.MODE_PRIVATE);
                    Boolean bandActivity=preferencias.getBoolean("bandera",false);

                    if(bandActivity==false){
                        SharedPreferences.Editor editor=preferencias.edit();
                        editor.putBoolean("bandera",true);
                        editor.commit();

                        mostrarMenuPrincipal();


                    }

                }
            }
        });

    }

    public void mostrarMenuPrincipal(){
        Intent intent=new Intent(this,MenuPrincipal.class);

        startActivity(intent);
    }

    //Cargar datos en archivo de preferencias
    public void cargarPreferencias(){

        //Almacenamiento de parametros en archivo de preferencias
        SharedPreferences preferencias= getSharedPreferences("variables",Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=preferencias.edit();

        editor.putString("NumCelular",numcel.getText().toString());
        editor.putString("Nacionalidad",spinac.getSelectedItem().toString());
        editor.putString("TipoDocumento",spitipo.getSelectedItem().toString());
        editor.putString("NumDocumento",numdoc.getText().toString());
        editor.putBoolean("bandera",false);

        editor.commit();
    }








}
