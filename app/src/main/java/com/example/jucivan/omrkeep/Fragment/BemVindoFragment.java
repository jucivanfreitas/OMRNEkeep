package com.example.jucivan.omrkeep.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jucivan.omrkeep.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BemVindoFragment extends Fragment {


    public BemVindoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bem_vindo, container, false);
    }

}
