package com.example.abhij.restapiconnection;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhij on 31-03-2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder>{

    public interface OnItemClickedListener{
        public void onClick(int position);
    }

    private ArrayList<Student> list;
    private OnItemClickedListener listener;
    private Context context;

    public RecyclerAdapter(Context context, ArrayList<Student> list, OnItemClickedListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }



    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater =  (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.list_item,parent,false);
        Holder holder= new Holder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.roll.setText(list.get(position).getRoll()+"");
        holder.percentage.setText(list.get(position).getPercentage()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(holder.getAdapterPosition());
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //    public ArrayList<Student> list

    class Holder extends RecyclerView.ViewHolder {



        TextView name;
        TextView roll;
        TextView percentage;

        View itemView;

        public Holder(View itemView) {
            super(itemView);

            this.itemView = itemView;
            name= itemView.findViewById(R.id.text_name);
            roll= itemView.findViewById(R.id.text_roll);
            percentage= itemView.findViewById(R.id.text_percentage);
        }
    }
}
