package Fragmentos;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.pit.appcoronavirus.R;
import com.pit.appcoronavirus.Regciudadano;

/**
 * A simple {@link Fragment} subclass.
 */
public class TriajeFragment extends Fragment {


    public TriajeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Obtener la vista
        View v= inflater.inflate(R.layout.fragment_triaje, container, false);

        //Encontrar el boton del fragment
        Button btnTriaje=(Button) v.findViewById(R.id.btnRegTriaje);

        //Generar el evento click listener
        btnTriaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Regciudadano.class);
                startActivity(intent);
            }
        });

        //Retorna la vista
        return v;

    }

}
