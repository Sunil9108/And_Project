package com.techpalle.miniproject;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Reg extends Fragment {
    EditText e1,e2,e3,e4,e5,e6;
    Button b1,b2;


    public Reg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_reg, container, false);
        View v = inflater.inflate(R.layout.fragment_reg, container, false);
        e1 = v.findViewById(R.id.et_emp_no);
        e2 = v.findViewById(R.id.et_emp_name);
        e3 = v.findViewById(R.id.et_emp_email);
        e4 = v.findViewById(R.id.et_emp_pw);
        e5 = v.findViewById(R.id.et_emp_cpw);
        e6 = v.findViewById(R.id.et_emp_phint);
        b1 = v.findViewById(R.id.regbtn1);
        b2 = v.findViewById(R.id.logbtn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eno = e1.getText().toString();
                String ename = e2.getText().toString();
                String eemail = e3.getText().toString();
                String pw = e4.getText().toString();
                String cpw = e5.getText().toString();
                String phnt = e6.getText().toString();
                SharedPreferences sp = getActivity().getSharedPreferences("employee",0);
                SharedPreferences.Editor et = sp.edit();
                et.putString("eno",eno);
                et.putString("ename",ename);
                et.putString("eemail",eemail);
                et.putString("pw",pw);
                et.putString("cpw",cpw);
                et.putString("phnt",phnt);
                et.apply();
                Toast.makeText(getActivity(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");
                e6.setText("");
                e1.requestFocus();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
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
