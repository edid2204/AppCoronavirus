package com.pit.appcoronavirus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class regsintomas extends AppCompatActivity {

    //Declariacion de objetos
    CheckBox chkgusto,chktos,chkgarganta,chkrespirar,chkcongestion,chkfiebre,chkotro;
    EditText edtotro;
    RadioButton rbtfiebre1,rbtfiebre2;
    Spinner spidia,spimes,spiano;
    Button btncontinuar;
    String dni, cad1="",cad2="",cad3="",cad4="",cad5="",cad6="",cad7="",cad8="",cad9="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsintomas);

        //Obtener referencia para envio de datos
        chkgusto= (CheckBox) findViewById(R.id.chkgusto);
        chktos= (CheckBox) findViewById(R.id.chktos);
        chkgarganta= (CheckBox) findViewById(R.id.chkgarganta);
        chkrespirar= (CheckBox) findViewById(R.id.chkrespirar);
        chkcongestion= (CheckBox) findViewById(R.id.chkcongestion);
        chkfiebre= (CheckBox) findViewById(R.id.chkfiebre);
        rbtfiebre1=(RadioButton) findViewById(R.id.rbtfiebre1);
        rbtfiebre2=(RadioButton) findViewById(R.id.rbtfiebre2);
        chkotro= (CheckBox) findViewById(R.id.chkotro);
        edtotro=(EditText) findViewById(R.id.edtOtro);
        spidia= (Spinner) findViewById(R.id.spiDia);
        spimes= (Spinner) findViewById(R.id.spiMes);
        spiano= (Spinner) findViewById(R.id.spiAno);
        btncontinuar=(Button) findViewById(R.id.btnContinuar);

        //Crear Adapter Dia
        String[] Dia=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        ArrayAdapter<String> adpdia=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Dia);
        spidia.setAdapter(adpdia);

        //Crear Adapter Mes
        String[] Mes=new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
        ArrayAdapter<String> adpmes=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Mes);
        spimes.setAdapter(adpmes);

        //Crear Adapter Año
        String[] Ano=new String[]{"1970","1980","1999","2000","2020"};
        ArrayAdapter<String> adpano=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Ano);
        spiano.setAdapter(adpano);

        dni=getIntent().getStringExtra("dni");

        if(chkgusto.isChecked()==true){
            cad1+="si";
        }else{
            cad1+="no";
        }

        if(chktos.isChecked()==true){
            cad2+="si";
        }else{
            cad2+="no";
        }

        if(chkgarganta.isChecked()==true){
            cad3+="si";
        }else{
            cad3+="no";
        }
        if(chkrespirar.isChecked()==true){
            cad4+="si";
        }else{
            cad4+="no";
        }
        if(chkcongestion.isChecked()==true){
            cad5+="si";
        }else{
            cad5+="no";
        }
        if(chkfiebre.isChecked()==true){
            cad6+="si";
        }else{
            cad6+="no";
        }
        if(rbtfiebre1.isChecked()==true){
            cad7+="si";
        }else{
            cad7+="no";
        }
        if(rbtfiebre2.isChecked()==true){
            cad8+="si";
        }else{
            cad8+="no";
        }
        if(chkotro.isChecked()==true){
            cad9+="si";
        }else{
            cad9+="no";
        }

        btncontinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mostrarRiesgos();

            }
        });

    }

    public void mostrarRiesgos(){

        Intent intent=new Intent(this,regriesgos.class);
        intent.putExtra("dni",dni);
        intent.putExtra("gusto",cad1);
        intent.putExtra("tos",cad2);
        intent.putExtra("garganta",cad3);
        intent.putExtra("respirar",cad4);
        intent.putExtra("congestion",cad5);
        intent.putExtra("fiebre",cad6);
        intent.putExtra("fiebre1",cad7);
        intent.putExtra("fiebre2",cad8);
        intent.putExtra("otro",cad9);
        intent.putExtra("obs",edtotro.getText().toString());
        intent.putExtra("dia",spidia.getSelectedItem().toString());
        intent.putExtra("mes",spimes.getSelectedItem().toString());
        intent.putExtra("ano",spiano.getSelectedItem().toString());
        startActivity(intent);


    }


}
