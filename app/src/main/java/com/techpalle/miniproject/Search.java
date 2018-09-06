package com.techpalle.miniproject;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Search extends Fragment {
    EditText e1;
    TextView t1;
    Button b1;
    MyDatabase md3;
    Cursor c;


    public Search() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_search, container, false);
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        e1 = v.findViewById(R.id.edit_Search_Name_ph);
        b1 = v.findViewById(R.id.name_srch_btn);
        t1 = v.findViewById(R.id.dispSearch);
        md3 = new MyDatabase(getActivity());
        md3.open();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namePh = e1.getText().toString();
                c = md3.queryCustom(namePh);
                if (c.getCount()>0) {
                    c.moveToNext();
                    String sname = c.getString(2);
                    String mobile = c.getString(3);
                    String date = c.getString(6);
                    t1.setText("Name : "+sname+"\n"+"Mobile : "+mobile+"\n"+"Date :"+date+"\n");
                }else{
                    Toast.makeText(getActivity(),"Student Not Found",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }

}
