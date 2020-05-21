package Fragmentos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pit.appcoronavirus.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CiudadanoFragment2 extends Fragment {


    public CiudadanoFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ciudadano_fragment2, container, false);
    }

}
