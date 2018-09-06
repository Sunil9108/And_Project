package com.techpalle.miniproject;

import android.database.Cursor;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyDatabase mdb;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdb = new MyDatabase(this);
        mdb.open();
        c = mdb.queryTable();
        FragmentManager m = getSupportFragmentManager();
        FragmentTransaction t = m.beginTransaction();
        welcome wf = new welcome();
        t.add(R.id.container,wf);
        t.commit();
    }

    public void searchFragScreen(String course){
        FragmentManager m = getSupportFragmentManager();
        FragmentTransaction t = m.beginTransaction();
        disp df = new disp();
        Bundle b = new Bundle();
        b.putString("course",course);
        df.setArguments(b);
        t.replace(R.id.container,df);
        t.addToBackStack(null);
        t.commit();
    }

    public void mainBottonbar(){
        FragmentManager m = getSupportFragmentManager();
        FragmentTransaction t = m.beginTransaction();
        Stud sf = new Stud();
        t.replace(R.id.container,sf);
        t.addToBackStack(null);
        t.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mdb != null){
            mdb.close();
        }
    }
}
