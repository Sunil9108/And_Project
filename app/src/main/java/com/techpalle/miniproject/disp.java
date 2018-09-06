package com.techpalle.miniproject;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class disp extends Fragment {
    MyDatabase md2;
    RecyclerView rv;
    LinearLayoutManager lm;
    MyAdapter m;
    Cursor c;
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = getActivity().getLayoutInflater().inflate(R.layout.row,parent,false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            c.moveToPosition(position);
            String sno = c.getString(1);
            String sname = c.getString(2);
            String mobile = c.getString(3);
            String course = c.getString(5);
            String date = c.getString(6);
            holder.t1.setText(sno);
            holder.t2.setText(sname);
            holder.t3.setText(mobile);
            holder.t4.setText(course);
            holder.t5.setText(date);
        }

        @Override
        public int getItemCount() {
            return c.getCount();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView t1,t2,t3,t4,t5;
            public ViewHolder(View itemView) {
                super(itemView);
                t1 = itemView.findViewById(R.id.textView1);
                t2 = itemView.findViewById(R.id.textView2);
                t3 = itemView.findViewById(R.id.textView3);
                t4 = itemView.findViewById(R.id.textView4);
                t5 = itemView.findViewById(R.id.textView5);
            }
        }
    }

    public disp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_disp, container, false);
        View v = inflater.inflate(R.layout.fragment_disp, container, false);
        rv = v.findViewById(R.id.recyclerView1);
        md2 = new MyDatabase(getActivity());
        md2.open();
        Bundle b = getArguments();
        String course = b.getString("course",null);
        c = md2.queryStudent(course);
        m = new MyAdapter();
        lm = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rv.setAdapter(m);
        rv.setLayoutManager(lm);
        return v;
    }

}
