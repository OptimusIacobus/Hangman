package com.example.supaj.hangman;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        Button btn = (Button) view.findViewById(R.id.begin);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                android.support.v4.app.FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                        ft.replace(R.id.frmain, new Hangman());
                        ft.commit();
            }

        });
    }

}
