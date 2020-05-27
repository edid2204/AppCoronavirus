package com.pit.appcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {

    String txtNum,txtNac,txtTipo,txtDoc;
    TextView txtNum1,txtNac1,txtTipo1,txtDoc1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        txtNum= getIntent().getStringExtra("numcel");
        txtNac=getIntent().getStringExtra("spinac");
        txtTipo=getIntent().getStringExtra("spitipo");
        txtDoc=getIntent().getStringExtra("numdoc");

        txtNum1=(TextView) findViewById(R.id.txtNumero);
        txtNac1=(TextView) findViewById(R.id.txtNac);
        txtTipo1=(TextView) findViewById(R.id.txtTipoDoc);
        txtDoc1=(TextView) findViewById(R.id.txtNroDoc);

        txtNum1.setText(txtNum);
        txtNac1.setText(txtNac);
        txtTipo1.setText(txtTipo);
        txtDoc1.setText(txtDoc);


    }
}
