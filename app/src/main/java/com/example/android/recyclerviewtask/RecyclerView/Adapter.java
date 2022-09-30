package com.example.android.recyclerviewtask.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.recyclerviewtask.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList<DataClass> arrayList = new ArrayList<DataClass>() ;
    String TAG= "mohamedEmad";
    private RecyclerInterFace recyclerInterFace;


    public Adapter(ArrayList<DataClass> arrayList){
        this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_card,parent,false),recyclerInterFace);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       DataClass object = arrayList.get(position);
       holder.title.setText(object.Title);
       holder.content.setText(object.Content);
       holder.img.setImageResource(object.img);
    }

    @Override
    public int getItemCount() {return arrayList.size();}

    public void setOnClick(RecyclerInterFace recyclerInterFace){
        this.recyclerInterFace=recyclerInterFace;
    }
}
