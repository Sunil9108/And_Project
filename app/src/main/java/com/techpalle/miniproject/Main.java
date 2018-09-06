package com.techpalle.miniproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Main extends Fragment {
    CardView cc1,cc2,cc3,cc4;
    CardView iv1,iv2,iv3;
    String course;


    public Main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false);
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        cc1 = v.findViewById(R.id.cardView_be);
        cc2 = v.findViewById(R.id.cardView_bse);
        cc3 = v.findViewById(R.id.cardView_mba);
        cc4 = v.findViewById(R.id.cardView_mca);
        iv1 = v.findViewById(R.id.add_stu);
        iv2 = v.findViewById(R.id.srch_stu);
        iv3 = v.findViewById(R.id.delete_stu);
        final String ar[] = {"B.E","B.Sc","M.B.A","M.S"};
        cc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity ma = (MainActivity) getActivity();
                ma.searchFragScreen(ar[0]);
            }
        });
        cc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity ma = (MainActivity) getActivity();
                ma.searchFragScreen(ar[1]);
            }
        });
        cc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity ma = (MainActivity) getActivity();
                ma.searchFragScreen(ar[2]);
            }
        });
        cc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity ma = (MainActivity) getActivity();
                ma.searchFragScreen(ar[3]);
            }
        });

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity ma = (MainActivity) getActivity();
                ma.mainBottonbar();
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager m = getActivity().getSupportFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                Search sf = new Search();
                t.replace(R.id.container,sf);
                t.addToBackStack(null);
                t.commit();
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Comming Soon",Toast.LENGTH_SHORT).show();
            }
        });
        return v;

    }

}
