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
public class Login extends Fragment {
    EditText ee1,ee2,ee3;
    Button bb1,bb2;


    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_login, container, false);
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        SharedPreferences sp = getActivity().getSharedPreferences("employee",0);
        final String eemail = sp.getString("eemail",null);
        final String pw = sp.getString("pw",null);
        ee1 = v.findViewById(R.id.et_log_uname);
        ee2 = v.findViewById(R.id.et_log_pw);
        bb1 = v.findViewById(R.id.logbtn2);
        bb2 = v.findViewById(R.id.request_pw_btn);
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ee1_email = ee1.getText().toString();
                String ee2_pw = ee2.getText().toString();
                if (ee1_email.equals(eemail) && ee2_pw.equals(pw)){
                    FragmentManager m = getActivity().getSupportFragmentManager();
                    FragmentTransaction t = m.beginTransaction();
                    Main mf = new Main();
                    t.replace(R.id.container,mf);
                    t.addToBackStack(null);
                    t.commit();
                }else{
                    Toast.makeText(getActivity(),"Username & Password Mismatch",Toast.LENGTH_SHORT).show();
                }
            }
        });
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Coming Soon",Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}
