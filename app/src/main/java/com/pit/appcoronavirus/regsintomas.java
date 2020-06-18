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

        if(chkgusto.isChecked()==true){
            cad1+="si";
            intent.putExtra("gusto",cad1);
        }else{
            cad1+="no";
            intent.putExtra("gusto",cad1);
        }

        if(chktos.isChecked()==true){
            cad2+="si";
            intent.putExtra("tos",cad2);
        }else{
            cad2+="no";
            intent.putExtra("tos",cad2);
        }

        if(chkgarganta.isChecked()==true){
            cad3+="si";
            intent.putExtra("garganta",cad3);
        }else{
            cad3+="no";
            intent.putExtra("garganta",cad3);
        }
        if(chkrespirar.isChecked()==true){
            cad4+="si";
            intent.putExtra("respirar",cad4);
        }else{
            cad4+="no";
            intent.putExtra("respirar",cad4);
        }
        if(chkcongestion.isChecked()==true){
            cad5+="si";
            intent.putExtra("congestion",cad5);
        }else{
            cad5+="no";
            intent.putExtra("congestion",cad5);
        }
        if(chkfiebre.isChecked()==true){
            cad6+="si";
            intent.putExtra("fiebre",cad6);
        }else{
            cad6+="no";
            intent.putExtra("fiebre",cad6);
        }
        if(rbtfiebre1.isChecked()==true){
            cad7+="si";
            intent.putExtra("fiebre1",cad7);
        }else{
            cad7+="no";
            intent.putExtra("fiebre1",cad7);
        }
        if(rbtfiebre2.isChecked()==true){
            cad8+="si";
            intent.putExtra("fiebre2",cad8);
        }else{
            cad8+="no";
            intent.putExtra("fiebre2",cad8);
        }
        if(chkotro.isChecked()==true){
            cad9+="si";
            intent.putExtra("otro",cad9);
        }else{
            cad9+="no";
            intent.putExtra("otro",cad9);
        }

        intent.putExtra("obs",edtotro.getText().toString());
        intent.putExtra("dia",spidia.getSelectedItem().toString());
        intent.putExtra("mes",spimes.getSelectedItem().toString());
        intent.putExtra("ano",spiano.getSelectedItem().toString());
        startActivity(intent);

    }


}
