package com.example.myrealmproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MViewHolder> {
    private RealmResults<Student> realmResults;
    private Context mcontext;
    private int count;

    public MyAdapter(RealmResults<Student> students, Context context) {
        realmResults = students;
        mcontext = context;
        count = 0;
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycleview, parent, false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {
        Student student = realmResults.get(position);
        holder.name.setText(student.getName());
        holder.dept.setText(student.getDept());
        holder.phone.setText(String.valueOf(student.getPhone()));
        holder.roll.setText("Roll No. : " + String.valueOf(student.getRoll()));
        holder.gender.setText(student.getGender());

    }

    @Override
    public int getItemCount() {
        return realmResults.size();
    }

    public class MViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView phone;
        private TextView roll;
        private TextView dept;
        private TextView gender;

        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            count++;
            name = itemView.findViewById(R.id.textView9);
            dept = itemView.findViewById(R.id.textView10);
            phone = itemView.findViewById(R.id.textView11);
            gender = itemView.findViewById(R.id.textView12);
            roll = itemView.findViewById(R.id.textView13);

        }
    }
}
