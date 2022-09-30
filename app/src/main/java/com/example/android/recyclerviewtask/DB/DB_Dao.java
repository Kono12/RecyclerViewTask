package com.example.android.recyclerviewtask.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.android.recyclerviewtask.RecyclerView.DataClass;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DB_Dao {

    @Query("Select * FROM DataClass")
    List<DataClass> getAll();

    @Delete
    void DeleteData(DataClass dataClass);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(DataClass dataClass);

}
