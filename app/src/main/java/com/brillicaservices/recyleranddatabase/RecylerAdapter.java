package com.brillicaservices.recyleranddatabase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HIMANSHU CHUGH on 13-07-2018.
 */

public class RecylerAdapter extends RecyclerView.Adapter<
                    RecylerAdapter.StudentViewHolder> {

        private static final String TAG = RecylerAdapter.class.getName();

        private final ListItemClickListener itemClickListener;

        private static int viewHolderCount;

        private ArrayList<Student> studentModelArrayList;

        public interface ListItemClickListener {
            void onListItemClickListener(int clickedItemIndex);
        }

        public RecylerAdapter(ArrayList<Student> studentModelArrayList,
                               ListItemClickListener itemClickListener) {
            this.studentModelArrayList = studentModelArrayList;
            this.itemClickListener = itemClickListener;
            viewHolderCount = 0;
        }

        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                    int viewType) {

            LayoutInflater inflater =
                    LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(
                    R.layout.listitem,
                    parent,
                    false);

            StudentViewHolder studentViewHolder =
                    new StudentViewHolder(view);




            return studentViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecylerAdapter.StudentViewHolder holder,
                                     int position) {
            Student student = studentModelArrayList.get(position);
            holder.studentName.setText("Name is: " + student.studentName);
            holder.address.setText("Address is: " + student.addName);
            holder.pho.setText("Phonenumber is: " + student.ph);

        }

        @Override
        public int getItemCount() {
            return studentModelArrayList.size();
        }

        public class StudentViewHolder extends
                RecyclerView.ViewHolder
                implements View.OnClickListener{

            TextView studentName;
            TextView pho;
            TextView address;

            public StudentViewHolder(View itemView) {
                super(itemView);

                studentName = itemView.findViewById(R.id.student_name);
                pho = itemView.findViewById(R.id.phone1233);
                address = itemView.findViewById(R.id.addressValue);



                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                int clickedPosition = getAdapterPosition();
                itemClickListener.onListItemClickListener(clickedPosition);
            }
        }
    }

