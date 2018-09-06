package com.techpalle.miniproject;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Stud extends Fragment {
    EditText e1,e2,e3,e4,e5;
    TextView t1;
    Button b1,b2;
    MyDatabase md1;
    Spinner sp;
    String item;
    ArrayList<String> al;


    public Stud() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_stud, container, false);
        View v = inflater.inflate(R.layout.fragment_stud, container, false);
        e1 = v.findViewById(R.id.et_stu_no);
        e2 = v.findViewById(R.id.et_stu_name);
        e3 = v.findViewById(R.id.et_stu_mobile);
        e4 = v.findViewById(R.id.et_stu_email);
        //e5 = v.findViewById(R.id.et_stu_course);
        sp = v.findViewById(R.id.spinner1);
        al = new ArrayList<String>();
        al.add("B.E");
        al.add("B.Sc");
        al.add("M.C.A");
        al.add("M.S");
        t1 = v.findViewById(R.id.stu_date);
        md1 = new MyDatabase(getActivity());
        md1.open();
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,al);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item = sp.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        b1 = v.findViewById(R.id.stu_savebtn);
        b2 = v.findViewById(R.id.stu_backbtn);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        t1.setText(i2+"/"+(i1+1)+"/"+i);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sno = e1.getText().toString();
                String sname = e2.getText().toString();
                String mobile = e3.getText().toString();
                String email = e4.getText().toString();
                String course = item;
                String date = t1.getText().toString();
                Log.d("Spinner","course :"+item);
                md1.insertStudent(sno,sname,mobile,email,course,date);
                Toast.makeText(getActivity(),"Student Added Successfully",Toast.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                t1.setText("");
                e1.requestFocus();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"coming soon",Toast.LENGTH_SHORT).show();
                FragmentManager m = getActivity().getSupportFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                t.addToBackStack(null);
                t.commit();
            }
        });

        return v;

    }

}
