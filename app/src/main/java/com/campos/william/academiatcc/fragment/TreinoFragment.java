package com.campos.william.academiatcc.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.campos.william.academiatcc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TreinoFragment extends Fragment {


    public TreinoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_treino, container, false);
    }

}
