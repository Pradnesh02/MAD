package com.example.studentlistapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    Context context;
    ArrayList<Student> studentList;

    public StudentAdapter(Context context, ArrayList<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.row_item, parent, false);
        }

        TextView tvName =
                convertView.findViewById(R.id.tvName);
        TextView tvRoll =
                convertView.findViewById(R.id.tvRoll);
        TextView tvPhone =
                convertView.findViewById(R.id.tvPhone);
        Button btnCall =
                convertView.findViewById(R.id.btnCall);

        Student student = studentList.get(position);

        tvName.setText("Name: " + student.getName());
        tvRoll.setText("Roll: " + student.getRoll());
        tvPhone.setText("Phone: " + student.getPhone());

        btnCall.setOnClickListener(v -> {
            Intent intent =
                    new Intent(Intent.ACTION_DIAL);
            intent.setData(
                    Uri.parse("tel:" + student.getPhone()));
            context.startActivity(intent);
        });

        return convertView;
    }
}