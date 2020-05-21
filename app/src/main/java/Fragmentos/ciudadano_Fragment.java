package Fragmentos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pit.appcoronavirus.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ciudadano_Fragment extends Fragment {

    Button btnContinuar;

    public ciudadano_Fragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_ciudadano_, container, false);

        btnContinuar=(Button) v.findViewById(R.id.btnContinuar);

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CiudadanoFragment2 cf2=new CiudadanoFragment2();
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                ft.replace(R.id.bottomNavigation,cf2);
                ft.addToBackStack(null);
                ft.commit();


            }
        });

        return v;
    }


}
