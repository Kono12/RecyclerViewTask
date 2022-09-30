package com.example.android.recyclerviewtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class Info extends AppCompatActivity {
    String title,content;
    int img;
    ImageView imageView;
    TextView Title;
    TextView Content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        title=intent.getStringExtra("title");
        content=intent.getStringExtra("content");
        img=Integer.parseInt(intent.getStringExtra("img"));
        imageView=findViewById(R.id.infoimg);
        imageView.setImageResource(img);
        Title=findViewById(R.id.infoTitle);
        Title.setText(title);
        Content=findViewById(R.id.infoContent);
        Content.setText(content);

    }
}