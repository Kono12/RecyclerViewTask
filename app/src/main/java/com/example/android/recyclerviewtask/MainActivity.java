package com.example.android.recyclerviewtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.recyclerviewtask.DB.DataBase;
import com.example.android.recyclerviewtask.RecyclerView.Adapter;
import com.example.android.recyclerviewtask.RecyclerView.DataClass;
import com.example.android.recyclerviewtask.RecyclerView.RecyclerInterFace;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ArrayList<DataClass> arrayList;
    Adapter adapter;
    RecyclerView recyclerView;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.click);
        arrayList = new ArrayList<DataClass>();
        setDataBase();
        // setUpArrayList();
        getArrayListFromDataBase();
        setUpRecyclerView();
    }

    private void getArrayListFromDataBase() {
        arrayList = (ArrayList<DataClass>) dataBase.db_dao().getAll();
    }

    private void setDataBase() {
        dataBase = Room.databaseBuilder(getApplicationContext(), DataBase.class, "DataBase")
                .allowMainThreadQueries()
                .build();
    }

    private void setUpRecyclerView() {
        adapter = new Adapter(arrayList);
        adapter.setClick(new RecyclerInterFace() {
            @Override
            public void OnCkick(int position) {
                mediaPlayer.start();
                Intent i = new Intent(getApplicationContext(), Info.class)
                        .putExtra("title", arrayList.get(position).getTitle())
                        .putExtra("content", arrayList.get(position).getContent())
                        .putExtra("img", arrayList.get(position).getImg() + "");
                startActivity(i);
            }

            @Override
            public boolean OnLongClick(int position) {
                ConstraintLayout constraintLayout = findViewById(R.id.parentt);
                Snackbar.make(constraintLayout, arrayList.get(position).getTitle(), Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });


        recyclerView = findViewById(R.id.recycler_from_xml);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

    }

    private void setUpArrayList() {


        arrayList.add(new DataClass("That Man", "حسبي الله ونعم الوكيل", R.drawable.ragel));
        arrayList.add(new DataClass("Mo Salah", "انا جبت جون ", R.drawable.mosalah));
        arrayList.add(new DataClass("شفيق", "يارب اخلص", R.drawable.squid));


        arrayList.add(new DataClass("CAT Reloaded", "good job", R.drawable.catreloaded));
        arrayList.add(new DataClass("بكار", "مش لاقي رشيدة ", R.drawable.bkar));
        arrayList.add(new DataClass("Abu trika", "اذكر الله", R.drawable.abutrika));


        arrayList.add(new DataClass("shikabala", "يارب ", R.drawable.shikabala));
        arrayList.add(new DataClass("Google", "congrats", R.drawable.google));
        arrayList.add(new DataClass("هنيدي", "فينك ", R.drawable.mohamedhenedi));
        arrayList.add(new DataClass("Spongebob", "hahahaha", R.drawable.spongebob));


    }

    String title;
    String content;

    public void AddButtonClicked(View view) {


        AlertDialog.Builder dialogName = new AlertDialog.Builder(this);
        dialogName.setTitle("title");

        final EditText EditTxtName = new EditText(this);

        dialogName.setView(EditTxtName);

        dialogName.setPositiveButton("next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                title = EditTxtName.getText().toString();
                    nextDialog();
                dialogInterface.cancel();
            }
        });

        dialogName.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                content="";
                title="";
                dialogInterface.cancel();
            }
        });
        dialogName.show();


    }

    private void nextDialog() {


        AlertDialog.Builder dialogName = new AlertDialog.Builder(this);
        dialogName.setTitle("content");

        final EditText EditTxtName = new EditText(this);
        dialogName.setView(EditTxtName);

        dialogName.setPositiveButton("add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                content = EditTxtName.getText().toString();

                //add to dataBase
                dataBase.db_dao().Insert(new DataClass(title,content,R.drawable.spongebob));
                resetDataBase();


                dialogInterface.cancel();
            }
        });

        dialogName.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                content="";
                title="";
                dialogInterface.cancel();
            }
        });
        dialogName.show();

    }

    private void resetDataBase() {
        arrayList.clear();
        arrayList.addAll((ArrayList<DataClass>) dataBase.db_dao().getAll());
        adapter.notifyDataSetChanged();
    }
}