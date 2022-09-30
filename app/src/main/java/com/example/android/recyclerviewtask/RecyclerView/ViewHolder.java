package com.example.android.recyclerviewtask.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.recyclerviewtask.MainActivity;
import com.example.android.recyclerviewtask.R;


public class ViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView content;
    ImageView img;

    public ViewHolder(@NonNull View itemView , RecyclerInterFace recyclerInterFace) {
        super(itemView);
         title = itemView.findViewById(R.id.title);
         content= itemView.findViewById(R.id.content);
         img= itemView.findViewById(R.id.image);
          itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  recyclerInterFace.OnCkick(getAdapterPosition());
                //  Toast.makeText(content.getContext(), title.getText(), Toast.LENGTH_SHORT).show();
              }
          });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                recyclerInterFace.OnLongClick(getAdapterPosition());
               return true;
               //  Toast.makeText(content.getContext(), title.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
