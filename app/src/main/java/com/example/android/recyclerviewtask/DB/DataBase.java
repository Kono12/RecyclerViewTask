package com.example.android.recyclerviewtask.DB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.android.recyclerviewtask.RecyclerView.DataClass;

@Database(entities = DataClass.class,version = 1)
public abstract class DataBase extends RoomDatabase {

    private static DataBase instance;

    public abstract DB_Dao db_dao();

    public static synchronized DataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), DataBase.class, "DataBase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
