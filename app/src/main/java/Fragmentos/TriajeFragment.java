package Fragmentos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.pit.appcoronavirus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TriajeFragment extends Fragment {

    //Declariacion de objetos
    CheckBox chktos,chkfiebre,chkcansancio,chkrespirar,chkcontacto;
    Button btnregistrar;

    public TriajeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_triaje, container, false);




    }

}
