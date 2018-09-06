package com.techpalle.miniproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class welcome extends Fragment {
    CardView c1,c2;


    public welcome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_welcome, container, false);
        View v = inflater.inflate(R.layout.fragment_welcome, container, false);
        c1 = v.findViewById(R.id.regCardView1);
        c2 = v.findViewById(R.id.logCardView1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager m = getActivity().getSupportFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                Reg rf = new Reg();
                t.replace(R.id.container,rf);
                t.addToBackStack(null);
                t.commit();
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager m = getActivity().getSupportFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                Login lf = new Login();
                t.replace(R.id.container,lf);
                t.addToBackStack(null);
                t.commit();
            }
        });
        return v;

    }

}
